package page;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderForRentPage extends BasePage {
    // Локатор поля когда привезти
    @FindBy(xpath = "//input[@placeholder='* Когда привезти самокат']")
    private WebElement dateField;
    // Локатор поля срок аренды
    @FindBy(xpath = "//div[text()='* Срок аренды']")
    private WebElement rentalField;
    // Локатор для выбора срока аренды
    @FindBy(xpath = "//div[text()='четверо суток']")
    private WebElement dateRental;
    // Локатор кнопки Заказать
    @FindBy(xpath = "//div[contains(@class,'Order_Buttons')]//button[text()='Заказать']")
    private WebElement ordersButton;
    // Локатор копки Подтвержедния заказа
    @FindBy(xpath = "//button[text()='Да']")
    private WebElement buttonYesConfirmation;
    // Локатор окна с данными заказа
    @FindBy(xpath = "//div[text()='Заказ оформлен']")
    private WebElement dataOrder;

    @Step("Заполение поля когда привезти")
    public void inputDate(String date) {
        dateField.sendKeys(date, Keys.ENTER); }
    @Step("Заполнение поля срок аренды")
    public void dateRenta () throws InterruptedException {
            rentalField.click();
            dateRental.click(); }
    @Step("Нажатие по кнопке заказать")
        public void clickOrder () {
            ordersButton.click();
        }
    @Step("Нажатие на кнопку подтверждения заказа")
        public void clickButtonYesConfirmation () {
            buttonYesConfirmation.click();
        }
    @Step("Проверка появления окна с данными заказа")
        public void waitForDataOrder () {
            dataOrder.isDisplayed();
        }
    public OrderForRentPage() {
            PageFactory.initElements(driver, this);
        }
}
