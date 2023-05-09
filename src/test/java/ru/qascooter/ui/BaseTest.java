package ru.qascooter.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {
    public final String URL = "https://qa-scooter.praktikum-services.ru/";
    public static void start() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser= "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false; // false чтобы видеть как автотесты прогоняются в браузере
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeAll
    public static void setUp() {
        start();
    }
    @AfterAll
    public static void tearDown() {
        SelenideLogger.removeListener("AllureSelenide");
        Selenide.closeWebDriver();
    }
    @Step("Открываем сайт")
    public void openMainPage() {
        Selenide.open(URL);
    }
    @Step("Закрываем браузер")
    void closeWindow() {
        Selenide.closeWindow();
    }

}
