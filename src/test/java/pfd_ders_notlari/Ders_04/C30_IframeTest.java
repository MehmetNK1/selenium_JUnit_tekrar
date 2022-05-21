package pfd_ders_notlari.Ders_04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C30_IframeTest {
    //●Bir class olusturun: IframeTest
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
        driver.close();
    }
    @Test
    public void test() {
        //●https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //●Bir metod olusturun: iframeTest
        //○“An IFrame containing….” textini n erisilebilir oldugunu test edin ve konsolda yazdirin.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isEnabled());
        System.out.println(driver.findElement(By.xpath("//h3")).getText());

        //○Text Box’a “Merhaba Dunya!” yazin.
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='mce_0_ifr']")));

        driver.findElement(By.xpath("//*[@class='mce-content-body ']")).clear();
        driver.findElement(By.xpath("//*[@class='mce-content-body ']")).sendKeys("merhaba dunya");

        driver.switchTo().defaultContent();

        //○TextBox’in altinda bulunan “Elemental Selenium” linkini textini n gorunur oldugunu dogrulayin ve konsolda yazdirin.

        Assert.assertTrue(driver.findElement(By.xpath("//*[@href='http://elementalselenium.com/']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//*[@href='http://elementalselenium.com/']")).getText());


    }


}
