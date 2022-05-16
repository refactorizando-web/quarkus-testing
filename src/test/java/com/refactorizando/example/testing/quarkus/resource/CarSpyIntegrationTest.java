package com.refactorizando.example.testing.quarkus.resource;

import com.refactorizando.example.testing.quarkus.service.CarService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectSpy;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.verify;

@QuarkusTest
class CarSpyIntegrationTest {

    @InjectSpy
    CarService carService;

    @Test
    void whenGetCarsByModel_thenModelIsReturned() {
        given().contentType(ContentType.JSON).param("query", "Mustang")
          .when().get("/cars/model")
          .then().statusCode(200);

        verify(carService).find("Mustang");
    }

}
