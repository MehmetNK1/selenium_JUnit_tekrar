package pfd_ders_notlari.Ders_04;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseImplicitly;

import java.util.Set;
import java.util.stream.Collectors;

public class C33_windowHandles extends TestBaseImplicitly {

    @After
    public  void after() {
        //driver.quit();
    }
    @Test
    public void test() {
        // ● Tests package’inda yeni bir class olusturun: WindowHandle2
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).getText().contains("Opening a new window"));

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
        String ilksayfa = driver.getWindowHandle(); // ILK SAYFA HANDLE

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[@href='/windows/new']")).click();
        Set<String> handles = driver.getWindowHandles();
        String ikinciSayfaHandleDegeri = handles.stream().filter(t -> !t.equals(ilksayfa)).collect(Collectors.toList()).get(0);
        driver.switchTo().window(ikinciSayfaHandleDegeri);

        //Set<String> windowHandleseti= driver.getWindowHandles();
        //System.out.println(windowHandleseti);
        //String ikinciSayfa=""; // IKINCI SAYFA HANDLE
        //for (String each: windowHandleseti
        //) {
        //    if (!each.equals(ilksayfa)){
        //        ikinciSayfa=each;
        //    }
        //}

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String expectedTitel = "New Window";
        Assert.assertEquals(driver.getTitle(),expectedTitel);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).getText().equals("New Window"));

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilksayfa);
        Assert.assertTrue(driver.getTitle().equals("The Internet"));

    }
}
