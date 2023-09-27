package ru.prakticum.yandex;

import org.junit.Test;
import ru.prakticum.yandex.page.MainPage;
import io.qameta.allure.junit4.DisplayName;

import static org.junit.Assert.*;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход к разделам 'Булки'")
    public void testBuns() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillings();
        mainPage.clickBuns();
        assertTrue(mainPage.firstBunIsDisplayed());
    }

    @Test
    @DisplayName("Переход к разделам 'Соусы'")
    public void testSauces() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauces();
        assertTrue(mainPage.firstSauceIsDisplayed());
    }

    @Test
    @DisplayName("Переход к разделам 'Начинки'")
    public void testFillings() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillings();
        assertTrue(mainPage.firstFillingIsDisplayed());
    }
}
