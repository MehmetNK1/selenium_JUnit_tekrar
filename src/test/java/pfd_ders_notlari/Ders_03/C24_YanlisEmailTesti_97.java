package pfd_ders_notlari.Ders_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C24_YanlisEmailTesti_97 {
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
        //1- "http://automationpractice.com/index.php" sayfasina git
        driver.get("http://automationpractice.com/index.php");

        //2- Sing in butonuna bas
        driver.findElement(By.xpath("//a[@class='login']")).click();

        //3- Email kutusuna @ isareti olmayan bir mail yazip entera bastigimizda
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("asd123gmail.com"+ Keys.ENTER);

        //   "Invalid email address" uyarisi ciktigini test et
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Invalid email address.']")).isDisplayed());

    }
}
