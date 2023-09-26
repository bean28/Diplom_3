package ru.prakticum.yandex.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverCreator {
    public static WebDriver createWebDriver() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            return createChromeDriver();
        }

        switch (browser) {
            case "yandex":
                return createYandexriver();
            case "chrome":
                return createChromeDriver();
            default:
                return createChromeDriver();
        }
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }

    private static WebDriver createYandexriver() {
        System.setProperty("webdriver.chrome.driver", System.getenv("YANDEX_BROWSER_DRIVER_FILENAME"));
        ChromeOptions options = new ChromeOptions();
        options.setBinary(System.getenv("YANDEX_BROWSER_PATH"));
        return new ChromeDriver(options);
    }
}
