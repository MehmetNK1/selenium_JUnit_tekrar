package C01_calisma.Ders_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_navigate {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazona git
        driver.get("https://www.amazon.com");

        // sayfanin konum ve boyutlarini yazdir
        System.out.println(driver.manage().window().getSize()+" boyutu");
        System.out.println(driver.manage().window().getPosition()+" konumu");

        // sayfayi simge durumuna getir 3sn beklet sonra max yap
        driver.manage().window().minimize();
        Thread.sleep(3000);
        driver.manage().window().maximize();


        //sayfayi max durumunda yazdir
        System.out.println(driver.manage().window().getSize()+" max boyutu");
        System.out.println(driver.manage().window().getPosition()+" max konumu");

        Thread.sleep(3000);

        // full yap konum ve boyutu yazdir
        driver.manage().window().fullscreen();
        System.out.println(driver.manage().window().getSize()+" full boyutu");
        System.out.println(driver.manage().window().getPosition()+" full konumu");

        //kapat
        Thread.sleep(2000);
        driver.close();



    }
}
