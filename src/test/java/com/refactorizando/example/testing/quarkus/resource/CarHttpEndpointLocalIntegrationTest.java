package com.refactorizando.example.testing.quarkus.resource;

import com.refactorizando.example.testing.quarkus.CarResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static io.restassured.RestAssured.given;
import static java.nio.charset.Charset.defaultCharset;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class CarHttpEndpointLocalIntegrationTest {

    @TestHTTPEndpoint(CarResource.class)
    @TestHTTPResource("model")
    URL carEndpoint;

    @Test
    void whenGetCarByModel_thenCarShouldReturnAValidCar() {
        given().contentType(ContentType.JSON).param("query", "Mustang")
          .when().get(carEndpoint)
          .then().statusCode(200)
          .body("size()", is(1))
          .body("model", hasItem("Mustang"))
          .body("color", hasItem("Blue"));
    }

    @Test
    void whenGetCar_thenCarsShouldReturnValidCars() throws IOException {
        assertTrue(IOUtils.toString(carEndpoint.openStream(), defaultCharset()).contains("Mustang"));
    }
}
