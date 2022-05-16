package com.refactorizando.example.testing.quarkus;

import com.refactorizando.example.testing.quarkus.model.CarEntity;
import com.refactorizando.example.testing.quarkus.service.CarService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {

    @Inject
    CarService carService;

    @GET
    @Path("/model")
    public Set<CarEntity> findModel(@QueryParam("query") String query) {
        return carService.find(query);
    }

}
