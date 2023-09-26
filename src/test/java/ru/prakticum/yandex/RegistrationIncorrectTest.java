package ru.prakticum.yandex;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.prakticum.yandex.page.LoginPage;
import ru.prakticum.yandex.page.MainPage;
import ru.prakticum.yandex.page.RegistrationPage;

import static org.junit.Assert.assertTrue;

public class RegistrationIncorrectTest extends BaseTest {

    String email = "Pupsen@yandex.ru";
    String password = "123";
    String name = "Pupsen";

    @Test
    @DisplayName("Ошибка для некорректного пароля регистрации")
    public void testRegistrationIncorrectPassword() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        mainPage.clickSignIn();
        loginPage.clickRegistration();

        registrationPage.fillNameInput(name);
        registrationPage.fillEmailInput(email);
        registrationPage.fillPasswordInput(password);
        registrationPage.clickRegistrationButton();

        assertTrue(registrationPage.passwordErrorIsDisplayed());
    }

}
