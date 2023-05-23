package ru.qascooter.ui;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.qascooter.pages.MainPage;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.numberOfWindows;
import static com.codeborne.selenide.WebDriverConditions.url;

@Story("Проверка работы редиректов")
@DisplayName("Проверка работы редиректов")
class RedirectTest extends BaseTest {
    private final String REDIRECT = "https://dzen.ru/?yredirect=true";
    private final String SCOOTER_SITE = "https://qa-scooter.praktikum-services.ru/";
    private MainPage mainPage;

    @BeforeEach
    void arrangeTestData() {
        mainPage = MainPage.open();
    }

    @Test
    @Feature("Редирект по клику на лого [Яндекс]")
    @Description("Редирект по клику на лого [Яндекс]")
    void testRedirect() {
        mainPage.clickLogoYandex();
        Allure.step("Проверяем что  открылась новая вкалдка с сайтом ",
                () -> webdriver().shouldHave(numberOfWindows(2)));
        Allure.step("Переключаемся на открывщиюся вкалду ",
                () -> Selenide.switchTo().window(1));
        Allure.step("Проверяем что открыт сайт " + REDIRECT,
                () -> webdriver().shouldHave(url(REDIRECT)));
    }

    @Test
    @Feature("Открытие главной страницы по клику на лого [Самокат]")
    @Description("Открытие главной страницы по клику на лого [Самокат]")
    void testRedirectScooter() {
        mainPage.clickOrderStatus().clickGoButton();
        mainPage.clickScooter();
        Allure.step("Проверяем что открыт сайт " + SCOOTER_SITE,
                () -> webdriver().shouldHave(url(SCOOTER_SITE)));
    }

    @AfterEach
    public void close() {
        closeWindow();
    }


}
