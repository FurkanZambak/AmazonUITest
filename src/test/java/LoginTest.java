import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Email alanına değer girilir", priority = 0)
    @Parameters("email")
    public void typeEmailData(String email) {
        logInPage.typeEmailInput(email);
    }

    @Test(description = "Devam et butonuna tıklanır", priority = 1)
    public void clickContinueBut() {
        logInPage.clickContinueBut();
    }

    @Test(description = "Şifre alanına değer girilir", priority = 2)
    @Parameters("password")
    public void typePasswordData(String password) {
        logInPage.typePasswordInput(password);
    }

    @Test(description = "Giriş yap butonuna tıklanır", priority = 3)
    public void clickLoginBut() {
        logInPage.clickLoginBut();
    }

    @Test(description = "Login header alanının sayfada görünmesi", groups = {"logout"})
    public void shouldLoginHeaderBeVisible() {
        Assert.assertTrue(logInPage.checkLoginHeaderIsVisible());
    }

    @Test(description = "Email input alanının sayfada görünmesi", groups = {"logout"})
    public void shouldEmailInputBeVisible() {
        Assert.assertTrue(logInPage.checkEmailInputIsVisible());
    }
}
