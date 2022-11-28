import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public WebElement waitElementToBeClickable(WebElement element, int sec) {
        return new WebDriverWait(driver, Duration.ofSeconds(sec)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitElementToBeClickable(WebElement element) {
        return waitElementToBeClickable(element, 5);
    }

    public WebElement waitElementToBeVisible(WebElement element, int sec) {
        return new WebDriverWait(driver, Duration.ofSeconds(sec)).until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitElementToBeVisible(WebElement element) {
        return waitElementToBeVisible(element, 5);
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void Click(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void hoverToElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public boolean checkElementIsExist(String selector) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        boolean isExist = driver.findElements(By.xpath(selector)).size() > 0;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return isExist;
    }
}
