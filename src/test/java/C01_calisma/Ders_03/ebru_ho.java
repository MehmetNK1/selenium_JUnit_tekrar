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

        //2- amazona git
        driver.get("http://www.amazon.com");
        Thread.sleep(1000);

        //3-tam sayfa yap
        driver.manage().window().maximize();
        Thread.sleep(2000);

        //4-sayfayi reflesh yap
        driver.navigate().refresh();
        Thread.sleep(2000);

        //5-basligi "Spend less" olarak test et
        String expectedTitel = driver.getTitle();
        String actualTitel = "Spend less";
        if (actualTitel.equals(expectedTitel)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILLED "+expectedTitel+" = icermiyor");
        }

        //6-"Gift Card" sekmesine bas
        driver.findElement(By.xpath("//a[@data-csa-c-type='link'][4]")).click();
        Thread.sleep(2000);

        //7-"Birtday" sekmesine bas
        driver.findElement(By.xpath("//img[@alt='Birthday gift cards']")).click();
        Thread.sleep(2000);

        //8- "Best Seller" bolumden ilk urune tikla
        driver.findElement(By.xpath("//img[@alt='Amazon.com eGift Card']")).click();

        //9- Gift card Details den 25$ sec
        driver.findElement(By.xpath("(//button[@id='gc-mini-picker-amount-1'])[1]")).click();

        //10- urun ucretinin 25$ oldugunu test et

        WebElement ucret = driver.findElement(By.xpath("//*[@id='a-autoid-28']"));
        if (ucret.isSelected()){
            System.out.println("10- PASSED");
        }else System.out.println("10- FAILLED");




        /*

         */

        //kapat

    }
}
