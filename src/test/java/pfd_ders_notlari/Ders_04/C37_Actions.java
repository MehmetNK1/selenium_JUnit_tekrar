package pfd_ders_notlari.Ders_04;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C37_Actions extends TestBase {
    @After
    public  void after() {
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        //1- Bir Class olusturalim KeyboardActions2
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        //4- videoyu izlemek icin Play tusuna basin
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']")));
        driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button']")).click();

        //5- videoyu calistirdiginizi test edin
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']")).isDisplayed());

    }
}
