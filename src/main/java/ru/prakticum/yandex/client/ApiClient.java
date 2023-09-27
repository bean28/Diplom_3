package ru.prakticum.yandex.client;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiClient {

    private static final String CREATE = "/api/auth/register";

    private static final String LOGIN = "/api/auth/login";

    private static final String DELETE = "/api/auth/user";

    @Step("Создание пользователя")
    public Response createUser(Object body) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .post(CREATE);
    }

    @Step("Авторизация пользователя")
    public Response loginUser(Object body) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .post(LOGIN);
    }

    @Step("Удаление пользователя")
    public Response deleteUser(String token) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .header("Authorization", token)
                .when()
                .delete(DELETE);
    }
}
