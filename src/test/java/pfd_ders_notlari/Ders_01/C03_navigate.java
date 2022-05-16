package pfd_ders_notlari.Ders_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_navigate {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //sayfayi buyult
        driver.manage().window().maximize();
        //youtube git
        driver.navigate().to("https://www.youtube.com/");
        Thread.sleep(1000);
        //amazona git
        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(1000);
        //geri yotube don
        driver.navigate().back();
        Thread.sleep(1000);
        //tekrar ileri amazona git
        driver.navigate().forward();
        Thread.sleep(1000);
        //amazonda sayfayi yenile
        driver.navigate().refresh();
        Thread.sleep(1000);
        //sayfayi kapat
        driver.close();
    }
}
