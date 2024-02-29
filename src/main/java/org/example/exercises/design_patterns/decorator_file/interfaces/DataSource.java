package org.example.exercises.design_patterns.decorator_file.interfaces;


public interface DataSource {
    void writeData(String data);

    String readData();
}