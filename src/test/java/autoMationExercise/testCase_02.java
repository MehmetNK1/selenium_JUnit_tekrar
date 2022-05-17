package autoMationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class testCase_02 {
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
        //Test Case 2: Login User with correct email and password
        //Test Durumu 2: Kullanıcıyı doğru e-posta ve parola ile oturum açın
        //1. Launch browser
        //1. Tarayıcıyı başlatın
        //2. Navigate to url 'http://automationexercise.com'
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement anasayfa =driver.findElement(By.xpath("//a[text()=' Home']"));
        if (anasayfa.isDisplayed()){
            System.out.println("3- PASSED");
        }else{
            System.out.println("3- FAILLED");
        }

        //4. Click on 'Signup / Login' button
        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/login']")).click();


        //5. Verify 'Login to your account' is visible
        //5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        WebElement hesapDogrulamasi = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        if (hesapDogrulamasi.isDisplayed()){
            System.out.println("5- PASSED");
        }else System.out.println("5- FAILLED");


        //6. Enter correct email address and password
        //6. Doğru e-posta adresini ve sifreyi girin
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("tere3333333333333333@gmail.com");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("123asd456");


        //7. Click 'login' button
        //7. 'Giriş' düğmesini tıklayın
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();


        //8. Verify that 'Logged in as username' is visible
        //8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.xpath("//*[text()=' Logged in as ']"))
                .isDisplayed() ? "8- PASSED" : "8- FAILLED");

        //9. Click 'Delete Account' button
        //9. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //10. Verify that 'ACCOUNT DELETED!' is visible
        //10. 'HESAP SİLİNDİ!' görünür
        System.out.println(driver.findElement(By.xpath("//a[@href='/delete_account']"))
                .isDisplayed() ? "10- PASSED" : "10- FAILLED");

    }
}
