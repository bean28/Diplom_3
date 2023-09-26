package ru.prakticum.yandex.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePassPage extends BasePage {
    private By login = By.xpath("//a[text()='Войти']");

    public RestorePassPage(WebDriver driver) {
        super(driver);
    }

    public void clickLogin() {
        clickOnElement(login);
    }
}
