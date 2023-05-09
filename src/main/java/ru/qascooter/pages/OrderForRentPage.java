package ru.qascooter.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class OrderForRentPage {
    private static  final SelenideElement DATE_FIELD = $(byXpath("//input[@placeholder='* Когда привезти самокат']"));
    private static  final SelenideElement RENTAL_FIELD = $(byXpath("//div[text()='* Срок аренды']"));
    private static  final SelenideElement RENTAL_DATE = $(byXpath("//div[text()='четверо суток']"));
    private static  final SelenideElement ORDERS_BUTTON = $(byXpath("//div[contains(@class,'Order_Buttons')]//button[text()='Заказать']"));
    private static  final SelenideElement YES_CONFIRMATION_BUTTON = $(byXpath("//button[text()='Да']"));
    private static  final SelenideElement DATA_ORDER = $(byXpath("//div[text()='Заказ оформлен']"));

    /**
     * Выбор даты доставки
     */
    public void inputDate(String date) {
        DATE_FIELD.shouldBe(enabled).sendKeys(date, Keys.ENTER);}

    /**
     * Выбор срока аренды
     */
    public void dateRenta () throws InterruptedException {
            RENTAL_FIELD.shouldBe(enabled).click();
            RENTAL_DATE.shouldBe(enabled).click(); }
    /**
     * Клик по кнопке Заказать
     */
    public void clickOrder () {
            ORDERS_BUTTON.shouldBe(enabled).click();}

    /**
     * Клик на кнопку "Да" в окне подтвержения заказа
     */
    public void clickButtonYesConfirmation () {
       YES_CONFIRMATION_BUTTON.shouldBe(enabled).click();}

    /**
     * Проверяем появилось ли окно с данными о заказе
     */
    public void waitForDataOrder () {
        DATA_ORDER.shouldBe(visible);
        }

}
