package page;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Класс страницы заказа
public class OrderForScooterPage extends BasePage {
    // Локатор поля имя
    @FindBy(xpath = "//input[@placeholder='* Имя']")
    private WebElement nameField;
    // Локатор поля  фамилия
    @FindBy(xpath = "//input[@placeholder='* Фамилия']")
    private WebElement familyField ;
    // Локатор поля адресс
    @FindBy(xpath = "//input[@placeholder='* Адрес: куда привезти заказ']")
    private WebElement addressField;
    // Локатор поля метро
    @FindBy(xpath = "//input[@placeholder='* Станция метро']")
    private WebElement metroField;
    // Локатор поля телефон
    @FindBy(xpath = "//input[@placeholder='* Телефон: на него позвонит курьер']")
    private WebElement phoneField;
    // Локатор кнопки Далее
    @FindBy(xpath = "//button[text()='Далее']")
    private WebElement nextButton;

    // Метод заполнений данных формы
    public OrderForScooterPage ordersDate(String name, String family, String address, String phone){
        nameField.sendKeys(name);
        familyField.sendKeys(family);
        addressField.sendKeys(address);
        metroField.click();
        driver.findElement(By.xpath("//ul/li[1]")).click();
        phoneField.sendKeys(phone);
        return new OrderForScooterPage();
    }
    // Метод нажатия на кнопку Далее
    public void clickNext() {
        nextButton.click(); }
    public OrderForScooterPage() {
        PageFactory.initElements(driver,this);
    }

   }
