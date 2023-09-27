package ru.prakticum.yandex.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {
    private By loading = By.xpath("//img[@alt='loading animation']");
    private By personalAccount = By.xpath("//p[text()='Личный Кабинет']");
    private By signIn = By.xpath("//button[text()='Войти в аккаунт']");
    private By createOrderButton = By.xpath("//button[text()='Оформить заказ']");
    private By constructor = By.xpath("//p[text()='Конструктор']");
    private By logo = By.className("AppHeader_header__logo__2D0X2");
    private By buns = By.xpath("//div[span/text()='Булки']");
    private By firstBun = By.xpath("//img[@alt='Флюоресцентная булка R2-D3']");
    private By sauces = By.xpath("//div[span/text()='Соусы']");
    private By firstSauce = By.xpath("//img[@alt='Соус Spicy-X']");
    private By fillings = By.xpath("//div[span/text()='Начинки']");
    private By firstFilling = By.xpath("//img[@alt='Мясо бессмертных моллюсков Protostomia']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void waitLoading() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.invisibilityOf(driver.findElement(loading)));
    }

    @Step("Клик по кнопке 'Личный кабинет'")
    public void clickPersonalAccount() {
        clickOnElement(personalAccount);
        waitLoading();
    }

    @Step("Клик по кнопке 'Войти в аккаунт'")
    public void clickSignIn() {
        clickOnElement(signIn);
    }

    @Step("Клик по кнопке 'Конструктор'")
    public void clickConstructor() {
        clickOnElement(constructor);
    }

    @Step("Клик по вкладке 'Булки'")
    public void clickBuns() {
        clickOnElement(buns);
    }

    @Step("Булки отображаются")
    public Boolean firstBunIsDisplayed() {
        return driver.findElement(firstBun).isDisplayed();
    }

    @Step("Клик по вкладке 'Соусы'")
    public void clickSauces() {
        clickOnElement(sauces);
    }

    @Step("Соусы отображаются")
    public Boolean firstSauceIsDisplayed() {
        return driver.findElement(firstSauce).isDisplayed();
    }

    @Step("Клик по вкладке 'Нвчинки'")
    public void clickFillings() {
        clickOnElement(fillings);
    }

    @Step("Нвчинки отображаются")
    public Boolean firstFillingIsDisplayed() {
        return driver.findElement(firstFilling).isDisplayed();
    }

    @Step("Клик по логотипу")
    public void clickLogo() {
        clickOnElement(logo);
    }

    @Step("Кнопка 'Оформить заказ' отображается")
    public Boolean createOrderButtonIsDisplayed() {
        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.presenceOfElementLocated(createOrderButton));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Кнопка 'Войти в аккаунт' отображается")
    public Boolean signInButtonIsDisplayed() {
        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.presenceOfElementLocated(signIn));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
