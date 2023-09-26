package ru.prakticum.yandex.page;

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

    public void clickPersonalAccount() {
        clickOnElement(personalAccount);
        waitLoading();
    }

    public void clickSignIn() {
        clickOnElement(signIn);
    }

    public void clickConstructor() {
        clickOnElement(constructor);
    }

    public void clickBuns() {
        clickOnElement(buns);
    }

    public Boolean firstBunIsDisplayed() {
        return driver.findElement(firstBun).isDisplayed();
    }

    public void clickSauces() {
        clickOnElement(sauces);
    }

    public Boolean firstSauceIsDisplayed() {
        return driver.findElement(firstSauce).isDisplayed();
    }

    public void clickFillings() {
        clickOnElement(fillings);
    }

    public Boolean firstFillingIsDisplayed() {
        return driver.findElement(firstFilling).isDisplayed();
    }

    public void clickLogo() {
        clickOnElement(logo);
    }

    public Boolean createOrderButtonIsDisplayed() {
        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.presenceOfElementLocated(createOrderButton));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

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
