package org.example.exercises.thread;

import java.io.File;
import java.io.IOException;

public class ExecutorServiceManager {

    public void method() throws IOException {
        File plik = new File("plik.txt");
        System.out.println(plik.createNewFile());

    }
}
