package com.practicalunittesting.chp5Tdd;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Veezq on 2015-10-31.
 */
public class RaceResultsService {

    private Set<Client> clients = new HashSet<>();

    public void addSubscriber(Client client) {
        clients.add(client);
    }

    public void send(Message message) {
        clients.forEach(client -> client.receive(message));
    }

    public void removeSubscriber(Client client) {
        clients.remove(client);
    }
}
