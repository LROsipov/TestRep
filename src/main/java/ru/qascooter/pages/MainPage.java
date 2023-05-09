package ru.qascooter.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import javax.annotation.Nonnull;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Гланвая страница
 */
public class MainPage  {
    private static  final SelenideElement ORDER_IN_HEADER_BUTTON = $(byXpath("//div[contains(@class, 'Header_Nav')]//button[text()='Заказать']"));
    private static  final SelenideElement FAQ_LIST = $(byXpath("//div[text()='Вопросы о важном']"));
    private static  final SelenideElement ORDER_IN_FOOTER_BUTTON = $(byXpath("//div[contains(@class, 'Home_Finish')]//button[text()='Заказать']"));
    private static  final SelenideElement LOGO_YANDEX_BUTTON = $(byXpath("//a//img[@alt=\"Yandex\"]"));
    private static  final SelenideElement LOGO_SCOOTER_BUTTON = $(byXpath("//a//img[@alt=\"Scooter\"]"));
    private static  final SelenideElement ORDER_STATUS_BUTTON = $(byXpath("//button[text()='Статус заказа']"));
    private static  final SelenideElement ORDER_GO_BUTTON = $(byXpath("//button[text()='Go!']"));

    /**
     * Кликает по лого "Самокат"
     */
    public void clickScooter() {
        LOGO_SCOOTER_BUTTON.shouldBe(enabled).click();
    }

    /**
     *  Переключение на открывщуюся вкладку
     */
    public void switchWindow() {

    }

    /**
     *  Клик по лого "Яндекс"
     */
    public void clickYandex() {
        LOGO_YANDEX_BUTTON.shouldBe(enabled).click();
    }

    /**
     * Кликает по кнопке заказать
     *
     * @param button  положение кнопки (1 вверху, другая цифра внизу)
     */
    public void clickOrderButton(int button)  {
        if (button == 1) {
            ORDER_IN_HEADER_BUTTON.shouldBe(enabled).click();}
        else {
            ORDER_IN_FOOTER_BUTTON
                    .scrollIntoView(true)
                    .shouldBe(enabled)
                    .click();
        }
    }

    /**
     *  Скролл до списка "FAQ"
     */
    public void scrollToListFaq(){
        FAQ_LIST.scrollIntoView(true); }
    /**
     *  Открытие раздела "FAQ" и сравнение текста в нем
     */
    public void checkTextInFaq(@Nonnull String caption, @Nonnull String selectText) {
        $(By.xpath(String.format("//div[text()='%s']", caption)))
                .scrollIntoView(true)
                .click();
        $(By.xpath(String.format("//div[text()='%s']/../../div/p", caption)))
                .shouldHave(text(selectText));
    }
}