package org.example.exercises.design_patterns.decorator_file;


import org.example.exercises.design_patterns.decorator_file.decorators.CompressionDecorator;
import org.example.exercises.design_patterns.decorator_file.decorators.DataSourceDecorator;
import org.example.exercises.design_patterns.decorator_file.decorators.EncryptionDecorator;
import org.example.exercises.design_patterns.decorator_file.interfaces.DataSource;
import org.example.exercises.design_patterns.decorator_file.util.FileDataSource;

public class Demo {
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(new EncryptionDecorator(new FileDataSource("OutputDemo.txt")));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("OutputDemo.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }
}