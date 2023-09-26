package ru.prakticum.yandex;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Test;
import ru.prakticum.yandex.client.ApiClient;
import ru.prakticum.yandex.model.User;
import ru.prakticum.yandex.page.AccountPage;
import ru.prakticum.yandex.page.LoginPage;
import ru.prakticum.yandex.page.MainPage;
import ru.prakticum.yandex.page.RegistrationPage;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    String email = "Pupsen@yandex.ru";
    String password = "qwerty";
    String name = "Pupsen";

    @Test
    @DisplayName("Успешная регистрация")
    public void testRegistration() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        AccountPage accountPage = new AccountPage(driver);

        mainPage.clickSignIn();
        loginPage.clickRegistration();

        registrationPage.fillNameInput(name);
        registrationPage.fillEmailInput(email);
        registrationPage.fillPasswordInput(password);
        registrationPage.clickRegistrationButton();

        driver.get(URI + "login");
        loginPage.fillEmailInput(email);
        loginPage.fillPasswordInput(password);
        loginPage.clickLoginButton();

        mainPage.clickPersonalAccount();
        assertTrue(accountPage.logoutButtonIsDisplayed());
    }

    @After
    public void deleteUser() {
        RestAssured.baseURI = URI;
        ApiClient apiClient = new ApiClient();
        Response response = apiClient.loginUser(new User(email, password, name));
        String token = response.getBody().path("accessToken");
        apiClient.deleteUser(token);
    }

}
