package pfd_ders_notlari.Ders_05;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseClass;

import java.time.Duration;

public class C42_ExplicitlyWait extends TestBaseClass {
    @AfterClass
    public static void after() {
        driver.quit();
    }
    @Test
    public void test() {
        //1. Bir class olusturun : EnableTest
        //2. Bir metod olusturun : isEnabled()
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@type='text']")).isDisplayed());

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("(//*[@autocomplete='off'])[2]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until((ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@type='text']")))));
                                                            // 4. madde de locate edileni ekledik

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@type='text']")).isEnabled());
                         // 4. madde de locate edileni ekledik


    }
}
