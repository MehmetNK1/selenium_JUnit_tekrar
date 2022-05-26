package pfd_ders_notlari.Ders_04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        driver.quit();

    }
    @Test
    public void test() {
        // 1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String ilksayfa = driver.getWindowHandle(); // AMAZON HANDLE

        // 2- url'in  amazon icerdigini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

        // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim

        driver.switchTo().newWindow(WindowType.WINDOW); // YENI PENCERE
        driver.get("https://www.bestbuy.com");
        String ikincisayfa = driver.getWindowHandle(); // BEST BUY HANDLE

        // 4- title'in Best Buy icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));

        // 5- ilk sayfaya donup sayfada java aratalim
        driver.switchTo().window(ilksayfa); // ILK SAYFAYA DON
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("java"+ Keys.ENTER);

        // 6- arama sonuclarinin Java icerdigini test edelim
        String actualArama = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String arananSonuc = "java";
        Assert.assertTrue(actualArama.contains(arananSonuc));

        //Assert.assertTrue(driver.findElement(By.linkText("//*[@class='a-section a-spacing-small a-spacing-top-small']"))
        //        .getText().contains("java"));

        // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        driver.switchTo().window(ikincisayfa); // IKINCI SAYFAYA DON

        // 8- logonun gorundugunu test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='logo'])[1]")).isDisplayed());






    }
}
