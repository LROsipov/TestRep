package ru.qascooter.ui;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.qascooter.pages.MainPage;
import ru.qascooter.pages.OrderForRentPage;
import ru.qascooter.pages.OrderForScooterPage;

import java.time.LocalDate;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Story("Проверка оформления заказа")
@DisplayName("Проверка оформления заказа")
public class OrderTest extends BaseTest {
    LocalDate tomorrow = LocalDate.now().plusDays(1);
    public final String date = tomorrow.toString();
    private MainPage mainPage;
    private OrderForScooterPage orderForScooterPage;
    private OrderForRentPage orderForRentPage;

    public static Stream<Arguments> isOrderData() {
        return Stream.of(
                arguments(0, "Тестирование", "Тестировщик", "Улица Пушкина Дом колатошкина", "33333333333"),
                arguments(1, "Проверказаказа", "Тестировщик", "Улица Тушкина Дом полатошкина", "44444444444")
        );
    }

    @BeforeEach
    void arrangeTestData() {
        mainPage = MainPage.open();
    }

    @ParameterizedTest
    @MethodSource("isOrderData")
    @Description("Оформление заказа")
    void testOrder(int number, String name, String family, String address, String phone) {
        mainPage.clickOrderButton(number);
        orderForScooterPage = new OrderForScooterPage();
        orderForScooterPage.fillNameField(name)
                .fillFamilyField(family)
                .fillAddressField(address)
                .fillMetroField()
                .fillPhoneField(phone)
                .clickNext();
        orderForRentPage = new OrderForRentPage();
        orderForRentPage.inputDate(date)
                .dateRent()
                .clickOrder()
                .clickButtonYesConfirmation();
        Allure.step("Проверяем что появилось окно [Заказ оформлен]",
                () -> orderForRentPage.dataOrder.shouldBe(visible));

    }

    @AfterEach
    public void close() {
        closeWindow();
    }

}