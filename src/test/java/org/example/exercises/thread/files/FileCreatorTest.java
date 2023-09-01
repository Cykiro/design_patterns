package org.example.exercises.thread.files;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.time.LocalDateTime;

class FileCreatorTest {
    @Test
    public void testMulti() throws IOException, InterruptedException {
        Assertions.assertThat(MultiManager.multiManager()).isEqualTo(10);
    }

    @Test
    public void testSingle() throws IOException, InterruptedException {
        Assertions.assertThat(SingleManager.singleManager()).isEqualTo(10);
    }

    @Test
    public void compareSingleAndMulti() throws IOException, InterruptedException {
        long result1 = System.currentTimeMillis();
        MultiManager.multiManager();
        long result2 = System.currentTimeMillis();
        long multiThreadExecutionTime = (result2 - result1);

        result1 = System.currentTimeMillis();
        SingleManager.singleManager();
        result2 = System.currentTimeMillis();
        long singleThreadExecutionTime = (result2 - result1);

        Assertions.assertThat(multiThreadExecutionTime < singleThreadExecutionTime).isTrue();
    }


    @BeforeAll
    public static void before() throws IOException {

        FileCreator fileCreatorTest = new FileCreator();
        fileCreatorTest.createFile();
        fileCreatorTest.fillFiles();
    }

    @AfterAll
    public static void after() throws IOException, InterruptedException {
        FileCreator fileCreatorTest = new FileCreator();
        fileCreatorTest.deleteFile();
    }


}