package com.refactorizando.example.testing.quarkus.service;

import com.refactorizando.example.testing.quarkus.model.CarEntity;
import com.refactorizando.example.testing.quarkus.repository.CarRepository;
import com.refactorizando.example.testing.quarkus.config.TestCarRepository;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class CarServiceQuarkusMockUnitTest {

    @Inject
    CarService carService;

    @BeforeEach
    void setUp() {
        CarRepository mock = Mockito.mock(TestCarRepository.class);
        Mockito.when(mock.findBy("grey"))
          .thenReturn(Arrays.stream(new CarEntity[] {
            new CarEntity("A6", "grey"),
            new CarEntity("I30", "grey"),
            new CarEntity("Toledo", "grey")}));
        QuarkusMock.installMockForType(mock, CarRepository.class);
    }

    @Test
    void whenFindByModel_thenCarsAreReturned() {
        assertEquals(3, carService.find("grey").size());
    }

}
