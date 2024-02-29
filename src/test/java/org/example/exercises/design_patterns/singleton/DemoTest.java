package org.example.exercises.design_patterns.singleton;

import org.example.exercises.design_patterns.singleton.dao.DataBaseConector;
import org.example.exercises.design_patterns.singleton.model.Client;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DemoTest {
    DataBaseConector dataBaseConector = DataBaseConector.getInstance();

    @Test
    void shouldDeleteNotExistingClieng() {
        Client client = new Client("12418924124312133126", "haslo1");

        Exception exception = assertThrows(RuntimeException.class, () -> {
            dataBaseConector.delete(client);
        });

        String expectedMessage = "This user not exist";
        String actualMessage = exception.getMessage();
        assertThat(expectedMessage).isEqualTo(actualMessage);
    }

    @Test
    public void shouldCreateClient() {
        Client client = new Client("1241892412124146", "haslo2");

        Optional<Client> saved = dataBaseConector.save(client);

        assertThat(saved.isPresent()).isTrue();

        dataBaseConector.delete(client);
    }

    @Test
    public void clientExistBeforeCreating() {
        Client client = new Client("124189241246", "haslo1");
        dataBaseConector.save(client);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            dataBaseConector.save(client);
        });

        String expectedMessage = "This user id already exist";
        String actualMessage = exception.getMessage();
        assertThat(expectedMessage).isEqualTo(actualMessage);

        dataBaseConector.delete(client);
    }

    @Test
    public void shouldReturnAllClients() {
        Client client = new Client("124189241246", "haslo1");
        Client client2 = new Client("1241892412461", "haslo1");
        dataBaseConector.save(client);
        dataBaseConector.save(client2);

        List<Client> allClients = dataBaseConector.getAllClients();
        assertThat(allClients.size()).isEqualTo(2);

        dataBaseConector.delete(client);
        dataBaseConector.delete(client2);
    }

    @Test
    public void shouldConnectToDataBaseAndUpdateClient() {
        Client client = new Client("1241892412461", "haslo1");
        Optional<Client> saved = dataBaseConector.save(client);

        assertThat(saved.isPresent()).isTrue();
        assertThat(saved.get().getMoney()).isEqualTo(BigDecimal.valueOf(0));
        client.setMoney(BigDecimal.valueOf(10));
        dataBaseConector.update(client);
        assertThat(saved.get().getMoney()).isEqualTo(BigDecimal.valueOf(10));

        dataBaseConector.delete(client);
    }

    @Test
    public void shouldLoginToClientAndChangeMoney() {
        dataBaseConector.save(new Client("1241892412461", "haslo1"));
        Optional<Client> client = dataBaseConector.login("1241892412461", "haslo1");

        dataBaseConector.makeTransfer(client).increase(BigDecimal.valueOf(200));
        Client client1 = dataBaseConector.getClient("1241892412461");

        assertThat(client1.getMoney()).isEqualTo(BigDecimal.valueOf(200));

        dataBaseConector.makeTransfer(client).decrease(BigDecimal.valueOf(100));
        client1 = dataBaseConector.getClient("1241892412461");

        assertThat(client1.getMoney()).isEqualTo(BigDecimal.valueOf(100));

        dataBaseConector.delete(client1);
    }

    @Test
    public void shouldAddMoneyToAccount() {
        List<Client> clients = runThreads(12);
        for (Client client : clients) {
            assertThat(client.getMoney()).isEqualTo(BigDecimal.valueOf(2000));
            dataBaseConector.delete(client);
        }
    }

    private List<Client> runThreads(int numberOfClients) {
        List<Client> clients = prepareClients(numberOfClients);

        ExecutorService executor = Executors.newFixedThreadPool(100);
        List<Callable<Client>> callableTasks = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            clients.forEach(client -> callableTasks.add(new ThreadMoneyIncrease(client)));
        }
        try {
            executor.invokeAll(callableTasks);
            executor.shutdownNow();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }

    private List<Client> prepareClients(int numberOfClients) {
        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < numberOfClients; i++) {
            String data = UUID.randomUUID().toString();
            Client client = new Client(data, data);
            clients.add(client);
            dataBaseConector.save(client);
        }
        return clients;
    }

    class ThreadMoneyIncrease implements Callable {
        Client client;

        public ThreadMoneyIncrease(Client client) {
            this.client = client;
        }


        @Override
        public Object call() {
            dataBaseConector.makeTransfer(Optional.of(client)).increase(BigDecimal.valueOf(20));
            return null;
        }
    }
}