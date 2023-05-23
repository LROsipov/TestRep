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

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.params.provider.Arguments.arguments;
@Story("Проверка текста в списке [FAQ]")
@DisplayName("Проверка текста в списке [FAQ]")
public class TextFaqTest extends BaseTest {
    private MainPage mainPage;

    public static Stream<Arguments> isTextData() {
        return Stream.of(
                arguments("Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."),
                arguments("Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."),
                arguments("Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."),
                arguments("Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."),
                arguments("Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."),
                arguments("Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."),
                arguments("Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."),
                arguments("Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области.")
        );
    }

    @BeforeEach
    void arrangeTestData() {
        mainPage = MainPage.open();
    }

    @ParameterizedTest
    @MethodSource("isTextData")
    @Description("Проверка текста в списке [FAQ]")
    public void testTextFaq(String headerText, String text) {
        mainPage.scrollToListFaq();
        mainPage.clickTextInFaq(headerText);
        Allure.step("Проверяем текст ответа в списке [FAQ]",
                () -> $x(String.format("//div[text()='%s']/../../div/p", headerText)).shouldHave(text(text)));
    }

    @AfterEach
    public void close() {
        closeWindow();
    }
}