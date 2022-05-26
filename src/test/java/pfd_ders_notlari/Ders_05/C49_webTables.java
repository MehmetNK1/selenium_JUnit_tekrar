package pfd_ders_notlari.Ders_05;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseClass;

public class C49_webTables extends TestBaseClass {
    @AfterClass
    public static void after() {
        //driver.quit();
    }
    @Test
    public void login() {
        //●Bir class oluşturun : D18_ WebTables
        //●login(login() metodun oluşturun ve oturum
        //●https://qa environment.concorthotel.com/ admin/HotelRoomAdmin adresine gidin
        // https://www.concorthotel.com/Account/Logon
        driver.get("https://www.concorthotel.com/Account/Logon");
            //○Username : manager   ○Password : Manager2!
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("manager");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("Manager2!");
        driver.findElement(By.xpath("//*[@value='Log in']")).click();
        //●table(table() metodu oluşturun
            //○Tüm table body’sinin boyutunu(s utun sayisi ) bulun. /tbody
            //○Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        //●printRows(printRows() metodu oluşturun //tr
            //○table body’sinde bulunan toplam satir(row) sayısını bulun.
            //○Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
            //○4.satirdaki(row) elementleri konsolda yazdırın.
        //●printCells(printCells() metodu oluşturun //td
            //○table body’sinde bulunan toplam hücre(cell) sayısını bulun.
            //○Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        //●printColumns(printColumns() metodu oluşturun
            //○table body’sinde bulunan toplam sutun(column) sayısını bulun.
            //○Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
            //○5.column daki elementleri konsolda yazdırın.

    }

}
