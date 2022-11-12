package ru.cucumber_template.api;

import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import static io.restassured.RestAssured.given;

@Service
public class Post implements CrudEntity {
    @Override
    public Response getId(String... values) {
        Specification.installSpecification(Specification.requestSpec(), Specification.responseSpec(Integer.parseInt(values[0])));

        return given()
                .when()
                .get();
    }

    @Override
    public void create(Object o, String... values) {
        Specification.installSpecification(Specification.requestSpec(), Specification.responseSpec(Integer.parseInt(values[0])));

        given().when()
                .body(o)
                .post();

    }

    @Override
    public void update(Object o, String... values) {

        Specification.installSpecification(Specification.requestSpec(), Specification.responseSpec(Integer.parseInt(values[0])));

        given().when()
                .body(o)
                .put();

    }

    @Override
    public void delete(String... values) {
        Specification.installSpecification(Specification.requestSpec(), Specification.responseSpec(Integer.parseInt(values[1])));

        given().when()
                .delete("/{id}", values[0]);

    }
}
