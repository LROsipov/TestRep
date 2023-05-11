package ru.qascooter.ui;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.qascooter.pages.MainPage;
import ru.qascooter.pages.OrderForRentPage;
import ru.qascooter.pages.OrderForScooterPage;
import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class OrderTest extends BaseTest {
    LocalDate tomorrow = LocalDate.now().plusDays(1);
    public final String date  = tomorrow.toString();

    public static Stream<Arguments> isOrderData() {
        return Stream.of(
                arguments(0, "Тестирование", "Тестировщик", "Улица Пушкина Дом колатошкина","33333333333" ),
                arguments(1, "Тестирование", "Тестировщик", "Улица Пушкина Дом колатошкина","33333333333" )
        );
    }

    @ParameterizedTest
    @MethodSource("isOrderData")
    @Description("Оформление заказа")
    void testOrder(int number,String name, String family, String address, String phone) throws InterruptedException {
        try {
            openMainPage();
            clickOrderButton(number);
            fillForScooter(name, family,address,phone);
            fillInAboutRent();
            checkOrderData();
        }
        finally {
            closeWindow();
        }
    }
    @Step("Проверяем появилось ли окно с данными заказа")
    public void checkOrderData()  {
        OrderForRentPage orderForRentPage = new OrderForRentPage();
        orderForRentPage.waitForDataOrder();
    }
    @Step("Заполеняем форму про аренду")
    public void fillInAboutRent() throws InterruptedException {
        OrderForRentPage orderForRentPage = new OrderForRentPage();
        Allure.step("Выбираем  <когда привезти>",
                ()-> orderForRentPage.inputDate(date));
        Allure.step("Выбираем  <срок аренды>",
                ()-> orderForRentPage.dateRent());
        Allure.step("Кликаем по кнопке  <Заказать>",
                ()-> orderForRentPage.clickOrder());
        Allure.step("Кликаем по кнопке  <Да>",
                ()-> orderForRentPage.clickButtonYesConfirmation());

    }
    @Step("Заполняем форму <Для кого самокат>")
    public void fillForScooter(String name, String family, String address, String phone) {
        OrderForScooterPage orderForScooterPage = new OrderForScooterPage();
        Allure.step("Заполеняем данные формы <Для кого самокат>",
                ()-> orderForScooterPage.ordersDate(name, family, address, phone));
        Allure.step("Нажимаем на кнопку <Далее>",
                ()-> orderForScooterPage.clickNext());
    }
    @Step("Нажимаем на кнопку <Заказать>")
    public void clickOrderButton(int number) {
        MainPage mainPage = new MainPage();
        mainPage.clickOrderButton(number);
    }
}