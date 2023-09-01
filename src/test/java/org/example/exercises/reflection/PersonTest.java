package org.example.exercises.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {
    @Test
    public void whenGetFileNamesAttRuntime() {
        Person person = new Person();
        Field[] declaredFields = person.getClass().getDeclaredFields();
        List<String> fieldNames = getFields(declaredFields);
        assertThat(fieldNames).contains("age", "name");
    }

    private static List<String> getFields(Field[] declaredFields) {
        List<String> list = new ArrayList<>();
        for (Field declaredField : declaredFields) {
            list.add(declaredField.getName());
        }
        return list;
    }

}