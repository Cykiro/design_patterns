package org.example.exercises.exercises;

import org.example.exercises.exercises.Animal;
import org.example.exercises.exercises.Cat;
import org.example.exercises.exercises.Dog;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class AnimalTest {
    @Test
    public void shouldReturnSound(){
        Animal cat = new Cat();
        assertThat(cat.sound()).isEqualTo("miau");
        Animal dog = new Dog();
        assertThat(dog.sound()).isEqualTo("woof");
        Animal cow = new Animal() {
            @Override
            public String sound() {
                return "muu";
            }
        };

        assertThat(cow.sound()).isEqualTo("muu");
    }

}