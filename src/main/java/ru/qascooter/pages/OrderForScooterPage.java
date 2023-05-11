package ru.qascooter.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$x;

// Класс страницы заказа
public class OrderForScooterPage  {
    private static  final SelenideElement nameField = $x("//input[@placeholder='* Имя']");
    private static  final SelenideElement familyField = $x("//input[@placeholder='* Фамилия']");
    private static  final SelenideElement addressField = $x("//input[@placeholder='* Адрес: куда привезти заказ']");
    private static  final SelenideElement metroField = $x("//input[@placeholder='* Станция метро']");
    private static  final SelenideElement phoneField = $x("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private static  final SelenideElement nextButton = $x("//button[text()='Далее']");

    /**
     * Заполение полей формы
     */
    public  OrderForScooterPage ordersDate(String name, String family, String address, String phone){
        nameField.shouldBe(enabled).sendKeys(name);
        familyField.shouldBe(enabled).sendKeys(family);
        addressField.shouldBe(enabled).sendKeys(address);
        metroField.shouldBe(enabled).click();
        $x("//ul/li[1]").click();
        phoneField.shouldBe(enabled).sendKeys(phone);
        return new OrderForScooterPage();
    }

    /**
     * Кликаем по кнопке Далее
     */
    public void clickNext() {
        nextButton.shouldBe(enabled).click(); }
   }
