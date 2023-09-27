package ru.prakticum.yandex;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.prakticum.yandex.client.ApiClient;
import ru.prakticum.yandex.model.User;
import ru.prakticum.yandex.page.AccountPage;
import ru.prakticum.yandex.page.LoginPage;
import ru.prakticum.yandex.page.MainPage;

import static org.junit.Assert.assertTrue;

public class TransitionTest extends BaseTest {

    private ApiClient apiClient = new ApiClient();
    private String token;

    private String email = "Pupsen@yandex.ru";
    private String password = "qwerty";
    private String name = "Pupsen";

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
        Response response = apiClient.createUser(new User(email, password, name));
        token = response.getBody().path("accessToken");
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет»")
    public void testTransitionPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);

        mainPage.clickSignIn();
        loginPage.fillEmailInput(email);
        loginPage.fillPasswordInput(password);
        loginPage.clickLoginButton();

        mainPage.clickPersonalAccount();
        assertTrue(accountPage.logoutButtonIsDisplayed());
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор»")
    public void testTransitionConstructor() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickSignIn();
        loginPage.fillEmailInput(email);
        loginPage.fillPasswordInput(password);
        loginPage.clickLoginButton();

        mainPage.clickPersonalAccount();
        mainPage.clickConstructor();
        assertTrue(mainPage.createOrderButtonIsDisplayed());
    }

    @Test
    @DisplayName("Переход по клику на логотип Stellar Burgers")
    public void testTransitionLogo() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickSignIn();
        loginPage.fillEmailInput(email);
        loginPage.fillPasswordInput(password);
        loginPage.clickLoginButton();

        mainPage.clickPersonalAccount();
        mainPage.clickLogo();
        assertTrue(mainPage.createOrderButtonIsDisplayed());
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void testLogout() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);

        mainPage.clickSignIn();
        loginPage.fillEmailInput(email);
        loginPage.fillPasswordInput(password);
        loginPage.clickLoginButton();

        mainPage.clickPersonalAccount();
        accountPage.clickLogoutButton();
        mainPage.clickConstructor();
        assertTrue(mainPage.signInButtonIsDisplayed());
    }

    @After
    public void deleteUser() {
        apiClient.deleteUser(token);
    }
}
