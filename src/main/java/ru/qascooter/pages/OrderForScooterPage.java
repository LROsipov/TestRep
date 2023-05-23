package ru.qascooter.pages;

import com.codeborne.selenide.As;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

// Класс страницы заказа
public class OrderForScooterPage {
    @As("Поле [Имя]")
    private final SelenideElement nameField = $x("//input[@placeholder='* Имя']");
    @As("Поле [Фамилия]")
    private final SelenideElement familyField = $x("//input[@placeholder='* Фамилия']");
    @As("Поле [Адресс")
    private final SelenideElement addressField = $x("//input[@placeholder='* Адрес: куда привезти заказ']");
    @As("Поле [Станция метро]")
    private final SelenideElement metroField = $x("//input[@placeholder='* Станция метро']");
    @As("Поле [Телефон]")
    private final SelenideElement phoneField = $x("//input[@placeholder='* Телефон: на него позвонит курьер']");
    @As("Кнопка [Далее]")
    private final SelenideElement nextButton = $x("//button[text()='Далее']");

    public OrderForScooterPage() {
        nameField.shouldBe(visible);
        familyField.shouldBe(visible);
        addressField.shouldBe(visible);
        metroField.shouldBe(visible);
        phoneField.shouldBe(visible);
        nextButton.shouldBe(visible);
    }

    @Step("Заполняем поле [Имя]")
    public final OrderForScooterPage fillNameField(String name) {
        nameField.shouldBe(visible).setValue(name);
        return this;
    }

    @Step("Заполняем поле [Фамилия]")
    public final OrderForScooterPage fillFamilyField(String family) {
        familyField.shouldBe(enabled).setValue(family);
        return this;
    }

    @Step("Заполняем поле [Адресс]")
    public final OrderForScooterPage fillAddressField(String address) {
        addressField.shouldBe(enabled).setValue(address);
        return this;
    }

    @Step("Заполняем поле [Метро]")
    public final OrderForScooterPage fillMetroField() {
        metroField.shouldBe(enabled).click();
        $x("//ul/li[1]").click();
        return this;
    }

    @Step("Заполняем поле [Телефон]")
    public final OrderForScooterPage fillPhoneField(String phone) {
        phoneField.shouldBe(enabled).setValue(phone);
        return this;
    }

    @Step("Клик по кнопке [Далее]")
    public void clickNext() {
        nextButton.shouldBe(enabled).click();
    }
}
