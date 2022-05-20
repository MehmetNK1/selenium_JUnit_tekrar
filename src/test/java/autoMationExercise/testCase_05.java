package autoMationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class testCase_05 {
    /*
    Test Case 5: Register User with existing email
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and already registered email address
    7. Click 'Signup' button
    8. Verify error 'Email Address already exist!' is visible


     */
    static WebDriver driver;
    @BeforeClass
    public static void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void after() {
        driver.close();
    }
    @Test
    public void test() {
        //Test Durumu 5: Kullanıcıyı mevcut e-posta ile kaydedin
        //    1. Tarayıcıyı başlatın
        //    2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //    3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.xpath("//*[@href='/']"))
                .isDisplayed() ? "3- passed" : "3- failled");

        //    4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //    5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        System.out.println(driver.findElement(By.xpath("//*[text()='New User Signup!']"))
                .isDisplayed() ? "5- passed" : "5- failled");

        //    6. Adı ve kayıtlı e-posta adresini girin
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("ter22222");
        driver.findElement(By.xpath("(//*[@type='email'])[2]")).sendKeys("tere3333333333333333@gmail.com");

        //    7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();

        //    8. 'E-posta Adresi zaten var!' hatasını doğrulayın. görünür
        System.out.println(driver.findElement(By.xpath("//*[text()='Email Address already exist!']"))
                .isDisplayed() ? "8- passed" : "8- failled");

    }


}
