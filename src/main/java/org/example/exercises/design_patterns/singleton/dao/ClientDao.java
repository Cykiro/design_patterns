package org.example.exercises.design_patterns.singleton.dao;

import org.example.exercises.design_patterns.singleton.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientDao {
    List<Client> getAllClients();
    Optional<Client> save(Client client);
    void delete(Client client);
    void update(Client client);
    Client getClient(String userId);
}
