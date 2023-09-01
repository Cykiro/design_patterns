package org.example.exercises.synchronize;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedManager {
    private AtomicInteger result = new AtomicInteger(0);

    public int getResult() {
        return result.get();

    }


    public void increaseValue(){
                result.getAndIncrement();
          //  setResult(getResult() + 1);

    }
}
