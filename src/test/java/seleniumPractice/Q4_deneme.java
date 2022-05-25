package seleniumPractice;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Q4_deneme extends TestBase {
    @After
    public  void after() {
        //driver.quit();
    }
    @Test
    public void test() {
        // url'ye gidin: https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        //-->Görev1 Çoklu Seçimde Açılır Menüyü Bul
        driver.findElement(By.xpath("//*[@id='justAnInputBox']"));
        //-->Görev2 Sayfadaki tüm Açılır Öğeleri Bul
        //-->Task3 çıktısı DropDown Elements' numarası
        //-->Görev4 açılır öğeleri seç ve açılır liste öğelerinin adını 6. seçeneğe kadar yazdır

    }
    // go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
    //-->Task1 Find Dropdown on Multi Selection
    //-->Task2 Find  all Dropdown Elements on page
    //-->Task3 printout DropDown Elements' number
    //-->Task4 choose dropdown elements and printout dropdown elements' name  until choise 6




}
