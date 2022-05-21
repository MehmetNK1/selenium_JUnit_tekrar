package pfd_ders_notlari.Ders_04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C31_handleWindows  {

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

        // 1- amazon ana sayfaya gidin
        String ilksayfa = driver.getWindowHandle();
        driver.get("https://www.amazon.com/");

        // 2- nutella icin arama yaptirin
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Nutella"+ Keys.ENTER);
        // 3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
        //driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();
        //WebElement urunresmi = driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Nutella"+ Keys.ENTER);

        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        // 4- yeni tab'da acilan urunun title'ini yazdirin
        System.out.println(driver.findElement(By.xpath("//*[@id='productTitle']")).getText());

        // ilk sayfaya gecip url'i yazdiralim
        System.out.println(driver.switchTo().window(ilksayfa).getCurrentUrl());


    }

}
