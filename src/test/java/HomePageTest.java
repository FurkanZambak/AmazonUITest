import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest extends BaseTest {

    @Test(description = "Anasayfa açılır", groups = {"checkhomepage", "checklogout"},priority = 0)
    public void openHomePage() {
        homePage.openHomePage();
    }

    @Test(description = "Logonun görünürlüğü kontrol edilir", groups = {"checkhomepage"}, priority = 1)
    public void shouldLogoBeVisible() {
        Assert.assertTrue(homePage.checkLogoIsVisible());
    }

    @Test(description = "Logo elementinin href değerinin valid olduğunun kontrolü", groups = {"checkhomepage"}, priority = 2)
    public void shouldLogoHaveValidHref() {
        Assert.assertTrue(homePage.checkLogoHrefIsValid());
    }

    @Test(description = "Giriş yap linkinin görünürlüğü kontrol edilir", groups = {"checkhomepage"}, priority = 3)
    public void shouldLogInLinkBeVisible() {
        Assert.assertTrue(homePage.checkLogInLinkIsVisible());
    }

    @Test(description = "Giriş yap linkinin href değerinin valid olduğunun kontrolü", groups = {"checkhomepage"}, priority = 4)
    public void shouldLogInHaveValidHref() {
        Assert.assertTrue(homePage.checkLogInHrefIsValid());
    }

    @Test(description = "Ana sayfada title değerinin kontrol edilmesi", groups = {"checkhomepage"}, priority = 5)
    @Parameters("pageTitle")
    public void shouldPageTitleBeValid(String pageTitle) {
        Assert.assertTrue(homePage.checkPageTitle(pageTitle));
    }

    @Test(description = "Çerezleri Kabul Et butonuna tıklanır", groups = {"login"}, priority = 0)
    public void clickAcceptCookiesBut() {
        homePage.clickAcceptCookiesBut();
    }

    @Test(description = "Giriş yap butonuna tıklanması", groups = {"login"}, priority = 1)
    public void hoverAndClickLoginBut() throws InterruptedException {
        homePage.hoverToLoginField();
        homePage.clickLoginBut();
    }

    @Test(description = "Kullanıcının adının kontrol edilmesi", groups = {"checklogin"})
    @Parameters("userName")
    public void shouldValidUserNameBeVisible(String userName) {
        Assert.assertTrue(homePage.checkUserNameIsVisible(userName));
    }

    @Test(description = "Giriş yap butonunun sayfada bulunmadığının kontrolü", groups = {"checklogin"})
    public void shouldLoginButtonNotExist() throws InterruptedException {
        homePage.hoverToLoginField();
        Assert.assertTrue(homePage.checkLoginButNotExist());
    }

    @Test(description = "Çıkış yap butonunun görünür olması", groups = {"checklogin"})
    public void shouldSignOutButtonBeVisible() throws InterruptedException {
        homePage.hoverToLoginField();
        Assert.assertTrue(homePage.checkSignOutLinkIsVisible());
    }

    @Test(description = "Liste Oluşturun linkine tıklanır")
    public void clickCreateListLink() {
        homePage.clickCreateListLink();
    }

    @Test(description = "Kategori listesinden bir değer seçilmesi", groups = {"searchProduct"}, priority = 0)
    @Parameters("categoryOpt")
    public void selectACategory(String categoryOpt) {
        homePage.selectACategory(categoryOpt);
    }

    @Test(description = "Kategori seçiminin doğru olduğunun kontrol edilmesi", groups = {"searchProduct"}, priority = 1)
    @Parameters("categoryOpt")
    public void shouldSelectedCategoryBeValid(String categoryOpt) {
        Assert.assertTrue(homePage.checkSelectedCategoryIsValid(categoryOpt));
    }

    @Test(description = "Searchbox alanına değer girilerek arama yapılır", groups = {"searchProduct"}, priority = 2)
    @Parameters("product")
    public void searchAProduct(String product) {
        homePage.typeSearchBoxField(product);
    }

    @Test(description = "Hesap ve Listeler bölümünden ilgili listenin açılması", groups = "deletefromlist")
    @Parameters("listName")
    public void openListPage(String listName) throws InterruptedException {
        homePage.hoverToLoginField();
        homePage.clickListItem(listName);
    }

    @Test(description = "Çıkış yap linkine tıklanması", groups = {"logout"})
    public void clickSignOutLink() throws InterruptedException {
        homePage.hoverToLoginField();
        homePage.clickSignOutLink();
    }

    @Test(description = "Giriş yap butonunun sayfada göründüğünün kontrolü", groups = {"checklogout"}, priority = 1)
    public void shouldLoginButtonBeVisible() throws InterruptedException {
        homePage.hoverToLoginField();
        Assert.assertTrue(homePage.checkLoginButtonBeVisible());
    }

    @Test(description = "Çıkış yap butonunun sayfada bulunmadığının kontrolü", groups = {"checklogout"}, priority = 2)
    public void shouldSignOutButtonNotExist() {
        Assert.assertTrue(homePage.checkSignOutLinkNotExist());
    }

}
