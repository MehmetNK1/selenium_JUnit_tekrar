package pfd_ders_notlari.Ders_05;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C51_webTables extends TestBase {
    @After
    public  void after() {
        //driver.quit();
    }
    @Test
    public void test() {
        //Bir Class olusturun D19_WebtablesHomework
        //1. https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //2. Headers da bulunan department isimlerini yazdirin
        System.out.print("2- : "+driver.findElement(By.xpath("//*[@class='rt-thead -header']")).getText());

        //3. sutunun basligini yazdirin
        //4. Tablodaki tum datalari yazdirin
        //5. Tabloda kac cell (data) oldugunu yazdirin
        //6. Tablodaki satir sayisini yazdirin
        //7. Tablodaki sutun sayisini yazdirin
        //8. Tablodaki 3.kolonu yazdirin
        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

    }

}
