package org.example.exercises.design_patterns.decorator_file;

import org.example.exercises.design_patterns.decorator_file.decorators.CompressionDecorator;
import org.example.exercises.design_patterns.decorator_file.decorators.MD5Decorator;
import org.example.exercises.design_patterns.decorator_file.interfaces.DataSource;
import org.example.exercises.design_patterns.decorator_file.util.FileDataSource;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SalaryManagerTest {
    @Test
    public void shouldCompressData(){
        SalaryManager salaryManager = new SalaryManager(new CompressionDecorator(new FileDataSource("src\\main\\resources\\SalaryManagerCompression.txt")));
        String string ="Dominik Mida";
        salaryManager.save(string);
        DataSource source = new FileDataSource("src\\main\\resources\\SalaryManagerCompression.txt");
        assertThat(source.readData()).isEqualTo("eJxzyc/NzMvMVvDNTEkEABz9BGc=");

        assertThat(salaryManager.load()).isEqualTo(string);


    }
    @Test
    public void shouldEncryptData(){
        SalaryManager salaryManager = new SalaryManager(new MD5Decorator(new FileDataSource("src\\main\\resources\\SalaryManagerCompression.txt")));
        String string ="Dominik Mida";
        salaryManager.save(string);
        DataSource source = new FileDataSource("src\\main\\resources\\SalaryManagerCompression.txt");
        System.out.println(source.readData());


    }
}