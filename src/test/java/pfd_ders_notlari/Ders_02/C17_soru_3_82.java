package pfd_ders_notlari.Ders_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C17_soru_3_82 {
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
        //1- "https://www.saucedemo.com" adresine git
        driver.get("https://www.saucedemo.com");

       ////2- username kutusuna "standard_user" yaz
       driver.findElement(By.id("user-name")).sendKeys("standard_user");

       ////3- password kutusuna "secret_sauce" yaz
       driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //2- Username kutusuna "standard_user" yazdirin
        //driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //3- Password kutusuna "secret_sauce" yazdirin
        //driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]")).sendKeys("secret_sauce");

        //4- login tusuna bas
        driver.findElement(By.id("login-button")).click();

        //5- ilk urunun ismini kaydet ve urunun sayfasina git
        driver.findElement(By.xpath("(//img[@class='inventory_item_img'])[1]")).click();

        //6- "Add to Card" butonuna bas
        driver.findElement(By.xpath("//*[text()='Add to cart']")).click();

        //7- alisveris sepetine tiklayin
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        //8- secilen urunun sepete eklendigini kontrol et
        System.out.println(driver.findElement(By.xpath("//button[@id='checkout']"))
                .isDisplayed() ? "8- PASSED" : "8- FAILLED");

        //9- kapat




    }
}
