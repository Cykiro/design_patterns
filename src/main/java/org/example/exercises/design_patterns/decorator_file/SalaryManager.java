package org.example.exercises.design_patterns.decorator_file;


import org.example.exercises.design_patterns.decorator_file.interfaces.DataSource;

public class SalaryManager {
    private DataSource source;

    public SalaryManager(DataSource source) {
        this.source = source;
    }

    public String load() {
        return source.readData();
    }

    public void save(String string) {
        source.writeData(string);
    }

}
