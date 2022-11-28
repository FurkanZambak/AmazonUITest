import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {
    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "ap_email")
    private WebElement emailInput;

    @FindBy(id = "continue")
    private WebElement continueBut;

    @FindBy(id = "ap_password")
    private WebElement passwordInput;

    @FindBy(id = "signInSubmit")
    private WebElement loginBut;

    @FindBy(xpath = "//h1[contains(text(), 'Giriş yap')]")
    private WebElement loginHeader;

    public void typeEmailInput(String email) {
        this.emailInput.sendKeys(email);
    }

    public void typePasswordInput(String password) {
        this.passwordInput.sendKeys(password);
    }

    public void clickContinueBut() {
        this.continueBut.click();
    }

    public void clickLoginBut() {
        this.loginBut.click();
    }

    public boolean checkLoginHeaderIsVisible() {
        return this.loginHeader.isDisplayed();
    }

    public boolean checkEmailInputIsVisible() {
        return waitElementToBeVisible(this.emailInput).isDisplayed();
    }
}
