package org.example.exercises.design_patterns.factory_method;

import org.assertj.core.api.Assertions;
import org.example.exercises.design_patterns.factory_method.package_detail.Package;
import org.example.exercises.design_patterns.factory_method.package_detail.PackageGenerator;
import org.example.exercises.design_patterns.factory_method.transport.TransportType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DemoTest {
    @Test
    public void shouldDeliverByTruck() {
        Package aPackage = PackageGenerator.createPackage(1000, "krakow", "zablocie");
        Demo demo = new Demo();
        TransportType transportType = demo.process(aPackage);
        Assertions.assertThat(transportType).isEqualTo(TransportType.TRUCK);
    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(PackageGenerator.createPackage(100, "krakow", "zablocie"), TransportType.TRUCK),
                Arguments.of(PackageGenerator.createPackage(10000, "krakow", "zablocie"), TransportType.SHIP)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(Package aPackage, TransportType expected) {
        Demo demo = new Demo();
        TransportType transportType = demo.process(aPackage);
        assertEquals(expected, transportType);
    }
}