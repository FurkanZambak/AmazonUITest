import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public abstract class BaseTest {
    public static WebDriver driver;
    public static HomePage homePage;
    public static ProductList productList;
    public static ListPage listPage;
    public static ProductDetailPage productDetailPage;
    public static LogInPage logInPage;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        productList = new ProductList(driver);
        productDetailPage = new ProductDetailPage(driver);
        logInPage = new LogInPage(driver);
        listPage = new ListPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
