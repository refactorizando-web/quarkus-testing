package com.refactorizando.example.testing.quarkus.service;

import com.refactorizando.example.testing.quarkus.model.CarEntity;
import com.refactorizando.example.testing.quarkus.repository.CarRepository;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@QuarkusTest
class CarServiceInjectMockUnitTest {

    @Inject
    CarService carService;

    @InjectMock
    CarRepository carRepository;

    @BeforeEach
    void setUp() {
        when(carRepository.findBy("yellow"))
          .thenReturn(Arrays.stream(new CarEntity[] {
            new CarEntity("Megane", "yellow"),
            new CarEntity("A6", "yellow")}));
    }

    @Test
    void whenGetCarByModel_thenCarsAreReturned() {
        assertEquals(2, carService.find("yellow").size());
    }

}
