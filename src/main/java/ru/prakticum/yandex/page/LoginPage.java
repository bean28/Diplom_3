package ru.prakticum.yandex.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    private By emailInput = By.xpath("//input[@name='name']");
    private By passwordInput = By.xpath("//input[@name='Пароль']");
    private By loginButton = By.xpath("//button[text()='Войти']");
    private By register = By.xpath("//a[text()='Зарегистрироваться']");
    private By restorePassword = By.xpath("//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод email")
    public void fillEmailInput(String email) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(emailInput));
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Ввод пароля")
    public void fillPasswordInput(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Клик по кнопке 'Вход'")
    public void clickLoginButton() {
        clickOnElement(loginButton);
    }

    @Step("Клик по ссылке 'Регистрация'")
    public void clickRegistration() {
        clickOnElement(register);
    }

    @Step("Клик по ссылке 'Восстановление пароля'")
    public void clickRestorePasswordButton() {
        clickOnElement(restorePassword);
    }
}
