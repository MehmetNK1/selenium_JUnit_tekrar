package pfd_ders_notlari.Ders_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_homework {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //facebook a git
        driver.get("http://www.facebook.com");

        //2- title "facebook" oldgunu kontrol et degilse dogru basligi yazdir
        System.out.println(driver.getTitle());
        String actualTitel = driver.getTitle();
        String expectedTitel = "facebook";
        if (expectedTitel.contains(actualTitel)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILLED --- "+actualTitel+" = icermiyor");
        }
        //3- URL nin facebook kelimesini icerdigini test et , icermiyorsa URL yi yazdir
        String actualUrl = driver.getCurrentUrl();
        String exceptionUrl = "facebook";
        if (exceptionUrl.equals(actualUrl)){
            System.out.println("PAASED");
        }else {
            System.out.println("FAILLED "+actualUrl+" =icermiyor");
        }

        Thread.sleep(2000);

        //4- "https://www.walmart.com/" sayfasina git
        driver.navigate().to("https://www.walmart.com/");

        //5- title "Walmart.com" oldugunu kontrol et
        String actualTitel1 = driver.getTitle();
        String expectedTitel1 = "Walmart.com";
        if (expectedTitel1.contains(actualTitel1)){
            System.out.println("PAASED");
        }else {
            System.out.println("FAILLED "+actualTitel1+" = icermiyor");
        }

        Thread.sleep(2000);

        //6- facebook a geri don
        driver.navigate().back();

        Thread.sleep(2000);

        //7- facebook sayfasini yenile
        driver.navigate().refresh();

        Thread.sleep(2000);

        //8- sayfayi max yap
        driver.manage().window().maximize();

        Thread.sleep(2000);

        //kapat
        driver.close();

    }
}
