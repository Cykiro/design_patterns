package org.example.exercises.exercises;


import java.util.ArrayList;
import java.util.List;

public class StringManager {

    public static String stringReverse(String input) {
        String result = "";
        for (int i = input.length() - 1; i >= 0; i--)
            result += input.charAt(i);
        return result;
    }

    public static boolean checkIfStringIsPalindrom(String input) {
        int i = 0;
        int l = input.length() - 1;

        while (i < l) {
            if (input.charAt(i) != input.charAt(l)) {
                return false;
            }
            i++;
            l--;
        }

        return true;
    }

    public static boolean checkIfStringCanBePalindrom(String input) {
        int oddNumber = 0;
        if (input.length() % 2 == 1)
            oddNumber = 1;
        while (input.length() > 0) {
            String character = String.valueOf(input.charAt(0));
            input = input.replaceFirst(character, "");
            if (input.contains(character))
                input = input.replaceFirst(character, "");
            else
                oddNumber--;
        }
        if (oddNumber >= 0)
            return true;
        else
            return false;
    }

    public static List<Pair> findPairs(int[] table, int number) {
        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < table.length; i++) {
            for (int l = i + 1; l < table.length; l++) {
                if (table[i] + table[l] == number) {
                    Pair pair = new Pair();
                    pair.setX(table[i]);
                    pair.setY(table[l]);
                    list.add(pair);
                }
            }
        }

        return list;
    }


}
