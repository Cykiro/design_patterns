package org.example.exercises.design_patterns.singleton.util;

import org.example.exercises.design_patterns.singleton.dao.DataBaseConector;
import org.example.exercises.design_patterns.singleton.model.Client;

import java.math.BigDecimal;

public class TransferManager {

    private DataBaseConector dataBaseConector = DataBaseConector.getInstance();
    private Client client;

    public TransferManager(Client client) {
        this.client = client;
    }
    public void increase(BigDecimal bigDecimal){
        synchronized (TransferManager.class) {
            client.setMoney(client.getMoney().add(bigDecimal));
            dataBaseConector.update(client);
        }
    }
    public void decrease(BigDecimal bigDecimal){
        synchronized (TransferManager.class) {
            client.setMoney(client.getMoney().subtract(bigDecimal));
            dataBaseConector.update(client);
        }
    }
}
