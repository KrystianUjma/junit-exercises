package com.practicalunittesting.chp5Tdd;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Veezq on 2015-10-31.
 */
public class RaceResultsService {

  private static Map<Topic,Set<Client>> topicsClients = new HashMap();
  private Logger logger;

  static {
    for(Topic topic : Topic.values()){
      topicsClients.put(topic, new HashSet<>());
    }
  }

    public void addSubscriber(Client client) {
      addSubscriber(client, Topic.DEFAULT);
    }

    public void send(Message message) {
      sendOnTopics(message, Topic.DEFAULT);
    }

    public void removeSubscriber(Client clientToRemove) {
//      Client client2 = topicsClients.entrySet().stream()
//              .filter(entry -> entry.getKey().equals(Topic.DEFAULT))
//              .forEach(entry -> entry.getValue()
//                      .stream()
//                      .filter(client -> client.equals(client)).forEach(client -> topicsClients.remove(client));

    boolean found = false;

    Set<Map.Entry<Topic, Set<Client>>> entries = topicsClients.entrySet();
    for(Map.Entry<Topic, Set<Client>> entry : entries){
      if(entry.getKey().equals(Topic.DEFAULT) && !entry.getValue().isEmpty()){
        entry.getValue().remove(clientToRemove);
        found = true;
      }
    }

    if(!found){
      throw new IllegalStateException("trying to unsubcribe not subcribed client");
    }

    }

  public void addSubscriber(Client client, Topic topic) {
    Set<Client> clients = topicsClients.get(topic);
    clients.add(client);
  }

  public void sendOnTopics(Message message, Topic topicToSendOn) {
//    Set<Map.Entry<Topic, Set<Client>>> entries = topicsClients.entrySet();
//    for(Map.Entry<Topic, Set<Client>> entry : entries){
//      Set<Client> clients = entry.getValue();
//      Topic actuallTopic = entry.getKey();
//      if(topic.equals(actuallTopic)){
//        clients.forEach(client -> client.receive(message));
//      }
//    }

    topicsClients.entrySet().stream()
                            .filter(entry -> isTopicToSendOn(entry, topicToSendOn))
                            .forEach(entry -> entry.getValue()
                                                    .stream()
                                                    .forEach(client -> {
                                                      client.receive(message);
                                                      logger.log(message, 1l);
                                                    }));

  }

  public boolean isTopicToSendOn(Map.Entry<Topic,Set<Client>> entry, Topic topicToSendOn){
   return entry.getKey().equals(topicToSendOn);
  }

  public void setLogger(Logger logger) {
    this.logger = logger;
  }
}
