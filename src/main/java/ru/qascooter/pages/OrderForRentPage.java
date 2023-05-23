package ru.qascooter.pages;

import com.codeborne.selenide.As;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$x;

public class OrderForRentPage {
    @As("Окно [Заказ оформлен]")
    public final SelenideElement dataOrder = $x("//div[text()='Заказ оформлен']");
    @As("Поле [Когда привезти самокат]")
    private final SelenideElement dataField = $x("//input[@placeholder='* Когда привезти самокат']");
    @As("Поле [Срок аренды]")
    private final SelenideElement rentalField = $x("//div[text()='* Срок аренды']");
    @As("Срок аренды [Четверо суток]")
    private final SelenideElement rentalDate = $x("//div[text()='четверо суток']");
    @As("Кнопка [Заказать]")
    private final SelenideElement ordersButton = $x("//div[contains(@class,'Order_Buttons')]//button[text()='Заказать']");
    @As("Кнопка [Да]")
    private final SelenideElement yesConfirmationButton = $x("//button[text()='Да']");

    @Step("Заполняем поле [Когда привезти самокат]")
    public OrderForRentPage inputDate(String date) {
        dataField.shouldBe(enabled).sendKeys(date, Keys.ENTER);
        return this;
    }

    @Step("Выбираем [Срок аренды]")
    @SneakyThrows
    public OrderForRentPage dateRent() {
        rentalField.shouldBe(enabled).click();
        rentalDate.shouldBe(enabled).click();
        return this;
    }

    @Step("Клик по кнопке [Заказать]")
    public OrderForRentPage clickOrder() {
        ordersButton.shouldBe(enabled).click();
        return this;
    }

    @Step("Клик по кнопке [Да] в окне подтвежелния ")
    public OrderForRentPage clickButtonYesConfirmation() {
        yesConfirmationButton.shouldBe(enabled).click();
        return this;
    }


}
