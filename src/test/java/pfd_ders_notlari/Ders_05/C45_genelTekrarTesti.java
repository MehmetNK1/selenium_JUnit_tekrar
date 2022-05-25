package pfd_ders_notlari.Ders_05;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;

import java.util.List;

public class C45_genelTekrarTesti extends TestBaseClass {
    @AfterClass
    public static void after() {
        //driver.quit();
    }
    @Test
    public void test01() {
        //Test01
        //1 amazon gi din
        driver.get("https://www.amazon.com");

        //2 Arama kutusunun solundaki drop down menuyu handle edip listesini ekrana yazdırın
        WebElement aramaDropDown = driver.findElement(By.xpath("//*[@aria-describedby='searchDropdownDescription']"));
        Select select = new Select(aramaDropDown);
        List<WebElement> dropMenu = select.getOptions();
        for (WebElement each:dropMenu) {
            System.out.println(each.getText());
        }

        //3 drop down menude 40 eleman olduğunu doğrulayın
        int dropSayisi= dropMenu.size();
        if (dropSayisi==40){
            System.out.println("3- true");
        }else{
            System.out.println("3- false");
        }
    }
    @Test
    public void Test02() {
        //Test02
        //1 dropdown menuden elektronik bölümü seç in


        //2 arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırı n
        //3 sonuc sayisi bildiren yazinin iphone icerdigini test edin
        //4 ikinci ürüne relative locater kullanarak tıklay in
        //5 ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim

    }





    //Test03
    //1 yeni bir sekme açarak amazon a nasayfaya gid in
    //2 dropdown’dan bebek bölümüne secin
    //3 bebek puset aratıp bulundan sonuç sayısını yazdırın
    //4 sonuç yazsının puset içerdiğini te st edin
    //5 üçüncü ürüne relative locater kullanarak tıklay in
    //6 title ve fiyat bilgilerini assign edelim ve ürünü sepete ekley in

    //Test 4
    //1 sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
}
