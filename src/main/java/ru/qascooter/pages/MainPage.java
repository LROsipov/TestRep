package ru.qascooter.pages;

import com.codeborne.selenide.As;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import javax.annotation.Nonnull;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Гланвая страница
 */
public class MainPage {
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    @As("Кнопка [Заказать]")
    private final SelenideElement orderInHeaderButton = $x("//div[contains(@class, 'Header_Nav')]//button[text()='Заказать']");
    @As("Список [Вопросы о важном]")
    private final SelenideElement faqList = $x("//div[text()='Вопросы о важном']");
    @As("Кнопка [Заказать]")
    private final SelenideElement orderInFooterButton = $x("//div[contains(@class, 'Home_Finish')]//button[text()='Заказать']");
    @As("Лого [Яндекс]")
    private final SelenideElement logoYandexButton = $x("//a//img[@alt=\"Yandex\"]");
    @As("Лого [Самокат]")
    private final SelenideElement logoScooterButton = $x("//a//img[@alt=\"Scooter\"]");
    @As("Кнопка [Статус заказа]")
    private final SelenideElement orderStatusButton = $x("//button[text()='Статус заказа']");
    @As("Кнопка [go!]")
    private final SelenideElement orderGoButton = $x("//button[text()='Go!']");

    public MainPage() {
        orderInHeaderButton.shouldBe(visible);
        logoYandexButton.shouldBe(visible);
        logoScooterButton.shouldBe(visible);
        orderStatusButton.shouldBe(visible);
    }


    public static MainPage open() {
        return Selenide.open(URL, MainPage.class);
    }

    @Step("Клик по лого [Самокат]")
    public void clickScooter() {
        logoScooterButton.shouldBe(enabled).click();
    }

    @Step("Клик по лого [Яндекс]")
    public final void clickLogoYandex() {
        logoYandexButton.shouldBe(enabled).click();
    }

    @Step("Клик по кнопке [Статус заказа]")
    public final MainPage clickOrderStatus() {
        orderStatusButton.shouldBe(enabled).click();
        return this;
    }

    @Step("Клик по кнопке [Go]")
    public final void clickGoButton() {
        orderGoButton.shouldBe(enabled).click();
    }

    @Step("Клик по кнопке [Заказать]")
    public void clickOrderButton(int button) {
        if (button == 1) {
            orderInHeaderButton.shouldBe(enabled).click();
        } else {
            orderInFooterButton
                    .scrollIntoView(true)
                    .shouldBe(enabled)
                    .click();
        }
    }

    @Step("Скролл до списка [FAQ]")
    public void scrollToListFaq() {
        faqList.scrollIntoView(true);
    }

    @Step("Клик  по вопросу в  списке [FAQ]")
    public void clickTextInFaq(@Nonnull String caption) {
        $x(String.format("//div[text()='%s']", caption))
                .scrollIntoView(true)
                .click();
    }

}