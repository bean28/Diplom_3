package ru.prakticum.yandex.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends BasePage{
    public By logoutButton = By.xpath("//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Выход из аккаунта")
    public void clickLogoutButton() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(logoutButton));
        clickOnElement(logoutButton);
    }

    @Step("Проверка наличия кнопки 'Выход'")
    public Boolean logoutButtonIsDisplayed() {
        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.presenceOfElementLocated(logoutButton));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
