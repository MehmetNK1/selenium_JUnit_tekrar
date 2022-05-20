package autoMationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class testCase_04 {

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
        //driver.close();
    }
    @Test
    public void test() {
        /*
        Test Case 4: Logout User
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Signup / Login' button
        5. Verify 'Login to your account' is visible
        6. Enter correct email address and password
        7. Click 'login' button
        8. Verify that 'Logged in as username' is visible
        9. Click 'Logout' button
        10. Verify that user is navigated to login page

     */
        //Test Durumu 4: Kullanıcı Oturumunu Kapat
        //        1. Tarayıcıyı başlatın
        //        2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //        3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.xpath("//a[text()=' Home']"))
                .isDisplayed() ? "3- passed" : "3- failled");

        //        4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //        5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.xpath("(//h2)[1]")).isDisplayed() ? "5- passed" : "5- failled");
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[1]")).getText().contains("Login to your account"));

        //        6. Doğru e-posta adresini ve şifreyi girin
        driver.findElement(By.xpath("(//*[@type='email'])[1]")).sendKeys("tere3333333333333333@gmail.com");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("123asd456");

        //        7. 'Giriş' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();

        //        8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.xpath("//*[text()=' Logged in as ']"))
                .isDisplayed() ? "8- passed" : "8- failled");
        Assert.assertFalse(driver.findElement(By.xpath("//*[text()=' Logged in as ']"))
                .getText().contains("Logged in as username"));

        //        9. 'Çıkış' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()=' Logout']")).click();

        //        10. Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın
        //driver.findElement(By.xpath("//*[text()='New User Signup!']")).



    }
}
