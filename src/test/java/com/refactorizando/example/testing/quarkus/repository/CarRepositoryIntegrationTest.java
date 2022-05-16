package com.refactorizando.example.testing.quarkus.repository;

import com.refactorizando.example.testing.quarkus.config.QuarkusTransactionalTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTransactionalTest
class CarRepositoryIntegrationTest {

    @Inject
    CarRepository carRepository;

    @Test
    void givenModelCarInRepository_whenFindByModel_thenShouldReturnModelCarFromRepository() {
        assertTrue(carRepository.findBy("Mustang").findAny().isPresent());
    }
}
