package org.example.exercises.design_patterns.abstract_factory;

import org.assertj.core.api.Assertions;
import org.example.exercises.design_patterns.abstract_factory.application.FactoryApplication;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;


public class DemoTest {
    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(Demo.chooseFurnitureStyle(FurnitureStyle.MODERN), false, "Modern chair", false, "Modern sofa", false, "Modern coffe table"),
                Arguments.of(Demo.chooseFurnitureStyle(FurnitureStyle.ART_DECO), true, "Art deco chair", false, "Art deco sofa", true, "Art deco coffe table"),
                Arguments.of(Demo.chooseFurnitureStyle(FurnitureStyle.VICTORIAN), true, "Victorian chair", true, "Victorian sofa", true, "Victorian coffe table")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void shouldReturnFurniture(FactoryApplication app, boolean chairHasLegs, String chairName, boolean sofaHasLegs, String sofaName, boolean coffetableHasLegs, String coffetableName) {
        Assertions.assertThat(app.getChair().furnitureType()).isEqualTo(FurnitureType.CHAIR);
        Assertions.assertThat(app.getChair().hasLegs()).isEqualTo(chairHasLegs);
        Assertions.assertThat(app.getChair().sitOn()).isEqualTo(chairName);

        Assertions.assertThat(app.getSofa().furnitureType()).isEqualTo(FurnitureType.SOFA);
        Assertions.assertThat(app.getSofa().hasLegs()).isEqualTo(sofaHasLegs);
        Assertions.assertThat(app.getSofa().sitOn()).isEqualTo(sofaName);

        Assertions.assertThat(app.getCoffetable().furnitureType()).isEqualTo(FurnitureType.COFFETABLE);
        Assertions.assertThat(app.getCoffetable().hasLegs()).isEqualTo(coffetableHasLegs);
        Assertions.assertThat(app.getCoffetable().sitOn()).isEqualTo(coffetableName);
    }
}