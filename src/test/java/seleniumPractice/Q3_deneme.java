package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3_deneme {
    /*
    ●Bir class olusturun: Alert s
    ●https://the internet.herokuapp.com/javascript_alerts adresine gidin.
    ●Bir metod olusturun: acceptAlert
    ○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    “You successfully clicked an alert” oldugunu test edin
    ●Bir metod olusturun: dismissAlert
    ○2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    “successfuly” icermedigini test edin
    ●Bir metod olusturun: sendKeysAlert
    ○3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajın da isminizin görüntülendiğini doğrulayın.
     */

    static WebDriver driver;
    @BeforeClass
    public static void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @AfterClass
    public static void after() {
        driver.close();
    }
    @Test
    public void Alert() {
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.

    }
    @Test
    public void acceptAlert() {
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //    “You successfully clicked an alert” oldugunu test edin
       // driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='result']"))
                .getText().contains("You successfully clicked an alert"));

    }
    @Test
    public void dismissAlert() {
        //Bir metod olusturun: dismissAlert
        //    ○2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //    “successfuly” icermedigini test edin


        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

        driver.switchTo().alert().dismiss();
        Assert.assertFalse(driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"))
                .getText().contains("successfuly"));
    }
    @Test
    public void sendKeysAlert() {
        //●Bir metod olusturun: sendKeysAlert
        //    ○3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //    tıklayın ve result mesajın da isminizin görüntülendiğini doğrulayın.


        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("mehmet");
        driver.switchTo().alert().accept();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='result']"))
                .getText().contains("mehmet"));

    }

}
