import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage {
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "productTitle")
    private WebElement productTitle;

    @FindBy(id = "wishListDropDown")
    private WebElement wishListDropdown;

    @FindBy(xpath = "//div[@id = 'huc-atwl-header-section']//span[text() = '1 ürün şuraya eklendi:']")
    private WebElement addListTxt;

    @FindBy(id = "huc-list-link")
    private WebElement listLink;

    @FindBy(xpath = "//a[@id = 'huc-item-link']/span")
    private WebElement itemHeader;

    @FindBy(xpath = "//header//button[@aria-label = 'Close']")
    private WebElement closeBut;

    public WebElement getWishListItem(String listName) {
        WebElement element = driver.findElement(By.xpath("//span[contains(@id, 'atwl-list-name') and contains(text(), '" + listName + "')]"));
        return waitElementToBeVisible(element);
    }

    public void clickListItem(String listName) {
        getWishListItem(listName).click();
    }

    public void clickWishListDropdown() {
        WebElement elm = waitElementToBeVisible(this.wishListDropdown);
        //scrollIntoView(elm);
        elm.click();
    }

    public boolean checkListLinkIsValid(String listName) {
        WebElement element = this.listLink.findElement(By.xpath("./span[text() = '" + listName + "']"));
        return waitElementToBeVisible(element).isDisplayed();
    }

    public boolean checkAddTxtIsVisible() {
        return this.addListTxt.isDisplayed();
    }

    public boolean checkProductTitleIsValid() {
        System.out.println(this.itemHeader.getText());
        System.out.println(this.productTitle.getText());
        return this.itemHeader.getText().equals(this.productTitle.getText().trim());
    }

    public void clickCloseModalBut() {
        this.closeBut.click();
    }
}
