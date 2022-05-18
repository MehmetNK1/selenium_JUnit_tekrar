package pfd_ders_notlari.Ders_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C16_tekrarTesti_81 {
    WebDriver driver;
    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void after() {
        //driver.close();
    }
    @Test
    public void test() {
        //1- clas olustur

        //2- "httpS://www.google.com/" adresine git
        driver.get("httpS://www.google.com/");

        //3- "cookies" uayarisini kabul et
        driver.findElement(By.xpath("//*[text()='Kabul ediyorum']")).click();

        //4- sayfa basliginin "Google" icerdigini test et
        System.out.println(driver.getTitle().equals("Google") ? "4- PASSED" : "4- FAILLED");

        //5- "Nutella" arat
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Nutella"+ Keys.ENTER);

        //6- bulunan sonuc sayisini yazdir
        System.out.println("6- bulunan sonuc sayisi : "+driver.findElement(By.xpath("//*[@id='result-stats']")).getText());

        //7- sonuc sayisinin 10 milyondan fazla oldugunu test et //*[text()='Yaklaşık 238.000.000 sonuç bulundu']

        //if (driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).isDisplayed())
        //              System.out.println("The produtc is in the cart");
        //           else System.out.println("The produtc is not in cart FAILED");
        //       // WebElement cartEklendiMi = driver.findElement(By.className("shopping_cart_badge"));
        //       // Assert.assertTrue("basariyla ekledik",cartEklendiMi.isDisplayed());

        //8- kapat
    }
}
