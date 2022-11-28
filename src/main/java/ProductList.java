import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductList extends BasePage {
    public ProductList(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(), 'Aranan ürün:')]/following-sibling::span[last()]")
    private WebElement productTxt;

    @FindBy(xpath = "//span[text() = 'SONUÇLAR']")
    private WebElement resultsHeader;

    @FindBy(xpath = "//span[text() = 'Sırala:']")
    private WebElement sortTxt;

    @FindBy(css = "div.s-search-results")
    private WebElement productsContainer;

    @FindBy(xpath = "//span[@class = 's-pagination-strip']")
    private WebElement paginationContainer;

    public boolean checkProductTxtIsValid(String product) {
        return waitElementToBeVisible(this.productTxt).getText()
                .replaceAll("[^a-zA-Z0-9]", "").equals(product);
    }

    public boolean checkResultsHeaderIsVisible() {
        return this.resultsHeader.isDisplayed();
    }

    public boolean checkSortTxtIsVisible() {
        return this.sortTxt.isDisplayed();
    }

    public WebElement getPageNoElm(String pageNo) {
        return this.paginationContainer.findElement(By.xpath(".//a[text() = '" + pageNo + "']"));
    }

    public void changeActivePage(String pageNo) {
        WebElement element = getPageNoElm(pageNo);
        scrollIntoView(element);
        element.click();
    }

    public boolean checkActivePageNo(String pageNo) {
        waitElementToBeVisible(this.resultsHeader);
        return this.paginationContainer.findElement(By.cssSelector(".s-pagination-selected")).getText().equals(pageNo);
    }

    public WebElement getAProductByIndex(String index) {
        List<WebElement> products = this.productsContainer.findElements(By.xpath("./div[@data-component-type = 's-search-result']"));
        return products.get(Integer.parseInt(index) - 1);
    }

    public void selectProduct(String index) {
        getAProductByIndex(index).click();
    }
}
