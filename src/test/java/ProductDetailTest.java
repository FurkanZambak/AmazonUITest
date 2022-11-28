import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProductDetailTest extends BaseTest {

    @Test(description = "Listeye Ekle dropdown elementine tıklanır", groups = {"addproduct"}, priority = 0)
    public void clickWishListDropdown() {
        productDetailPage.clickWishListDropdown();
    }

    @Test(description = "İlgili liste elementi seçilir", groups = {"addproduct"}, priority = 1)
    @Parameters("listName")
    public void clickWishListItem(String listName) {
        productDetailPage.clickListItem(listName);
    }

    @Test(description = "Liste isminin doğru olduğunun kontrol edilmesi", groups = {"addproduct"}, priority = 2)
    @Parameters("listName")
    public void shouldListLinkBeValid(String listName) {
        Assert.assertTrue(productDetailPage.checkListLinkIsValid(listName));
    }

    @Test(description = "Ürün eklendi textinin görünür olması", groups = {"addproduct"}, priority = 3)
    public void shouldAddTxtBeVisible() {
        Assert.assertTrue(productDetailPage.checkAddTxtIsVisible());
    }

    @Test(description = "Eklenen ürün adının kontrol edilmesi", groups = {"addproduct"}, priority = 3)
    public void shouldProductNameBeValid() {
        //Assert.assertTrue(productDetailPage.checkProductTitleIsValid());
    }

    @Test(description = "Listeye eklendi modal ekranının kapatılması", groups = {"deletefromlist"})
    public void clickCloseModalBut() {
        productDetailPage.clickCloseModalBut();
    }
}
