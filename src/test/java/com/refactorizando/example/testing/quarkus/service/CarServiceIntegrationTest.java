package com.refactorizando.example.testing.quarkus.service;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertFalse;

@QuarkusTest
class CarServiceIntegrationTest {

    @Inject
    CarService carService;

    @Test
    void whenFindByCar_thenCarIsReturned() {
        assertFalse(carService.find("Mustang").isEmpty());
    }

}
