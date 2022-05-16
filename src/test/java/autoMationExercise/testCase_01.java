package autoMationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class testCase_01 {
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() throws InterruptedException {

        driver.close();
    }
    @Test
    public void testCase_01() throws InterruptedException {
        //1. Tarayıcıyı başlatın
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        //3. Verify that home page is visible successfully
        WebElement anasayfa =driver.findElement(By.xpath("//a[text()=' Home']"));
        if (anasayfa.isDisplayed()){
            System.out.println("3-PASSED");
        }else{
            System.out.println("3-FAILLED");
        }

        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        //4. Click on 'Signup / Login' button

        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();

        //5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        //5. Verify 'New User Signup!' is visible
        WebElement yeniKullaniciKaydi = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        if (yeniKullaniciKaydi.isDisplayed()){
            System.out.println("5-PASSED");
        }else System.out.println("5-FAILLED");

        //6. Adı ve e-posta adresini girin
        //6. Enter name and email address

       // try {
       //
       // } catch (WebDriverException e) {
       //     e.printStackTrace();
       // }
//
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys("ter22222");
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("tere3333333333333333@gmail.com");

        //7. 'Kaydol' düğmesini tıklayın
        //7. Click 'Signup' button

        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement hesapBilgisi = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        if (hesapBilgisi.isDisplayed()){
            System.out.println("8-PASSED");
        }else System.out.println("8-FAILLED");

        //9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        //9. Fill details: Title, Name, Email, Password, Date of birth

        driver.findElement(By.xpath("//*[@class='radio-inline']")).click(); //title
        //ad
        //e-posta
        // kayit oluken girildi
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("123asd456"); //password
        driver.findElement(By.xpath("//*[@id='days']")).sendKeys("1");//tag
        driver.findElement(By.xpath("//*[@id='months']")).sendKeys("April");//monat
        driver.findElement(By.xpath("(//*[@class='form-control'])[6]")).sendKeys("1990");//jahr

        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        //10. Select checkbox 'Sign up for our newsletter!'

        driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();

        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        //11. Select checkbox 'Receive special offers from our partners!'

        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();

        //12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

        driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("mehmet");
        driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("ko");
        driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("goggle");
        driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("izmir sok.,35030,goggle");
        driver.findElement(By.xpath("//input[@data-qa='address2']")).sendKeys("---");
        driver.findElement(By.xpath("//*[@value='Canada']"));//land
        driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("Sachen");
        driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("Izmir");
        driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("35030");
        driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("53138794555");

        //13. 'Hesap Oluştur düğmesini' tıklayın
        //13. Click 'Create Account button'

        driver.findElement(By.xpath("//button[text()='Create Account']")).click();

        //14. 'HESAP OLUŞTURULDU!' görünür
        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement hesapDogrulamasi = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        if (hesapDogrulamasi.isDisplayed()){
            System.out.println("14- PASSED");
        }else System.out.println("14- FAILLED");

        //15. 'Devam' düğmesini tıklayın
        //15. Click 'Continue' button

        driver.findElement(By.xpath("//*[@class='pull-right']")).click();

        //16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        //16. Verify that 'Logged in as username' is visible

        System.out.println(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed() ? "16- PASSED" : "16- FAILLED");

        //17. 'Hesabı Sil' düğmesini tıklayın
        //17. Click 'Delete Account' button

        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();

        //18. 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

        System.out.println(driver.findElement(By.xpath("//*[@class='active']")).isDisplayed() ? "18- PASSED " : "18- FAILLED ");



    }
}
