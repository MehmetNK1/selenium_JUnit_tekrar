package pfd_ders_notlari.Ders_05;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseClass;

public class C41_ExplicitlyWait extends TestBaseClass {
    @AfterClass
    public static void afterClass() {
        //driver.quit();
    }
    @Test
    public void implicitWaitTesti() {
        // 1. Bir class olusturun : WaitTest
        //2. Iki tane test olusturun : implicitWait() , explicitWait()
        //   Iki test icin de asagidaki adimlari test edin.
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("(//*[@type='button'])[1]")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("(//*[@autocomplete='off'])[1]")).click();

        //7. It’s back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());

    }
    @Test
    public void explicitWaitTesti() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("(//*[@type='button'])[1]")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());

        //6. Add buttonuna basin

        //7. It’s back mesajinin gorundugunu test edin



    }
}
