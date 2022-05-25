package pfd_ders_notlari.Ders_05;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C43_actionsClassHomeWork extends TestBase {

    @After
    public void after(){
        driver.quit();
    }
    @Test
    public void test() {
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"))).perform();

        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class='dropdown-content'])[1]")).click();

        //4. Popup mesajini yazdirin
        System.out.println("4- : "+driver.switchTo().alert().getText());

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun
        actions.clickAndHold(driver.findElement(By.xpath("(//*[@class='col-lg-12 text-center'])[3]"))).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement cikanYazi = driver.findElement(By.xpath("(//*[@class='col-lg-12 text-center'])[3]"));
        actions.clickAndHold(cikanYazi);
        System.out.println("7- : "+cikanYazi.getText());

        //8. "Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.xpath("//*[@id='double-click']"))).perform();


    }
}
