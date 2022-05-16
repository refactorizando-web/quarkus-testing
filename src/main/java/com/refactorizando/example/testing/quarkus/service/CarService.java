package com.refactorizando.example.testing.quarkus.service;

import com.refactorizando.example.testing.quarkus.model.CarEntity;
import com.refactorizando.example.testing.quarkus.repository.CarRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Transactional
@ApplicationScoped
public class CarService {

    @Inject
    CarRepository carRepository;

    public Set<CarEntity> find(String query) {
        if (query == null) {
            return carRepository.findAll().stream().collect(toSet());
        }

        return carRepository.findBy(query).collect(toSet());
    }

}
