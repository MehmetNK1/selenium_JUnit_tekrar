package pfd_ders_notlari.Ders_05;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C48_webTables extends TestBase {
    @After
    public void after() {
        //driver.quit();
    }
    @Test
    public void test() {
        //●Bir class oluşturun : C02_ WebTables
        //●login(login() metodun oluşturun ve oturum
        //●https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("(//*[@class='nav-link'])[7]")).click();
            //○Username : manager
            //○Password : Manager 1
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.xpath("//*[@placeholder='Username']")))
                .sendKeys("manger").sendKeys(Keys.TAB)
                .sendKeys("Manager1!").sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        //●table(table() metodu oluşturun
            //○Tüm table body’sinin boyutunu(s utun sayisi ) bulun. /tbody

            //○Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        //●printRows(printRows() metodu oluşturun //tr
            //○table body’sinde bulunan toplam satir(row) sayısını bulun.
            //○Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
            //○4.satirdaki(row) elementleri konsolda yazdırın.

    }

}
