package com.refactorizando.example.testing.quarkus.config;

import com.refactorizando.example.testing.quarkus.model.CarEntity;
import com.refactorizando.example.testing.quarkus.repository.CarRepository;

import javax.annotation.PostConstruct;
import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@Priority(1)
@Alternative
@ApplicationScoped
public class TestCarRepository extends CarRepository {

    @PostConstruct
    public void init() {
        persist(new CarEntity("Mustang", "Blue"),
          new CarEntity("AudiA6", "Grey"));
    }

}
