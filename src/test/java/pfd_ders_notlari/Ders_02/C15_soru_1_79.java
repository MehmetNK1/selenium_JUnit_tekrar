package pfd_ders_notlari.Ders_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C15_soru_1_79 {
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
        //1- "http://zero.webappsecurity.com" sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2- SingIn butonuna bas
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();

        //3- Login alanina "username" yaz
        driver.findElement(By.xpath("//input[@name='user_login']")).sendKeys("username");

        //4- Password alanina "password" yaz
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");

        //5- SingIn butonuna bas
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        driver.navigate().back();

        //6a- Online Banking e tikla
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();

        //6b- Pay Pills sayfasina git
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();

        //7- "amonut " kismina yatirmak istedigin miktari yaz
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("100");

        //8- tarih kismina "2020-09-10" yaz
        driver.findElement(By.xpath("//*[@name='date']")).sendKeys("2020-09-10");

        //9- Pay butinuna bas
        driver.findElement(By.xpath("//*[@class='pull-right']")).click();

        //10- "The payment was successfully submitted." mesajini kontrol et
        System.out.println(driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"))
                .isDisplayed() ? "10- PASSED" : "10- FAILLED");

    }

}
