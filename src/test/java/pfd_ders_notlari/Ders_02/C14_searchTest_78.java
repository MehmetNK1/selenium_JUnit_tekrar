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

public class C14_searchTest_78 {
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
        driver.close();
    }
    @Test
    public void test() {
        //1- "https://www.amazon.com/" sayfasina git
         driver.get("https://www.amazon.com/");

        //2- arama kutusunu locate et
        System.out.println(driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"))
                .isDisplayed() ? "2- PASSED" : "2- FAILLED");

        //3- "Samsung headphones" ile arama yap
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"))
                .sendKeys("Samsung headphones"+ Keys.ENTER);

        //4- bulunan sonuc sayisini yazdir
        System.out.println("4- sonuc sayisi : "+driver.findElement(By.xpath("//*[text()='1-16 of 221 results for']")).getText());

        //5-ilk urunu tikla
        driver.findElement(By.xpath("(//*[@class='rush-component'])[6]")).click();

        //6-sayfadaki tum baskliklari yazdir
        System.out.println(driver.getTitle());

    }

}
