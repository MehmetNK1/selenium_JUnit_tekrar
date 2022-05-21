package autoMationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class testCase_07 {
    /*
    Test Case 7: Verify Test Cases Page
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Test Cases' button
    5. Verify user is navigated to test cases page successfully


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
        //driver.close();
    }
    @Test
    public void test() {
        //Test Vakası 7: Test Vakaları Sayfasının Doğrulanması
        //    1. Tarayıcıyı başlatın
        //    2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //    3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.xpath("//*[@href='/']"))
                .isDisplayed() ? "3- passed" : "3- failled");

        //    4. 'Test Vakaları' düğmesine tıklayın
        driver.findElement(By.xpath("(//*[@type='button'])[1]")).click();

        //    5. Kullanıcının test senaryoları sayfasına başarıyla yönlendirildiğini doğrulayın
        System.out.println(driver.findElement(By.xpath("//*[text()='Test Cases']"))
                .isDisplayed() ? "5-passed" : "5- failled");


    }
}
