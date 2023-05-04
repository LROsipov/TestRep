package page;

import core.BasePage;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.Nonnull;
import java.util.Set;

// Класс главной страницы
public class MainPage extends BasePage {

    // Локатор кнопки закзать вверху страницы
    @FindBy(xpath = "//div[contains(@class, 'Header_Nav')]//button[text()='Заказать']")
    private WebElement orderInHeader;
    // Локатор списка FAQ
    @FindBy(xpath = "//div[text()='Вопросы о важном']")
    private WebElement listFaq;
    @FindBy(xpath = "//div[contains(@class, 'Home_Finish')]//button[text()='Заказать']")
    private WebElement orderInFooter;
    //Локатор лого Яндекс
    @FindBy(xpath = "//a//img[@alt=\"Yandex\"]")
    private WebElement buttonYandex;
    //Локатор лого Самокат
    @FindBy(xpath = "//a//img[@alt=\"Scooter\"]")
    private WebElement logoScooter;
    //Локатор кнопки Статус заказа
    @FindBy(xpath = "//button[text()='Статус заказа']")
    private WebElement orderStatus;
    //Локатор кнопки Go
    @FindBy(xpath = "//button[text()='Go!']")
    private WebElement buttonGo;
    @Step("Клик по лого Самокат")
    public void clickScooter() {
        logoScooter.click();
    }
    @Step("Переключение на открывщееся окно")
    public void switchWindow() {
        String windowNow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        String newWindow = null;
        for (String window : windows) {
            if (!window.equals(windowNow)) {
                newWindow = window;
                break;
            }
        }
        driver.switchTo().window(newWindow);
    }
    @Step("Клик по лого Яндекс")
    public void clickYandex() {
        buttonYandex.click();
    }
    @Step("Сравнеие сайтов")
    public void comparisonSite(String site) {
        Assert.assertTrue(site.equals(driver.getCurrentUrl()));
    }
    @Step("Сравнение сайтов")
    public void comparisonLogoRedirect(String site) {
        Assert.assertTrue(site.equals(driver.getCurrentUrl()));
    }

    /**
     * Кликает по кнопке заказать
     *
     * @param button  положение кнопки (1 вверху, другая цифра внизу)
     */
    @Step("Клик по кнопке заказать")
    public void clickOrderButton(int button)  {
        if (button == 1) {
            orderInHeader.click();}
        else {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",orderInFooter);
            orderInFooter.click();
        }
    }
    @Step("Скрол дл листа FAQ")
    public void scrollToListFaq(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",listFaq); }
    @Step("Cравнение текста")
    public void checkTextInFaq(@Nonnull String caption, @Nonnull String selectText) {
        WebElement  headerText  = driver.findElement(By.xpath(String.format("//div[text()='%s']", caption)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",headerText);
        headerText.click();
        WebElement textElement = driver.findElement(By.xpath(String.format("//div[text()='%s']/../../div/p", caption)));
        Assert.assertEquals( selectText, textElement.getText());
    }
    public MainPage() {
        PageFactory.initElements(driver,this);
    }
}