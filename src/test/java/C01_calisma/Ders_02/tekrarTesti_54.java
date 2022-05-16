package C01_calisma.Ders_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class tekrarTesti_54 {
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
    public void tekrarTesti() {

        //1-amazona git
        driver.get("https://www.amazon.com/");

        //2-"city bike" ara
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("city bike"+ Keys.ENTER);

        //3-goruntulenen ilgili sonuclarin sayisini yazdir
        WebElement sonuclar = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonuclar.getText()+" - 3.adim");

        //4-"Shopping" e tikla
        //BOYLE BIR SEKME YOK

        //5-karsiniza cikan ilk resme tikla
        driver.findElement(By.xpath("//img[@class='s-image']")).click();

        //bitti





    }
}
