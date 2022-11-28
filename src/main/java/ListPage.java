import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListPage extends BasePage {
    public ListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id = 'createList']//input")
    private WebElement createAListBut;

    @FindBy(id = "list-name")
    private WebElement listNameInput;

    @FindBy(xpath = "//span[text() = 'Liste Oluştur']/preceding-sibling::input")
    private WebElement createListBut;

    @FindBy(id = "profile-list-name")
    private WebElement listNameTxt;

    @FindBy(name = "submit.deleteItem")
    private WebElement removeProductBut;

    @FindBy(xpath = "//div[@class = 'a-alert-content' and text() = 'Silindi']")
    private WebElement removedAlertTxt;

    public void clickCreateAListBut() {
        this.createAListBut.click();
    }

    public void typeListName(String listName) {
        this.listNameInput.clear();
        this.listNameInput.sendKeys(listName);
    }

    public void clickCreateListBut() {
        this.createListBut.click();
    }

    public String getListNameTxt() {
        return waitElementToBeVisible(this.listNameTxt).getText();
    }

    public void clickRemoveProductBut() {
        this.removeProductBut.click();
    }

    public boolean checkRemoveProductButNotExist() {
        String selector = "//input[@name = 'submit.deleteItem']";
        return !checkElementIsExist(selector);
    }

    public boolean checkRemovedAlertTxtIsVisible() {
        return waitElementToBeVisible(this.removedAlertTxt).isDisplayed();
    }

}
