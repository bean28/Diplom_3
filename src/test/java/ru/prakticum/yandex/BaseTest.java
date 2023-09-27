package ru.prakticum.yandex;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.prakticum.yandex.driver.WebDriverCreator;
import ru.prakticum.yandex.page.MainPage;

public abstract class BaseTest {

    protected static final String URI = "https://stellarburgers.nomoreparties.site/";

    protected WebDriver driver;

    @Before
    public void startUp() {
        driver = WebDriverCreator.createWebDriver();
        driver.get(URI);
        new MainPage(driver).waitLoading();

    }

    @After
    public void teardown() {
        driver.quit();
    }


}
