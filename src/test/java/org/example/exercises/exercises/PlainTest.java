package org.example.exercises.exercises;
import org.example.exercises.exercises.Plain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlainTest {
    @Test
    public void shouldReturnTrue(){
        //inicjalizujaca
        Plain plain = new Plain();
        //run code
        boolean result = plain.checkIfYouAreAdult(19);
        //asercja
        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueStatic(){
        //run code
        boolean result = Plain.checkIfYouAreAdultStatic(19);
        //asercja
        assertTrue(result);
    }
}