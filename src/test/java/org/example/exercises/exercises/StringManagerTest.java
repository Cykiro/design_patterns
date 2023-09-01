package org.example.exercises.exercises;
import org.example.exercises.exercises.Pair;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.*;
import static org.example.exercises.exercises.StringManager.*;
import static org.junit.jupiter.api.Assertions.*;

class StringManagerTest {
    @Test
    public void shouldReturnReversedString() {
        String result = stringReverse("Dominik");
        assertEquals("kinimoD", result);
    }

    @Test
    public void shouldReturnTrueIsPalindrom() {
        boolean result = checkIfStringIsPalindrom("kajak");
        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueCanBePalindrom() {
        boolean result = checkIfStringCanBePalindrom("kajak");
        assertTrue(result);
    }

    @Test
    public void shouldReturnPairs() {
        List<Pair> result = findPairs(new int[]{1, 2, 5, 7, 4, 2}, 6);
        assertEquals(3, result.size());
        assertThat(result).extracting("x", "y").contains(tuple(1, 5), tuple(2, 4), tuple(4, 2));
        System.out.println(result.get(0).getX());
    }
}