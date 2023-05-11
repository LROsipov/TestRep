package ru.qascooter.ui;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import ru.qascooter.pages.MainPage;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.numberOfWindows;
import static com.codeborne.selenide.WebDriverConditions.url;

 class RedirectTest extends BaseTest {
    public final String REDIRECT = "https://dzen.ru/?yredirect=true";
    public final String SCOOTER_SITE = "https://qa-scooter.praktikum-services.ru/";


    @Test
    @Feature("Редирект по клику на лого <Яндекс>")
    @Description("Редирект по клику на лого <Яндекс>")
     void testRedirect()  {
        try {openMainPage();
            clickLogoYandex();
            checkUrlSite(REDIRECT);
        } finally {
            closeWindow();
        }
    }

    @Test
    @Feature("Открытие главной страницы по клику на лого <Самокат>")
    @Description("Открытие главной страницы по клику на лого <Самокат>")
     void testRedirectScooter()  {
        try {
            openMainPage();
            clickLogoScooter();
            checkUrlSite(SCOOTER_SITE);
        } finally {
            closeWindow();
        }
    }
    public void clickLogoYandex() {
        MainPage mainPage = new MainPage();
        Allure.step("Кликаем на лого  <Яндекс>",
                ()->  mainPage.clickYandex());
        Allure.step("Проверяем что  открылась новая вкалдка с сайтом ",
                ()-> webdriver().shouldHave(numberOfWindows(2)));
        Allure.step("Переключаемся на открывщиюся вкалду ",
                ()->  Selenide.switchTo().window(1));
    }
    public void clickLogoScooter() {
        MainPage mainPage = new MainPage();
        Allure.step("Переходим на страницу  <Статус заказа>",
                ()->  mainPage.clickOrderStatus());
        Allure.step("Кликаем на лого <Самокат> ",
                ()->  mainPage.clickScooter());

    }
    public void checkUrlSite(String URL) {
        MainPage mainPage = new MainPage();
        Allure.step("Проверяем что открыт сайт "+URL,
                ()->  webdriver().shouldHave(url(URL)));
    }
}
