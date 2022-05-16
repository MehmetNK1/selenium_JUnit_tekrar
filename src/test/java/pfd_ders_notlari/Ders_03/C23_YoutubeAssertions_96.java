package pfd_ders_notlari.Ders_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C23_YoutubeAssertions_96 {
    WebDriver driver;
    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- "https://www.youtube.com" adresine git
        driver.get("https://www.youtube.com");
    }
    @After
    public void after() {
        driver.close();
    }
    @Test
    public void titleTest() {
        //2- sayfa basliginin "YouTube" oldugunu test et
        Assert.assertTrue(driver.getTitle().contains("YouTube"));
    }
    @Test
    public void imageTest() {
        //3- YouTube resminnin goruntulendigini .isDisplayed ile test
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='style-scope ytd-logo'])[1]")).isDisplayed());

        //4- Search Box in erisilebilir oldugunu .isEnabled ile test
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='search']")).isEnabled());
    }
    @Test
    public void wrongTitle() {
        //5- basligin "youtube" olmadigini dogrula
        Assert.assertFalse(driver.getTitle().contains("youtube"));
    }
}
