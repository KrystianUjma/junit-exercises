package com.practicalunittesting.chp5Tdd;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

/**
 * Created by Veezq on 2015-10-31.
 */
public class RaceResultsServiceTest {

    private RaceResultsService raceResults = new RaceResultsService();
    private Message message = mock(Message.class);
    private Client clientA = mock(Client.class, "clientA");
    private Client clientB = mock(Client.class, "clientB");
    private Logger logger = mock(Logger.class);

    @Test
    public void notSubscribedClientShouldNotReceiveMessage() {
        raceResults.send(message);
        verify(clientA, never()).receive(message);
        verify(clientB, never()).receive(message);
    }

    @Test
    public void subscribedClientShouldReceiveMessage(){
        raceResults.addSubscriber(clientA);
        raceResults.send(message);

        verify(clientA).receive(message);
    }

    @Test
    public void messageShouldBeSentToAllSubscibedClients(){
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientB);
        raceResults.send(message);

        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }

    @Test
    public void shouldSendOnlyOneMessageToMultiSubscriber() {
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientA);
        raceResults.send(message);
        verify(clientA).receive(message);
    }

    @Test
    public void unsubscribedClientShouldNotReceiveMessages() {
        raceResults.addSubscriber(clientA);
        raceResults.removeSubscriber(clientA);
        raceResults.send(message);
        verify(clientA, never()).receive(message);
    }

  @Test
  public void shouldSendMessageOnSubscibedTopicOnly(){
    raceResults.addSubscriber(clientA, Topic.HORSE_RACES);

    raceResults.sendOnTopics(message, Topic.HORSE_RACES);

    verify(clientA).receive(message);
    verify(clientB, never()).receive(message);

  }

  @Test
  public void shouldLogMessage(){
    raceResults.addSubscriber(clientA, Topic.HORSE_RACES);
    raceResults.setLogger(logger);

    raceResults.sendOnTopics(message, Topic.HORSE_RACES);

    verify(clientA).receive(message);
    verify(logger).log(message, 1l);
  }

  @Test
  public void shouldReceive3Messages(){
    raceResults.addSubscriber(clientA, Topic.HORSE_RACES);

    for(int i = 0; i < 3; i++){
      raceResults.sendOnTopics(message, Topic.HORSE_RACES);
    }

    verify(clientA, times(3)).receive(message);

  }

  @Test(expected = IllegalStateException.class)
  public void unsubcribeNotSubscibedClient(){
    raceResults.removeSubscriber(clientA);
  }




}
