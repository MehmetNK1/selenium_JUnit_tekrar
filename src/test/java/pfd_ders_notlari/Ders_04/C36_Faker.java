package pfd_ders_notlari.Ders_04;

import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.K;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C36_Faker extends TestBase {
    @After
    public  void after() {
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        // facebook gorevini fake isimlerle yapalim
        // facebook anasayfaya gidip
        driver.get("https://www.facebook.com");

        driver.findElement(By.xpath("(//*[@value='1'])[3]")).click();

        // yeni kayit olustur butonuna basin

        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

        // isim kutusunu locate edip,
        WebElement isim = driver.findElement(By.xpath("(//*[@type='text'])[2]"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        String fakeMail = faker.internet().emailAddress();

        actions.click(isim)
                .sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(fakeMail).sendKeys(Keys.TAB)
                .sendKeys(fakeMail).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("1").sendKeys(Keys.TAB)
                .sendKeys("Oca").sendKeys(Keys.TAB)
                .sendKeys("2000").sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                //.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        // geriye kalan alanlari TAB ile dolasarak formu doldurun
    }
}
