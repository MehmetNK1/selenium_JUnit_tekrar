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

public class testCase_03 {
    /*
        Test Case 3: Login User with incorrect email and password
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Signup / Login' button
        5. Verify 'Login to your account' is visible
        6. Enter incorrect email address and password
        7. Click 'login' button
        8. Verify error 'Your email or password is incorrect!' is visible


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
        //Test Durumu 3: Kullanıcıyı yanlış e-posta ve parola ile oturum açın
        //         1. Tarayıcıyı başlatın
        //         2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //         3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.xpath("//a[text()=' Home']"))
                .isDisplayed() ? "3- passed" : "3- failled");

        //         4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //         5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.xpath("(//h2)[1]")).isDisplayed() ? "5- passed" : "5- failled");
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[1]")).getText().contains("Login to your account"));

        //         6. Yanlış e-posta adresi ve şifre girin
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("asdasdad@gmail.com");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("asd13");

        //         7. 'Giriş' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        //         8. 'E-postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür
        System.out.println(driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"))
                .isDisplayed() ? "8- passed" : "8- failled");
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"))
                .getText().contains("Your email or password is incorrect!"));

    }

}
