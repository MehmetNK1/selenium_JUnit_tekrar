package C01_calisma.Ders_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_get {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");
        String baslik = driver.getTitle();
        String arananbaslik ="Amazon";
        if(baslik.contains(arananbaslik)){
            System.out.println("DOGRU");
        }else{
            System.out.println("YANLIS "+baslik+" olmasi gerekiyor");
        }
        String url = driver.getCurrentUrl();
        String arananUrl= "https://www.amazon.com";
        if (url.contains(arananUrl)){
            System.out.println("DOGRU");
        }else{
            System.out.println("YANLIS "+url+" olmasi gerekiyor");
        }






        driver.close();
    }
}
