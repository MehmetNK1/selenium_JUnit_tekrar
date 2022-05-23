package pfd_ders_notlari.Ders_04;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C35_Actions extends TestBase {
    @After
    public  void after() {
        driver.quit();
    }
    @Test
    public void test() {
        //Yeni bir class olusturalim: MouseActions2
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement tasinacak = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement konum = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        actions.dragAndDrop(tasinacak,konum).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String degisim = "Dropped!";
        Assert.assertEquals(degisim,driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());


    }
}
