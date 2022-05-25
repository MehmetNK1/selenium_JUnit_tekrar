package pfd_ders_notlari.Ders_05;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C44_iframeHomeWork_A extends TestBase {


    @After
    public void after() {
        driver.quit();
    }
    @Test
    public void test() {
        //1.“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //2.“Our Products” butonuna basin
        WebElement iframe1 = driver.findElement(By.xpath("//*[@id='frame']"));
        driver.switchTo().frame(iframe1);
        WebElement ourProduct1 = driver.findElement(By.xpath("//*[@href='products.html']"));
        ourProduct1.click();

        //3.Cameras product”i tiklayin
        driver.findElement(By.xpath("(//*[@class='thumbnail'])[2]")).click();
        driver.switchTo().parentFrame();

        //4.Popup mesajini yazdirin
        WebElement iframe2 = driver.findElement(By.xpath("//*[@id='frame']"));
        driver.switchTo().frame(iframe2);
        WebElement test = driver.findElement(By.xpath("//*[@class='modal-body']"));
        System.out.println("4- : "+test.getText());

        //5.“close” butonuna basin
        driver.findElement(By.xpath("//*[text()='Close']")).click();
        driver.switchTo().parentFrame();

        //6."WebdriverUniversity.com IFrame )" linkini tiklayin
        driver.findElement(By.xpath("(//*[@class='navbar-brand'])[1]")).click();

        //7."http://webdriveruniversity.com/index.html" adresine gittigini test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("http://webdriveruniversity.com/index.html"));

    }
}
