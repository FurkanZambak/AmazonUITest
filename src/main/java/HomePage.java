import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

    String MAIN_URL = "https://www.amazon.com.tr";
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "nav-logo-sprites")
    private WebElement logoElm;

    @FindBy(id = "nav-link-accountList")
    private WebElement logInLink;

    @FindBy(id = "sp-cc-accept")
    private WebElement acceptCookiesBut;

    @FindBy(xpath = "//*[@id = 'nav-flyout-ya-signin']//span[text() = 'Giriş yap']")
    private WebElement loginBut;

    @FindBy(id = "nav-item-signout")
    private WebElement signOutLink;

    @FindBy(xpath = "//span[text() = 'Liste Oluşturun']/./..")
    private WebElement createListLink;

    @FindBy(id = "searchDropdownBox")
    private WebElement categoryDropdown;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBoxField;

    @FindBy(id = "nav-search-label-id")
    private WebElement selectedCategory;

    public void openHomePage() {
        driver.get(MAIN_URL);
    }

    public boolean checkLogoIsVisible() {
        return waitElementToBeVisible(this.logoElm).isDisplayed();
    }

    public boolean checkLogoHrefIsValid() {
        return this.logoElm.getAttribute("href").equals(MAIN_URL + "/ref=nav_logo");
    }

    public boolean checkLogInLinkIsVisible() {
        return this.logInLink.isDisplayed();
    }

    public boolean checkLogInHrefIsValid() {
        return this.logInLink.getAttribute("href").contains(MAIN_URL + "/ap/signin");
    }

    public boolean checkPageTitle(String pageTitle) {
        return getPageTitle().contains(pageTitle);
    }

    public void clickAcceptCookiesBut() {
        this.acceptCookiesBut.click();
    }

    public void hoverToLoginField() throws InterruptedException {
        //scrollIntoView(this.searchBoxField);
        hoverToElement(this.logInLink);
        Thread.sleep(1000);
    }

    public void clickLoginBut() {
        waitElementToBeClickable(this.loginBut).click();
    }

    public boolean checkUserNameIsVisible(String userName) {
        WebElement element = this.logInLink.findElement(By.xpath(".//span[contains(text(), '" + userName + "')]"));
        return waitElementToBeVisible(element).isDisplayed();
    }

    public boolean checkLoginButNotExist() {
        String selector = "//*[@id = 'nav-flyout-ya-signin']//span[text() = 'Giriş yap']";
        return !checkElementIsExist(selector);
    }

    public boolean checkSignOutLinkIsVisible() {
        return this.signOutLink.isDisplayed();
    }

    public void clickCreateListLink() {
        this.createListLink.click();
    }

    public void selectACategory(String categoryOpt) {
        Select categoryDrop = new Select(this.categoryDropdown);
        categoryDrop.selectByVisibleText(categoryOpt);
    }

    public boolean checkSelectedCategoryIsValid(String categoryOpt) {
        return this.selectedCategory.getText().equals(categoryOpt);
    }

    public void typeSearchBoxField(String product) {
        this.searchBoxField.sendKeys(product);
        this.searchBoxField.sendKeys(Keys.ENTER);
    }

    public void clickListItem(String listName) {
        WebElement element = driver.findElement(By.xpath("//span[text() = '" + listName + "']/./.."));
        //scrollIntoView(element);
        Click(element);
    }

    public void clickSignOutLink() {
        this.signOutLink.click();
    }

    public boolean checkLoginButtonBeVisible() {
        return waitElementToBeVisible(this.loginBut).isDisplayed();
    }

    public boolean checkSignOutLinkNotExist() {
        String selector = "//*[@id = 'nav-item-signout']";
        return !checkElementIsExist(selector);
    }
}
