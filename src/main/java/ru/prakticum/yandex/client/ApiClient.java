package ru.prakticum.yandex.client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiClient {

    private static final String CREATE = "/api/auth/register";

    private static final String LOGIN = "/api/auth/login";

    private static final String DELETE = "/api/auth/user";

    public Response createUser(Object body) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .post(CREATE);
    }

    public Response loginUser(Object body) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .post(LOGIN);
    }

    public Response deleteUser(String token) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .header("Authorization", token)
                .when()
                .delete(DELETE);
    }
}
