package com.refactorizando.example.testing.quarkus.repository;

import com.refactorizando.example.testing.quarkus.model.CarEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.stream.Stream;

import static io.quarkus.panache.common.Parameters.with;

@ApplicationScoped
public class CarRepository implements PanacheRepository<CarEntity> {

    public Stream<CarEntity> findBy(String query) {

        return find("color like :query or model like :query", with("query", "%"+query+"%")).stream();
    }

}
