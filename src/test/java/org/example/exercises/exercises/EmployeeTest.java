package org.example.exercises.exercises;

import org.example.exercises.exercises.Developer;
import org.example.exercises.exercises.Employee;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class EmployeeTest {
    @Test
    public void shouldCreateEmployee(){
        Employee developer =  new Developer("David",12);
        Employee priest = new Employee("Jone",16) {
            @Override
            public String doJob() {
                return "pray";
            }
        };
        developer.drinkWater();

        assertThat(developer.doJob()).isEqualTo("Write code");
        assertThat(priest.doJob()).isEqualTo("pray");
    }

}