package pfd_ders_notlari.Ders_04;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C39_FileDownload extends TestBase {
    @After
    public  void after() {
        //driver.quit();
    }
    @Test
    public void test(){
        //1. Tests packagenin altina bir class oluşturalim
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. dummy.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[@href='download/dummy.txt']")).click();

        //4. dosyanın başarıyla indirilip indirilmediğini test edelim
        // dosya downloads'a indirilecektir, bize downloads'un dosya yolu lazim
        String arananDosyaYolu = System.getProperty("user.home")+"\\Downloads\\dummy.txt";

        //5. geriye o dosya yolundaki dosyanin var oldugunu assert edelim
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));
    }
}
