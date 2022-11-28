import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ListPageTest extends BaseTest {

    @Test(description = "Bir liste oluştur butonuna tıklanır", priority = 0)
    public void clickCreateAListBut() {
        listPage.clickCreateAListBut();
    }

    @Test(description = "Liste adı alanına istenilen değer girilir", priority = 1)
    @Parameters("listName")
    public void typeListName(String listName) {
        listPage.typeListName(listName);
    }

    @Test(description = "Liste Oluştur butonuna tıklanır", priority = 2)
    public void clickCreateListBut() {
        listPage.clickCreateListBut();
    }

    @Test(description = "Liste adının kontrol edilmesi", priority = 3)
    @Parameters("listName")
    public void shouldListNameTxtBeValid(String listName) {
        Assert.assertEquals(listPage.getListNameTxt(), listName);
    }

    @Test(description = "Kaldır butonuna tıklanır", groups = {"deletefromlist"}, priority = 0)
    public void clickRemoveProductBut() {
        listPage.clickRemoveProductBut();
    }

    @Test(description = "Kaldırılan ürün için Silindi ibaresinin görülmesi", groups = {"deletefromlist"}, priority = 1)
    public void shouldRemovedAlertTxtBeVisible() {
        Assert.assertTrue(listPage.checkRemovedAlertTxtIsVisible());
    }

    @Test(description = "Kaldır butonunun artık sayfada bulunmadığının kontrolü", groups = {"deletefromlist"}, priority = 2)
    public void shouldRemoveButNotExist() {
        Assert.assertTrue(listPage.checkRemoveProductButNotExist());
    }
}
