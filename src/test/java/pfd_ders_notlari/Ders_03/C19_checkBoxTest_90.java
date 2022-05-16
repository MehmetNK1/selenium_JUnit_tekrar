package pfd_ders_notlari.Ders_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C19_checkBoxTest_90 {
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
        //1- Clas olustur

        //2- "https://the-internet.herokuapp.com/checkboxes" sayfasina git
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //3- "Checkbox1 ve Checkbox2" elementlerini locate et
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));


        //4- Checkbox1 secili degilse tikla
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }

        //5- Checkbox2 secili degilse tikla
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }

        //6- kapat


    }
}
