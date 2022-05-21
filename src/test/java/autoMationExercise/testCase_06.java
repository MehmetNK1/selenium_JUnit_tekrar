package autoMationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class testCase_06 {
    /*
        Test Case 6: Contact Us Form
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Contact Us' button
        5. Verify 'GET IN TOUCH' is visible
        6. Enter name, email, subject and message
        7. Upload file
        8. Click 'Submit' button
        9. Click OK button
        10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        11. Click 'Home' button and verify that landed to home page successfully
        Test Durumu 6: Bize Ulaşın Formu

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
        //1. Tarayıcıyı başlatın
        //        2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //        3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.xpath("//*[@href='/']"))
                .isDisplayed() ? "3- passed" : "3- failled");

        //        4. 'Bize Ulaşın' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/contact_us']")).click();

        //        5. 'GET IN TOUCH'un görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.xpath("//*[text()='Get In Touch']"))
                .isDisplayed() ? "5- passed" : "5- failled");
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Get In Touch']")).getText().contains("GET IN TOUCH"));

        //        6. Adı, e-posta adresini, konuyu ve mesajı girin
        WebElement name = driver.findElement(By.xpath("//*[@data-qa='name']"));
        Actions actions = new Actions(driver);
        actions.click(name)
                .sendKeys("ter22222")
                .sendKeys(Keys.TAB)
                .sendKeys("tere3333333333333333@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("deneme")
                .sendKeys(Keys.TAB)
                .sendKeys("boyle test mi olur").perform();
        //driver.findElement(By.xpath("//*[@data-qa='name']")).sendKeys("ter22222");

        //        7. Dosya yükle
        //driver.findElement(By.xpath("//*[@type='file']")).click();


        //        8. 'Gönder' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@data-qa='submit-button']")).click();

        //        9. Tamam düğmesine tıklayın
        driver.switchTo().alert().accept();

        //        10. Başarı mesajını doğrulayın 'Success! Bilgileriniz başarıyla gönderildi.' görünür
        System.out.println(driver.findElement(By.xpath("//*[@class='status alert alert-success']"))
                .isDisplayed() ? "10- passed" : "10- failled");
        Assert.assertEquals("ayni degil",driver.findElement(By.xpath("(//*[text()='Success! Your details have been submitted successfully.'])[1]"))
                .getText().contains("Success! Your details have been submitted successfully."));

        //        11. 'Ana Sayfa' düğmesini tıklayın ve ana sayfaya başarıyla indiğini doğrulayın
        driver.findElement(By.xpath("//*[@href='/']")).click();




    }

}
