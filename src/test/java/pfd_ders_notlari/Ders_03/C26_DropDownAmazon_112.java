package pfd_ders_notlari.Ders_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C26_DropDownAmazon_112 {
    WebDriver driver;
    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }
    @After
    public void after() {
        driver.close();
    }
    @Test
    public void test1() {
        //1- arama kutusunun yandaki kategori menusunun 45 oldugunu test et
        WebElement ddm = driver.findElement(By.xpath("//*[@name='url']"));
        Select select = new Select(ddm);

        System.out.println(select.getFirstSelectedOption().getText());// yazdirma islemi

        List<WebElement> menukutusu = select.getOptions();
        int actualOptionSayisi = menukutusu.size();
        int expecredOptionSayisi = 45;
        Assert.assertEquals(expecredOptionSayisi,actualOptionSayisi);

    }
    @Test
    public void test2() {
        //1- kategori menusunden "Books" u sec
        WebElement Doldurma = driver.findElement(By.xpath("//*[@name='url']"));
        Select select = new Select(Doldurma);
        select.selectByVisibleText("Books");

        //2- "java" aramasi yap
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);

        //3- bulunan sonuc saysini yazdir
        System.out.println("bulununa sonuc : "+driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")));

        //4- sonucun "Java" icerdigini test et
        System.out.println(driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"))
                .isDisplayed() ? "4- PASSED" : "4- FAILLED");

    }
}
