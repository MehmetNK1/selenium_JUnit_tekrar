package pfd_ders_notlari.Ders_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C22_BestBuyAssertions_95 {
    static WebDriver driver;
    @BeforeClass
    public static void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1- "https://www.bestbuy.com/" adresine git farkli test methodlari ile calis
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void after() {
        driver.close();
    }
    @Test
    public void urlTest() {
        //2- URL nin "https://www.bestbuy.com/" olduguna test et
        String expecredUrl ="https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        if (expecredUrl.contains(actualUrl)){
            System.out.println("2- PASSED");
        }else System.out.println("2- FAILLED");
    }
    @Test
    public void titleTest() {
        //3-titleTest => Sayfa başlığının “Rest” içer me diğini(contains) test edin
        String expectedTitel = "Rest";
        String actualTitel = driver.getTitle();
        if (expectedTitel.contains(actualTitel)) {
            System.out.println("3- PASSED");
        } else System.out.println("3- FAILLED");
    }
    @Test
    public void logoTest() {
        //4-logoTest => BestBuy logosunun görüntülendigini test edin
        System.out.println(driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"))
                .isDisplayed() ? "4- PASSED" : "4- FAILLED");
    }
    @Test
    public void FrancaisLinkTest() {
        //5-Francais LinkTest => Fransizca Linkin görüntülendiğini test edin
        System.out.println(driver.findElement(By.xpath("(//*[@lang='fr'])[1]"))
                .isDisplayed() ? "5- PASSED" : "5- FAILLED");
    }
}
