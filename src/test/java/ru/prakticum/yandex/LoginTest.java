package ru.prakticum.yandex;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.prakticum.yandex.client.ApiClient;
import ru.prakticum.yandex.model.User;
import ru.prakticum.yandex.page.*;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    ApiClient apiClient = new ApiClient();
    String token;

    String email = "Pupsen@yandex.ru";
    String password = "qwerty";
    String name = "Pupsen";

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
        Response response = apiClient.createUser(new User(email, password, name));
        token = response.getBody().path("accessToken");
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void testLoginMainPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickSignIn();
        loginPage.fillEmailInput(email);
        loginPage.fillPasswordInput(password);
        loginPage.clickLoginButton();

        assertTrue(mainPage.createOrderButtonIsDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void testLoginPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickPersonalAccount();
        loginPage.fillEmailInput(email);
        loginPage.fillPasswordInput(password);
        loginPage.clickLoginButton();

        assertTrue(mainPage.createOrderButtonIsDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void testLoginRegistrationPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        mainPage.clickSignIn();
        loginPage.clickRegistration();
        registrationPage.clickLogin();
        loginPage.fillEmailInput(email);
        loginPage.fillPasswordInput(password);
        loginPage.clickLoginButton();

        assertTrue(mainPage.createOrderButtonIsDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void testLoginRestorePasswordPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RestorePassPage restorePassPage = new RestorePassPage(driver);

        mainPage.clickSignIn();
        loginPage.clickRestorePasswordButton();
        restorePassPage.clickLogin();
        loginPage.fillEmailInput(email);
        loginPage.fillPasswordInput(password);
        loginPage.clickLoginButton();

        assertTrue(mainPage.createOrderButtonIsDisplayed());
    }


    @After
    public void deleteUser() {
        apiClient.deleteUser(token);
    }
}
