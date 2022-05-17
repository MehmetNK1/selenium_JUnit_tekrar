package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Q2_deneme {

    /* amazon'a gidip

       Java aratalim


     */
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
        driver.get("https://www.amazon.com");

        //dropdown'dan books secenegini secip
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select= new Select(dropdown);
        select.selectByVisibleText("Books");
        //select.selectByValue("search-alias=stripbooks-intl-ship");
        //select.selectByIndex(5);


        //Java aratalim
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Java"+ Keys.ENTER);

        //ve arama sonuclarinin Java icerdigini test edelim


        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"))
                .getText().contains("Java"));







    }
}
