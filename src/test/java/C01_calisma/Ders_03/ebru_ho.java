package C01_calisma.Ders_03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ebru_ho {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazona git
        driver.get("http://www.amazon.com");
        Thread.sleep(1000);

        //tam sayfa yap
        driver.manage().window().maximize();
        Thread.sleep(2000);

        //sayfayi reflesh yap
        driver.navigate().refresh();
        Thread.sleep(2000);


        //basligi "Spend less" olarak test et
        String expectedTitel = driver.getTitle();
        String actualTitel = "Spend less";
        if (actualTitel.equals(expectedTitel)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILLED "+expectedTitel+" = icermiyor");
        }

        //"Gift Card" sekmesine bas
        driver.findElement(By.xpath("//a[@data-csa-c-type='link'][4]")).click();
        Thread.sleep(2000);

        //"Birtday" sekmesine bas
        driver.findElement(By.xpath("//img[@alt='Birthday gift cards']")).click();
        Thread.sleep(2000);

        //

        /*

         */

        //kapat

    }
}
