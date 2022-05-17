package pfd_ders_notlari.Ders_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C28_HandleDropdown_113 {
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
        //1- "http://zero.webappsecurity.com/" adresine git
        driver.get("http://zero.webappsecurity.com/");

        //2- "sing in" butonuna bas
        driver.findElement(By.xpath("//*[@type='button']")).click();

        //3- Login kutusuna "username" yaz
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");

        //4- Password kutusuna "password." yaz
        driver.findElement(By.xpath("//*[@name='user_password']")).sendKeys("password");

        //5- Sing in butonuna bas
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.navigate().back();

        //6- "pay bills" sayfasina git
        driver.findElement(By.xpath("//*[text()='Online Banking']")).click();
        driver.findElement(By.xpath("(//*[@id='pay_bills_link'])[1]")).click();

        //7- "Purchase Foreign Currency" tusuna bas
        driver.findElement(By.xpath("(//*[@class='ui-state-default ui-corner-top'])[2]")).click();

        //8- "Currency" drop down menusunden Eurozone yi sec
        WebElement currency = driver.findElement(By.xpath("//*[@name='currency']"));
        Select select = new Select(currency);
        select.selectByVisibleText("Eurozone (euro)");

        //9- amonut kutusuna sayi gir
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("100");

        //10- "US Dollars" in secilmedigini test et
        WebElement dollars = driver.findElement(By.xpath("(//*[@type='radio'])[1]"));
        if (dollars.isSelected()){
            dollars.click();
            System.out.println("10- FAILLED");
        }else System.out.println("10- PASSED");


        //11- Selected currency butonunu sec
        WebElement selected = driver.findElement(By.xpath("(//*[@type='radio'])[2]"));
        if (!selected.isSelected()){
            selected.click();
        }


        //12- "Calculate Costs" butonuna bas sonra "purchase" butonuna bas
        driver.findElement(By.xpath("//*[@id='pc_calculate_costs']")).click();
        driver.findElement(By.xpath("//*[@value='Purchase']")).click();


       ////13- "Foreign currency cash was successfully purchased" yazisini kontrol et
       System.out.println(driver.findElement(By.xpath("(//*[@id='alert_content'])[1]"))
              .isDisplayed() ? "13- PASSED" : "13- FAILLED");

    }
}
