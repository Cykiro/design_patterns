package org.example.exercises.synchronize;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class SynchronizedManagerTest {
    @Test
    public void testMultiThreadWhenNonSyncMethod() throws InterruptedException {
        ExecutorService executorService =  Executors.newFixedThreadPool(3);
        SynchronizedManager synchronizedManager = new SynchronizedManager();
        IntStream.range(0,1000)
                .forEach(value -> executorService.submit(synchronizedManager::increaseValue));
        executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);
        Assertions.assertThat(synchronizedManager.getResult()).isEqualTo(1000);

    }

}