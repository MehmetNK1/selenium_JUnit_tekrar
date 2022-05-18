package pfd_ders_notlari.Ders_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C29_IframeTest_135 {
    //●Bir class olusturun: IframeTest 02

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
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        driver.findElement(By.xpath("(//*[@class='fc-button-label'])[1]")).click();

        //2) sayfadaki iframe sayısını bulunuz.


        //3)ilk iframe'deki (Youtube) play butonuna tıklayınız.
        //4)ilk iframe'den çıkıp ana sayfaya dönünüz
        //5)ikinci iframe'deki (Jmeter Made Easy)
        // linke (https://www.guru99.com/live selenium project.html) tıklayınız
    }
}
