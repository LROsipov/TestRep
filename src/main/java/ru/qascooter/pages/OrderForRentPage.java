package ru.qascooter.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class OrderForRentPage {
    private static  final SelenideElement dataField = $x("//input[@placeholder='* Когда привезти самокат']");
    private static  final SelenideElement rentalField = $x("//div[text()='* Срок аренды']");
    private static  final SelenideElement rentalDate = $x("//div[text()='четверо суток']");
    private static  final SelenideElement ordersButton = $x("//div[contains(@class,'Order_Buttons')]//button[text()='Заказать']");
    private static  final SelenideElement yesConfirmationButton = $x("//button[text()='Да']");
    private static  final SelenideElement dataOrder = $x("//div[text()='Заказ оформлен']");

    /**
     * Выбор даты доставки
     */
    public void inputDate(String date) {
        dataField.shouldBe(enabled).sendKeys(date, Keys.ENTER);}

    /**
     * Выбор срока аренды
     */
    public void dateRent() {
        rentalField.shouldBe(enabled).click();
        rentalDate.shouldBe(enabled).click(); }
    /**
     * Клик по кнопке Заказать
     */
    public void clickOrder () {
        ordersButton.shouldBe(enabled).click();}

    /**
     * Клик на кнопку "Да" в окне подтвержения заказа
     */
    public void clickButtonYesConfirmation () {
        yesConfirmationButton.shouldBe(enabled).click();}

    /**
     * Проверяем появилось ли окно с данными о заказе
     */
    public void waitForDataOrder () {
        dataOrder.shouldBe(visible);
        }

}
