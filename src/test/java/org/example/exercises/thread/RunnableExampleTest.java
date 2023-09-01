package org.example.exercises.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

class RunnableExampleTest extends Thread {
    private static int number = 0;

    @Test
    public void testRunnableExample() {
        RunnableExample runnableExample = new RunnableExample();
        runnableExample.call();
    }

    @Override
    public void run() {
        number++;
    }


    //mamy 500 plikow maja duze rozmiary i musimy zlanezc fraze w tym pliku wiec mozemy rodzielic zadanie na rozne watki
    //executorservice lepiej zarzada watkami

    //kolejny wzorzec projektowy
    //parametryzowany testy do obiektow - dodac obiekt stolek kawowy
    //poczytac o wyjatkach
}