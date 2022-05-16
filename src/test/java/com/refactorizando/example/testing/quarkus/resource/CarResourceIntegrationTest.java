package com.refactorizando.example.testing.quarkus.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItem;

@QuarkusTest
class CarResourceIntegrationTest {

    @Test
    void whenGetCarsByModel_thenCarsAreReturned() {
        given().contentType(ContentType.JSON).param("query", "Mustang")
          .when().get("/cars/model")
          .then().statusCode(200)
          .body("size()", is(1))
          .body("model", hasItem("Mustang"))
          .body("color", hasItem("Blue"));
    }

}
