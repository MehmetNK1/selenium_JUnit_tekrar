package pfd_ders_notlari.Ders_05;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;
import java.util.stream.Collectors;

public class C46_windowHandleHomeWork extends TestBase {
    @After
    public  void after() {
        driver.quit();
    }
    @Test
    public void test() {
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String anasayfaUrl = driver.getCurrentUrl(); // anasayfa URL

        //2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //3."Login Portal" a tiklayin
        String anasayfa = driver.getWindowHandle();  // anasayfa handle
        driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();

        //4.Diger window'a gecin
        Set<String>tumpencereler =driver.getWindowHandles();
        String login = tumpencereler.stream().filter(t->!t.equals(anasayfa)).collect(Collectors.toList()).get(0);
        driver.switchTo().window(login);

        //5."username" ve "password" kutularina deger yazdirin
        //Faker faker = new Faker();
        //WebElement user = driver.findElement(By.xpath("//*[@placeholder='Username']"));
        //actions.
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("esra");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("123");

        //6."login" butonuna basin
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
        //driver.switchTo().alert().accept();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expeectedYazi = "validation failed";
        String actualYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(expeectedYazi, actualYazi);

        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        //9.Ilk sayfaya geri donun
        driver.switchTo().window(anasayfa);

        //10.Ilk sayfaya donuldugunu test edin
        String expecredUrl = driver.getCurrentUrl();
        Assert.assertEquals(expecredUrl,anasayfaUrl);

    }


}
