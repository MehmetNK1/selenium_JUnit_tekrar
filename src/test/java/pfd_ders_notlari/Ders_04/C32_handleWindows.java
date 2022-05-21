package pfd_ders_notlari.Ders_04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C32_handleWindows {
    static WebDriver driver;
    @BeforeClass
    public static void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void after() {
        //driver.close();
    }
    @Test
    public void test() {
        // 1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String ilksayfa = driver.getWindowHandle();
        // 2- url'in  amazon icerdigini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

        // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");

        // 4- title'in Best Buy icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));

        // 5- ilk sayfaya donup sayfada java aratalim
        driver.get(ilksayfa);
        //driver.findElement(By.xpath(""))
        // 6- arama sonuclarinin Java icerdigini test edelim
        // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        // 8- logonun gorundugunu test edelim




    }
}
