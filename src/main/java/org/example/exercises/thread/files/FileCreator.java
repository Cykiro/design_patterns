package org.example.exercises.thread.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {
    public void createFile() throws IOException {
        String name = null;
        for (int i = 0; i < 10; i++) {
            name = Integer.toString(i + 1);
            File plik = new File("file" + name + ".txt");
            plik.createNewFile();
        }
    }
    public void deleteFile(){
        String name = null;
        for (int i = 0; i < 10; i++) {
            name = Integer.toString(i + 1);
            File plik = new File("file" + name + ".txt");
            plik.delete();
        }
    }
    public void fillFiles() throws IOException {
        String name = null;
        for (int i = 0; i < 10; i++) {
            name = Integer.toString(i + 1);
            File plik = new File("file" + name + ".txt");


            FileWriter writer =new FileWriter( plik);
            int random1 =(int)(Math.random() * 10000);
            int random2 =(int)(Math.random() * 2000);
            for(int c=0;c<10000;c++) {
                for(int d=0;d<2000;d++) {
                    if(c!=random1 || d!=random2) {
                        int randomValue = (int) (Math.random() * 10);
                        writer.write(String.valueOf(randomValue));
                    } else{
                        char randomValue = 'a';
                        writer.write(randomValue);
                    }
                }
                writer.write("\n");
            }
            writer.close();

        }

    }

}
