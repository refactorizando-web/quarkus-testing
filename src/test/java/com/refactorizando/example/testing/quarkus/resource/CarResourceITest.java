package com.refactorizando.example.testing.quarkus.resource;

import com.refactorizando.example.testing.quarkus.config.TestProfileCustom;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItems;

@QuarkusTest
@TestProfile(TestProfileCustom.class)
class CarResourceITest {

    public static final String CAR_WORKSHOP = "/custom/cars/model";

    @Test
    void whenGetCars_thenAllCarsAreReturned() {
        given().contentType(ContentType.JSON)
          .when().get(CAR_WORKSHOP)
          .then().statusCode(200)
          .body("size()", is(2))
          .body("model", hasItems("AudiA6", "Mustang"));
    }
}
