package C01_calisma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_navigate {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //sayfayi buyultme
      //  driver.manage().window().maximize();
        // 1 sn bekleme islemi soru disidir
        // amazona git
        driver.get("https://www.amazon.com/");
        Thread.sleep(1000);
        //sayfanin konumu ve boyutlari yaz
        System.out.println(driver.manage().window().getSize()+" sayfanin boyutu");
        System.out.println(driver.manage().window().getPosition()+" sayfanin konumu");
        //sayfayi simgeye getir 3sn bekle sonra max yap
        driver.manage().window().minimize();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        //sayfanin konumu ve boyutunu max da yaz
        System.out.println(driver.manage().window().getSize()+" sayfanin yeni boyut durumu");
        System.out.println(driver.manage().window().getPosition()+" sayfanin yeni konum durumu");
        Thread.sleep(1000);
        //full yap konumu ve boyutu yaz
        driver.manage().window().fullscreen();
        System.out.println(driver.manage().window().getSize()+" full boyutu");
        System.out.println(driver.manage().window().getPosition()+" full durumu");
        Thread.sleep(1000);
        // sayfayi kapat
        driver.close();
    }
}
