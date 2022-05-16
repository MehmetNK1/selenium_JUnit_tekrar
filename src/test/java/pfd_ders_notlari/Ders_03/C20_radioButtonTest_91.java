package pfd_ders_notlari.Ders_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C20_radioButtonTest_91 {
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
        //1- "https://www.facebook.com" adresine git
        driver.get("https://www.facebook.com");

        //2- cookies kabul et
        driver.findElement(By.xpath("(//*[@type='submit'])[3]")).click();

        //3- "Creat an Account" buttonuna bas
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

        //4- "radio buttons elementlerini locate et
        WebElement kadin = driver.findElement(By.xpath("(//*[@class='_5k_2 _5dba'])[1]"));
        WebElement erkek = driver.findElement(By.xpath("(//*[@class='_5k_2 _5dba'])[2]"));
        WebElement ozel = driver.findElement(By.xpath("(//*[@class='_5k_2 _5dba'])[3]"));

        //5- cinsiyet secme islemi yap
        if (!erkek.isSelected()){
            erkek.click();
        }

        //6- kapat


    }
}
