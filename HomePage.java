import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(css = "input[name='phone']")
    private WebElement phoneNumberInput;

    @FindBy(css = "button[type='submit']")
    private WebElement continueButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://web.neobank.one/");
    }

    public boolean isBrowserTabTitleCorrect(String expectedTitle) {
        return driver.getTitle().equals(expectedTitle);
    }

    public void enterPhoneNumber(String phoneNumber) {
        phoneNumberInput.sendKeys(phoneNumber);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public boolean isBusinessAccountOpeningTextDisplayed(String expectedText) {
        return driver.findElement(By.xpath("//*[contains(text(),'" + expectedText + "')]")).isDisplayed();
    }
}
