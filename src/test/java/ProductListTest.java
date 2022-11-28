import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProductListTest extends BaseTest {


    @Test(description = "Aranan ürün isminin doğru olduğunun kontrolü", groups = {"searchProduct"})
    @Parameters("product")
    public void shouldProductTxtBeValid(String product) {
        Assert.assertTrue(productList.checkProductTxtIsValid(product));
    }

    @Test(description = "SONUÇLAR header alanının sayfada görünmesi", groups = {"searchProduct"})
    public void shouldResultsHeaderBeVisible() {
        Assert.assertTrue(productList.checkResultsHeaderIsVisible());
    }

    @Test(description = "Ürün sıralama alanının sayfada görünmesi", groups = {"searchProduct"})
    public void shouldSortTxtBeVisible() {
        Assert.assertTrue(productList.checkSortTxtIsVisible());
    }

    @Test(description = "Arama sonuçlarında farklı bir sayfa seçilir", groups = {"searchProduct"}, priority = 1)
    @Parameters("pageNo")
    public void changeActivePage(String pageNo) {
        productList.changeActivePage(pageNo);
    }

    @Test(description = "Arama sonuçlarında istenilen sayfanın açıldığının kontrolü", groups = {"searchProduct"}, priority = 2)
    @Parameters("pageNo")
    public void shouldActivePageChanged(String pageNo) {
        Assert.assertTrue(productList.checkActivePageNo(pageNo));
    }

    @Test(description = "Ürün listesinden belirli bir ürünün detay sayfasının açılması", groups = {"addproduct"})
    @Parameters("productNo")
    public void selectAProduct(String productNo) {
        productList.selectProduct(productNo);
    }
}
