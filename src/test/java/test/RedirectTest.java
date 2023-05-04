package test;

import core.BaseTest;
import io.qameta.allure.Epic;
import org.junit.Test;
import page.MainPage;

public class RedirectTest extends BaseTest {
    public final String REDIRECT = "https://dzen.ru/?yredirect=true";
    public final String SCOOTER_SITE = "https://qa-scooter.praktikum-services.ru/";


    @Epic(value="Проверка лого Яндекс")
    @Test
    public void testRedirect() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.clickYandex();
        mainPage.switchWindow();
        mainPage.comparisonSite(REDIRECT);
    }
    @Epic(value="Проверка лого самокат")
    @Test
    public void testRedirectScooter() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.clickOrderButton(1);
        mainPage.clickScooter();
        mainPage.comparisonLogoRedirect(SCOOTER_SITE);
    }
}
