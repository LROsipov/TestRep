package test;

import core.BaseTest;
import io.qameta.allure.Epic;
import page.MainPage;
import page.OrderForRentPage;
import page.OrderForScooterPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalDate;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {
    private final String name;
    private final String family;
    private final String address;
    private final String phone;
    private final int number;
    // Получаем завтрашнюю дату
    LocalDate now = LocalDate.now().plusDays(1);
    private final String date  = now.toString();


    public OrderTest(int number,String name, String family, String address, String phone) {
        this.number = number;
        this.name = name;
        this.family = family;
        this.address = address;
        this.phone = phone;
    }
    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                { 1, "Тестирование", "Тестировщик", "Улица Пушкина Дом колатошкина","33333333333" },
                { 2, "Тестировщик", "Тестирование", "Улица Тушкина Дом болатошкина","22222222222" },
        };
    }
    @Epic(value="Заказ")
    @Test
    public void testOrder() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.clickOrderButton(number);
        OrderForScooterPage orderForScooterPage = new OrderForScooterPage();
        orderForScooterPage.ordersDate(name,family,address,phone);
        orderForScooterPage.clickNext();
        OrderForRentPage orderForRentPage = new OrderForRentPage();
        orderForRentPage.inputDate(date);
        orderForRentPage.dateRenta();
        orderForRentPage.clickOrder();
        orderForRentPage.clickButtonYesConfirmation();
        orderForRentPage.waitForDataOrder();
    }
}