package ru.qascooter.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

// Класс страницы заказа
public class OrderForScooterPage  {
    private static  final SelenideElement NAME_FIELD = $(byXpath("//input[@placeholder='* Имя']"));
    private static  final SelenideElement FAMILY_FIELD = $(byXpath("//input[@placeholder='* Фамилия']"));
    private static  final SelenideElement ADRESS_FIELD = $(byXpath("//input[@placeholder='* Адрес: куда привезти заказ']"));
    private static  final SelenideElement METRO_FIELD = $(byXpath("//input[@placeholder='* Станция метро']"));
    private static  final SelenideElement PHONE_FIELD = $(byXpath("//input[@placeholder='* Телефон: на него позвонит курьер']"));
    private static  final SelenideElement NEXT_BUTTON = $(byXpath("//button[text()='Далее']"));

    /**
     * Заполение полей формы
     */
    public  OrderForScooterPage ordersDate(String name, String family, String address, String phone){
        NAME_FIELD.shouldBe(enabled).sendKeys(name);
        FAMILY_FIELD.shouldBe(enabled).sendKeys(family);
        ADRESS_FIELD.shouldBe(enabled).sendKeys(address);
        METRO_FIELD.shouldBe(enabled).click();
        $(byXpath("//ul/li[1]")).click();
        PHONE_FIELD.shouldBe(enabled).sendKeys(phone);
        return new OrderForScooterPage();
    }

    /**
     * Кликаем по кнопке Далее
     */
    public void clickNext() {
        NEXT_BUTTON.shouldBe(enabled).click(); }
   }
