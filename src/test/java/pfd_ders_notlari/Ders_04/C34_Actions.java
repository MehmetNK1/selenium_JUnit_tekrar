package pfd_ders_notlari.Ders_04;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C34_Actions extends TestBase {
 @After
    public void after() {
     driver.quit();
 }
 @Test
    public void test() {
     // 1- Yeni bir class olusturalim: MouseActions1
     //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
     driver.get("https://the-internet.herokuapp.com/context_menu");

     //3- Cizili alan uzerinde sag click yapalim

     Actions action = new Actions(driver);
     action.contextClick(driver.findElement(By.xpath("//*[@id='hot-spot']"))).perform();

     //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
     String expeectedYazi = "You selected a context menu";
     Assert.assertEquals(driver.switchTo().alert().getText(),expeectedYazi);

     //5- Tamam diyerek alert’i kapatalim
     driver.switchTo().alert().accept();

     //6- Elemental Selenium linkine tiklayalim
     String ilksayfa = driver.getWindowHandle();
     driver.findElement(By.xpath("//*[@target='_blank']")).click();
     Set<String>handleSet = driver.getWindowHandles();
     String ikincisayfa = "";
     for (String handle : handleSet){
      if (!handle.equals(handleSet)){
       ikincisayfa=handle;
      }
     }

     //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
  driver.switchTo().window(ikincisayfa);
     String expeectedYaziIki = "Elemental Selenium";
     Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(),expeectedYaziIki);


 }
}
