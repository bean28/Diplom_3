package ru.prakticum.yandex.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePassPage extends BasePage {
    private By login = By.xpath("//a[text()='Войти']");

    public RestorePassPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик по ссылке 'Войти' на странице восстановления пароля")
    public void clickLogin() {
        clickOnElement(login);
    }
}
