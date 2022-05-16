package com.refactorizando.example.testing.quarkus.resource;

import com.refactorizando.example.testing.quarkus.CarResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
@TestHTTPEndpoint(CarResource.class)
class CarHttpEndpointIntegrationTest {

    @Test
    void whenGetCars_thenShouldReturnSuccessfully() {
        given().contentType(ContentType.JSON)
          .when().get("model")
          .then().statusCode(200);
    }
}
