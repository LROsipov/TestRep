package ru.qascooter.pages;

import com.codeborne.selenide.SelenideElement;
import javax.annotation.Nonnull;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Гланвая страница
 */
public class MainPage  {
    private static  final SelenideElement orderInHeaderButton = $x("//div[contains(@class, 'Header_Nav')]//button[text()='Заказать']");
    private static  final SelenideElement faqList = $x("//div[text()='Вопросы о важном']");
    private static  final SelenideElement orderInFooterButton = $x("//div[contains(@class, 'Home_Finish')]//button[text()='Заказать']");
    private static  final SelenideElement logoYandexButton = $x("//a//img[@alt=\"Yandex\"]");
    private static  final SelenideElement logoScooterButton = $x("//a//img[@alt=\"Scooter\"]");
    private static  final SelenideElement orderStatusButton = $x("//button[text()='Статус заказа']");
    private static  final SelenideElement orderGoButton= $x("//button[text()='Go!']");

    /**
     * Кликает по лого "Самокат"
     */
    public void clickScooter() {
        logoScooterButton.shouldBe(enabled).click();
    }

    /**
     *  Клик по лого "Яндекс"
     */
    public void clickYandex() {
        logoYandexButton .shouldBe(enabled).click();

    }
    /**
     *  Переход на страницу "Статус заказа"
     */
    public void clickOrderStatus() {
        orderStatusButton.shouldBe(enabled).click();
        orderGoButton.shouldBe(enabled).click();

    }

    /**
     * Кликает по кнопке заказать
     *
     * @param button  положение кнопки (1 вверху, другая цифра внизу)
     */
    public void clickOrderButton(int button)  {
        if (button == 1) {
            orderInHeaderButton.shouldBe(enabled).click();}
        else {
            orderInFooterButton
                    .scrollIntoView(true)
                    .shouldBe(enabled)
                    .click();
        }
    }

    /**
     *  Скролл до списка "FAQ"
     */
    public void scrollToListFaq(){
        faqList.scrollIntoView(true); }
    /**
     *  Открытие раздела "FAQ" и сравнение текста в нем
     */
    public void checkTextInFaq(@Nonnull String caption, @Nonnull String selectText) {
        $x(String.format("//div[text()='%s']", caption))
                .scrollIntoView(true)
                .click();
        $x(String.format("//div[text()='%s']/../../div/p", caption))
                .shouldHave(text(selectText));
    }
}