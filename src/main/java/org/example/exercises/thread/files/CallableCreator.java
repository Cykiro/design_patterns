package org.example.exercises.thread.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class CallableCreator implements Callable<Integer> {


    private String fileName;

    public CallableCreator(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Integer call() throws FileNotFoundException, InterruptedException {

     //   System.out.println(fileName + "," + LocalDateTime.now());
        File myObj = new File(fileName);
        Scanner myReader = new Scanner(myObj);
        int result = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            for (int d = 0; d < data.length(); d++) {
                if (data.charAt(d) < 48 || data.charAt(d) > 57) {
                    result++;
                }

            }
        }
        myReader.close();


        return result;
    }
}
