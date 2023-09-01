package org.example.exercises.thread.files;

import java.io.FileNotFoundException;

public class SingleManager {
    public static int singleManager() throws FileNotFoundException, InterruptedException {
        int result=0;
        for(int i=1;i<=10;i++) {
            result+= new CallableCreator("file"+i+".txt").call();
        }
        return result;
    }
}
