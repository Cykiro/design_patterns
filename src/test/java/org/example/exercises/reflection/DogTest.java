package org.example.exercises.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DogTest {
    @Test
    public void shouldTestGetsClassName() {
        Dog dog = new Dog("Azor");
        Class<?> aClass = dog.getClass();

        assertThat(aClass.getSimpleName()).isEqualTo("Dog");
        assertThat(aClass.getName()).isEqualTo("org.example.exercises.reflection.Dog");
    }

    @Test
    public void shouldCreateObjectFromName() throws ClassNotFoundException {
        Class<?> dogClass = Class.forName("org.example.exercises.reflection.Dog");
        Class<?> animalClass = Class.forName("org.example.exercises.reflection.Animal");

        int dogModifiers = dogClass.getModifiers();
        int animalModifiers = animalClass.getModifiers();

        assertThat(Modifier.isPublic(dogModifiers)).isTrue();
        assertThat(Modifier.isAbstract(animalModifiers)).isTrue();
        assertThat(dogClass.getSimpleName()).isEqualTo("Dog");
        assertThat(animalClass.getSimpleName()).isEqualTo("Animal");
    }

    @Test
    public void shouldGetSuperClass() {
        Dog dog = new Dog("Azor");
        String string = "string";
        Class<? extends Dog> aClass = dog.getClass();
        Class<?> superclass = aClass.getSuperclass();
        assertThat(superclass.getSimpleName()).isEqualTo("Animal");
        assertThat(string.getClass().getSuperclass().getSimpleName()).isEqualTo("Object");
    }

    @Test
    public void shouldGetImplementedInterfaces() throws ClassNotFoundException {
        Class<?> dogClass = Class.forName("org.example.exercises.reflection.Dog");
        Class<?> animalClass = Class.forName("org.example.exercises.reflection.Animal");
        Class<?>[] dogInterfaces = dogClass.getInterfaces();
        Class<?>[] animalInterfaces = animalClass.getInterfaces();
        assertThat(dogInterfaces.length).isEqualTo(1);
        assertThat(animalInterfaces.length).isEqualTo(1);
        assertThat(dogInterfaces[0].getSimpleName()).isEqualTo("Locomotion");
        assertThat(animalInterfaces[0].getSimpleName()).isEqualTo("Eating");
    }

    @Test
    public void shouldGetConstructor() throws ClassNotFoundException {
        Class<?> dogClass = Class.forName("org.example.exercises.reflection.Dog");
        Constructor<?>[] constructors = dogClass.getConstructors();
        assertThat(constructors.length).isEqualTo(1);
        assertThat(constructors[0].getName()).isEqualTo("org.example.exercises.reflection.Dog");
    }

    @Test
    public void shouldGetAllFields() throws ClassNotFoundException {
        Class<?> animalClass = Class.forName("org.example.exercises.reflection.Animal");
        Method[] methods = animalClass.getDeclaredMethods();
        List<String> methodsNames = getMethodsNames(methods);
        assertThat(methodsNames.size()).isEqualTo(1);
        assertThat(methodsNames).contains("getSound");
    }

    private List<String> getMethodsNames(Method[] methods) {
        List<String> methodNames = new ArrayList<>();
        for (Method method : methods) {
            methodNames.add(method.getName());
        }
        return methodNames;
    }

    @Test
    public void shouldInvokeMethods() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> dogClass = Class.forName("org.example.exercises.reflection.Dog");
        Dog dog = (Dog) dogClass.getConstructor(String.class).newInstance("Alex");
        Method getSound = dogClass.getDeclaredMethod("getSound");
        String sound = (String) getSound.invoke(dog);
        assertThat(sound).isEqualTo("woof");
        //dodac adapter do csv i zrobic to za pomoca refleksji
        //jako oddzielna metoda (pozniej mozna rozpoznawac pliki przesylane)
        //wzorzec projektowy polecenie

    }
    @Test
    public void testConstructor() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> catClass = Class.forName("org.example.exercises.reflection.Cat");
        catClass.getConstructor(String.class).newInstance("Garfield");
    }
}