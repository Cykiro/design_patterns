package org.example.exercises.design_patterns.builder;

import org.assertj.core.api.Assertions;
import org.example.exercises.design_patterns.builder.builders.ComputerCarBuilder;
import org.example.exercises.design_patterns.builder.builders.StandardCarBuilder;
import org.example.exercises.design_patterns.builder.cars.CarType;
import org.example.exercises.design_patterns.builder.cars.ComputerCar;
import org.example.exercises.design_patterns.builder.cars.StandardCar;
import org.example.exercises.design_patterns.builder.components.Transmission;
import org.example.exercises.design_patterns.builder.director.Director;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;


class DemoTest {
    private static Stream<Arguments> provideArguments1() {

        Director director = new Director();
        ComputerCarBuilder computerCarBuilder = new ComputerCarBuilder();
        director.constructSportsCar(computerCarBuilder);
        return Stream.of(
                Arguments.of(computerCarBuilder.getResult())
        );
    }

    private static Stream<Arguments> provideArguments2() {

        Director director = new Director();
        StandardCarBuilder standardCarBuilder = new StandardCarBuilder();
        director.constructSportsCar(standardCarBuilder);
        return Stream.of(
                Arguments.of(standardCarBuilder.getResult())
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments1")
    void shouldReturnComputerCar1(ComputerCar computerCar) {
        Assertions.assertThat(computerCar.getCarType()).isEqualTo(CarType.SPORTS_CAR);
        Assertions.assertThat(computerCar.getEngine().getMileage()).isEqualTo(0);
        Assertions.assertThat(computerCar.getSeats()).isEqualTo(2);
        Assertions.assertThat(computerCar.getEngine().getPower()).isEqualTo(300);
        Assertions.assertThat(computerCar.getTransmission()).isEqualTo(Transmission.SEMI_AUTOMATIC);
        Assertions.assertThat(computerCar.getTripComputer()).isNotNull();
        Assertions.assertThat(computerCar.getGpsNavigator()).isNotNull();
    }
    @ParameterizedTest
    @MethodSource("provideArguments1")
    void shouldReturnComputerCar2(ComputerCar computerCar) {
        Assertions.assertThat(computerCar.getEngine().isStarted()).isFalse();
        computerCar.getEngine().on();
        Assertions.assertThat(computerCar.getEngine().isStarted()).isTrue();


        Assertions.assertThat(computerCar.getEngine().getMileage()).isEqualTo(0);
        Assertions.assertThat(computerCar.getEngine().getFuel()).isEqualTo(0);
        computerCar.getEngine().tank(60);
        Assertions.assertThat(computerCar.getEngine().getFuel()).isEqualTo(60);
        computerCar.getEngine().go(10);
        Assertions.assertThat(computerCar.getEngine().getFuel()).isEqualTo(54.75);
        Assertions.assertThat(computerCar.getEngine().getMileage()).isEqualTo(10.0);


        Exception exception = assertThrows(RuntimeException.class, () -> {
            computerCar.getEngine().go(500);
        });

        String expectedMessage = "Cannot go futher, there is still: 396.0 millage left";
        String actualMessage = exception.getCause().getMessage();
        Assertions.assertThat(expectedMessage).isEqualTo(actualMessage);


    }

    @ParameterizedTest
    @MethodSource("provideArguments2")
    void shouldReturnStandardCar(StandardCar carStandardCar) {

        Assertions.assertThat(carStandardCar.print()).isEqualTo("Type of car: SPORTS_CAR\n" +
                "Count of seats: 2\n" +
                "Engine: volume - 300.0; mileage - 0.0\n" +
                "Transmission: SEMI_AUTOMATIC\n" +
                "GPS Navigator: Functional\n");
    }
}