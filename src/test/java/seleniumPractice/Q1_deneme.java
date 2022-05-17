package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1_deneme {
     /*
    amazon ana sayfaya gidin
    3 farkli test method'u olusturarak asagidaki gorevleri yapin
    1- Url'in amazon icerdigini test edin
    2- title'in facebook icermedigini test edin
    3- sol ust kosede amazon logosunun gorundugunu test edin
     */


   static WebDriver driver;
    @BeforeClass
    public static void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }
    @AfterClass
    public static void after() {
        driver.quit();
    }
    @Test
    public void test1() {
        //1- Url'in amazon icerdigini test edin
        String expecredUrl = driver.getCurrentUrl();
        String actualUrl = "amazon";
        Assert.assertTrue(expecredUrl.contains(actualUrl));

    }
    @Test
    public void test2() {
        //2- title'in facebook icermedigini test edin
        String actualTitel = driver.getTitle();
        String expectedTitel = "facebook";
        Assert.assertFalse(actualTitel.contains(expectedTitel));

    }
    @Test
    public void test3() {
        //3- sol ust kosede amazon logosunun gorundugunu test edin
        System.out.println(driver.findElement(By.xpath("//*[@id='nav-logo-sprites']"))
                .isDisplayed() ? "passed" : "failled");

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='nav-logo-sprites']")).isDisplayed() );


    }
 }
