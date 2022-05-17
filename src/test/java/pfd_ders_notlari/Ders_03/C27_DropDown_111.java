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
import java.util.List;

public class C27_DropDown_111 {
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
        //driver.close();
    }
    @Test
    public void test() {
        //1- "https://the-internet.herokuapp.com/dropdown" adresine git
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //2- Index kullanarak secenek 1 i sec ve yazdir
        WebElement ddm = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(ddm);
        select.selectByIndex(1);
        System.out.println("2- "+select.getFirstSelectedOption().getText());

        //3- Value kullanrak secebek 1 yi sec yazdir
        select.selectByValue("2");
        System.out.println("3- "+select.getFirstSelectedOption().getText());

        //4- Visible Text (gorunen metin) kullanarak secenerek 1 i sec ve yaz
        select.selectByVisibleText("Option 1");
        System.out.println("4- "+select.getFirstSelectedOption().getText());


        //5- Tum dropdownlari yazdir
        List<WebElement>tumdegerler = select.getOptions();
        for (WebElement each:tumdegerler) {
            System.out.println("5- "+each.getText());
        }


        //6- Dropdown un boyutu bul 4 oge varda "true yoksa "false" yaz
        int dropdownBoyutu = tumdegerler.size();
        if (dropdownBoyutu == 4 ){
            System.out.println("6- true");
        }else System.out.println("6- false");


    }
}
