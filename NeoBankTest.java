import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class NeobankOneTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testNeoBankBusinessAccountOpening() {
        String expectedBrowserTabTitle = "NEOBANK для бізнесу";
        String expectedBusinessAccountOpeningText = "Відккриття бізнес-рахунку можливе тільки через NEOBANK для бізнесу";
    // Відкриття сторінки
    homePage.open();

    // Перевірка, що заголовок браузера вірний
    Assert.assertTrue(homePage.isBrowserTabTitleCorrect(expectedBrowserTabTitle), "Заголовок браузера невірний");

    // Введення номеру телефону
    homePage.enterPhoneNumber("+380636901699");

    // Натискання кнопки "Продовжити"
    homePage.clickContinueButton();

    // Розгортання вікна на весь екран
    homePage.maximizeWindow();

    // Перевірка, що текст відображається на сторінці
    Assert.assertTrue(homePage.isBusinessAccountOpeningTextDisplayed(expectedBusinessAccountOpeningText), "Текст не відображається на сторінці");

}

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
