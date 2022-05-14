package C01_calisma.Ders_01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_navigate {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //amazona git
        driver.get("https://www.amazon.com");

        // sayfanin konumu ve boyutlarini yaz
        System.out.println(driver.manage().window().getSize()+" sayfanin boyutu");
        System.out.println(driver.manage().window().getPosition()+" sayfanin konumu");

        Thread.sleep(2000);

        //sayfanin konum ve boyutunu degistir
        driver.manage().window().setSize(new Dimension(900,600));
        driver.manage().window().setPosition(new Point(10,10));

        System.out.println(driver.manage().window().getSize()+" yeni boyutu");
        System.out.println(driver.manage().window().getPosition()+" yeni konumu");

        //istenilen konum ve boyuta geldigini tes et


        //sayfayi kapat
        Thread.sleep(2000);
        driver.close();

    }
}
