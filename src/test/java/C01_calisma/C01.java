package C01_calisma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //driver.get("https://www.amazon.com");

        driver.get("https://demoqa.com/text-box");
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.click();
        fullName.sendKeys("mehmet");

        WebElement email = driver.findElement(new By.ByCssSelector(".mr-sm-2[id=\"userEmail\"]"));
        email.click();
        email.sendKeys("mehmet123@gmail.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.click();
        currentAddress.sendKeys("leipziger str 155");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.click();
        permanentAddress.sendKeys("bornova / 08058");

        WebElement submitButton = driver.findElement(new By.ByCssSelector("button.btn"));
        submitButton.click();



    }
}
