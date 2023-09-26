package ru.prakticum.yandex.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage{
    private By nameInput = By.xpath("//div[label/text()='Имя']/input[@name='name']");
    private By emailInput = By.xpath("//div[label/text()='Email']/input[@name='name']");
    private By passwordInput = By.xpath("//input[@name='Пароль']");
    private By registrationButton = By.xpath("//button[text()='Зарегистрироваться']");
    private By login = By.xpath("//a[text()='Войти']");
    private By passwordError = By.xpath("//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void fillNameInput(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void fillEmailInput(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void fillPasswordInput(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickRegistrationButton() {
        clickOnElement(registrationButton);
    }

    public void clickLogin() {
        clickOnElement(login);
    }

    public Boolean passwordErrorIsDisplayed() {
        return driver.findElement(passwordError).isDisplayed();
    }
}
