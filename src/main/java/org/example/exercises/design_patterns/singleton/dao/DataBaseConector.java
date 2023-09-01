package org.example.exercises.design_patterns.singleton.dao;

import org.example.exercises.design_patterns.singleton.model.Client;
import org.example.exercises.design_patterns.singleton.util.JacksonHelper;
import org.example.exercises.design_patterns.singleton.util.TransferManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class DataBaseConector implements ClientDao {
    private static DataBaseConector instance;
    private final File file = new File("src\\main\\resources\\DataBase");
    private final AtomicInteger money = new AtomicInteger(0);

    private DataBaseConector() {
    }

    public static DataBaseConector getInstance() {
        synchronized (DataBaseConector.class) {
            if (instance == null) {
                instance = new DataBaseConector();
            }
            return instance;
        }
    }

    public Optional<Client> login(String userId, String password) {
        List<Client> list = getAllClients();
        if (list.stream().anyMatch(o -> o.getUserId().equals(userId))) {
            Optional<Client> client = list.stream().filter(o -> o.getUserId().equals(userId)).findFirst();

            if (client.get().getPassword().equals(password)) {
                return client;
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Client> getAllClients() {
        Path path = Paths.get(file.getPath());
        List<Client> list = new ArrayList<>();
        try {
            String string = Files.readString(path);
            list = JacksonHelper.convertStringToObject(string);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return list;
    }

    public TransferManager makeTransfer(Optional<Client> client) {
        if (client.isEmpty()) {
            throw new RuntimeException("User does not exist");
        }
        return new TransferManager(client.get());

    }

    @Override
    public Client getClient(String userId) {
        List<Client> allClients = getAllClients();
        Optional<Client> clientSearched = allClients.stream().filter(o -> o.getUserId().equals(userId)).findFirst();
        if (clientSearched.isPresent()) {
            return clientSearched.get();
        } else {
            throw new RuntimeException("User id not found");
        }
    }

    @Override
    public Optional<Client> save(Client client) {
        try {
            List<Client> allClients = getAllClients();
            if (!allClients.stream().anyMatch(o -> o.getUserId().equals(client.getUserId()))) {
                FileWriter writer = new FileWriter(file);
                allClients.add(client);
                writer.write(JacksonHelper.convertObjectToString(allClients));
                writer.close();
            } else {
                throw new RuntimeException("This user id already exist");
            }
        } catch (IOException e) {
            //log.error
            return Optional.empty();
        }
        return Optional.of(client);
    }

    @Override
    public void delete(Client client) {
        List<Client> allClients = getAllClients();
        if (allClients.stream().anyMatch(o -> o.getUserId().equals(client.getUserId()))) {
            allClients.removeIf(client2 -> client2.getUserId().equals(client.getUserId()));
        } else {
            throw new RuntimeException("This user not exist");
        }
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(JacksonHelper.convertObjectToString(allClients));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Client clientGiven) {
        List<Client> allClients = getAllClients();
        Optional<Client> clientSearched = allClients.stream().filter(o -> o.getUserId().equals(clientGiven.getUserId())).findFirst();
        if (clientSearched.isPresent()) {
            allClients.remove(clientSearched.get());
            allClients.add(clientGiven);
        } else {
            throw new RuntimeException("User id not found");
        }
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(JacksonHelper.convertObjectToString(allClients));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
