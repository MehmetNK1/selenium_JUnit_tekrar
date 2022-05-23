package pfd_ders_notlari.Ders_04;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C40_FileUpload extends TestBase {
    @After
    public  void after() {
        driver.quit();
    }
    @Test
    public void test(){
        //Tests packagenin altina bir class oluşturun : C05_UploadFile
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.
        // 1.adim choose file butonunu locate edelim
        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='file-upload']"));

        // 2.adim yuklenecek dosyanin dosya yolunu olusturalim
        String yuklenecekDosya = System.getProperty("user.home")+"\\Desktop\\test.txt";

        //   biz masaustundeki text.txt dosyasini yukleyelim
        // 3. adim sendKeys ile dosya yolunu, secme butonuna yollayalim
        dosyaSec.sendKeys(yuklenecekDosya);

        //Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@class='button']")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());


    }
}
