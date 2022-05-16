package C01_calisma.Ders_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class addRemoveElememt_60 {
    WebDriver driver;
    @Before
    public void before () {
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
    public void test () {
        //1- "https://the-internet.herokuapp.com/add_remove_elements/" adresine git
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2- "Add Element" butonuna bas
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();

        //3- "Delete" butonunun gorunur oldugunu test et
        WebElement delete = driver.findElement(By.xpath("//*[text()='Delete']"));
        if (delete.isDisplayed()){
            System.out.println("3- PASSED");
        }else System.out.println("3- FAILLED");

        //4- "Delete" tusuna bas
        delete.click();

        //5- "Add/Remove Elements" yazisinin gorunur oldugunu test et
        WebElement elemnts = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));
        if (elemnts.isDisplayed()){
            System.out.println("5- PASSED");
        }else System.out.println("5- FAILLED");

        //bitti
    }
}
