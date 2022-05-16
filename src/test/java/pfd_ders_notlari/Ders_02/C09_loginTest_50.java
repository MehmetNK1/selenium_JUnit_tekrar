package pfd_ders_notlari.Ders_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C09_loginTest_50 {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
    @Test
    public void test01 () throws InterruptedException {
        //"http://a.testaddressbook.com/sign_in" a git
        driver.get("http://a.testaddressbook.com/sign_in");
        Thread.sleep(3000);

        //Sing in e bas
        driver.findElement(By.xpath("//input[@data-disable-with='Sign in']")).click();
        Thread.sleep(3000);

        //e-mail,password,sing in elementlerini locate et
        WebElement email = driver.findElement(By.xpath("//input[@id='session_email']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='session_password']"));
        WebElement singIn = driver.findElement(By.xpath("//input[@data-disable-with='Sign in']"));

        //kullanici adi , sifre GIR ve sing in buttonuna BAS
        //kullanici adi : testtechproed@gmail.com
        //password : Test1234!
        email.sendKeys("testtechproed@gmail.com");
        password.sendKeys("Test1234!");
        singIn.click();

     // //Expected user "testtechproed@gmail.com" oldugunu dogrularin
     // System.out.println(email.getText());
     // String expectedUser = "testtechproed@gmail.com";
     // if (expectedUser.equals(email.getText())){
     //     System.out.println("PASSED");
     // }else System.out.println("FAILLED");

        //Assert.assertFalse(email.getText().contains(expectedUser));

        //"Address ve Sing Out" goruntulendigini(displayed) et
        WebElement address = driver.findElement(By.xpath("//a[@data-test='addresses']"));
        if (address.isDisplayed()){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
        WebElement singOut = driver.findElement(By.xpath("//*[@data-method='delete']"));
        if (address.isDisplayed()){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

        //sayfada kac tane link oldugunu bulun
        List<WebElement>sayfalinkleri = driver.findElements(By.tagName("a"));
        System.out.println(sayfalinkleri.size()+" : link sayiysi");

        //kapat
        driver.close();
    }

}
