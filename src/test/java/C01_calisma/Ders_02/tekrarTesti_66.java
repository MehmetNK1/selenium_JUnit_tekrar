package C01_calisma.Ders_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class tekrarTesti_66 {
    WebDriver driver;
    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void after() {
        driver.close();
    }
    @Test
    public void test() {
        //2- "https://wwwamazon.com/" adresine git
        driver.get("https://wwwamazon.com/");

        //3- tam sayfa yapildi

        //4- "Reflesh" yap
        driver.navigate().refresh();

        //5- basligi "Spend less" icerdugini test et
        String expectedTitel = driver.getTitle();
        String actualTitel = "Spend less";
        if (actualTitel.equals(expectedTitel)){
            System.out.println("5- PASSED");
        }else System.out.println("5- FAILLED");

        //6- "Gift Card" sekmesine bas
        driver.findElement(By.xpath("(//*[@data-csa-c-type='link'])[5]")).click();

        //7- "Birtday" butonu na bas
        driver.findElement(By.xpath("//*[@aria-label='Birthday gift cards']")).click();

        //8- "Best Seller" bolumden ilk urune tikla
        driver.findElement(By.xpath("//*[@class='a-section a-spacing-mini a-spacing-top-micro acs-product-block__product-image']")).click();

        //9- Gift card details den 25$ sec
        driver.findElement(By.xpath("//*[@id='a-autoid-28']")).isSelected();

        //10- urun ucretinin 25$ oldugunu test et
        WebElement ucret = driver.findElement(By.xpath("//*[@id='a-autoid-28']"));
        if (ucret.isDisplayed()){
            System.out.println("10- PASSED");
        }else System.out.println("10- FAILLED");

        // bitti
    }
}
