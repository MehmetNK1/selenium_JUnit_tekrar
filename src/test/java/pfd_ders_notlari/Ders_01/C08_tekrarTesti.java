package pfd_ders_notlari.Ders_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_tekrarTesti {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- youtube GIT ,
        driver.get("https://www.youtube.com");
        // sayfa basligi "youtube" diye test et , DEGILSE (ACTUAL title) olani yazdir
        System.out.println(driver.getTitle());
        String actualTitel = driver.getTitle();
        String expectedTitel = "youtube";
        if (expectedTitel.equals(actualTitel)){
            System.out.println("PAASED");
        }else {
            System.out.println("FAILLED -- "+actualTitel+" =icermiyor");
        }
        //3- sayfa URLsini "youtube" iceriyor mu diye (contains ile) test et
        // , DEGILSE dogru olani yazdir
        System.out.println(driver.getCurrentUrl());
        String actualUrl = driver.getCurrentUrl();
        String expecredUrl = "youtube";
        if (expecredUrl.contains(actualUrl)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILLED -- "+actualUrl+" = icermiyor");
        }

        Thread.sleep(2000);
        //4- amazona git
        driver.navigate().to("https://www.amazon.com");

        Thread.sleep(2000);
        //5- youtube geri don
        driver.navigate().back();

        Thread.sleep(2000);
        //6- youtube yenile
        driver.navigate().refresh();

        Thread.sleep(2000);
        //7- amazona geri don
        driver.navigate().forward();

        Thread.sleep(2000);
        //8- sayfayi tam yap
        driver.manage().window().maximize();

        Thread.sleep(2000);
        //9-title "Amazon" oldugunu CONTAINS ile test ve dogru olani yaz
        System.out.println(driver.getTitle());
        String etkinTitles = driver.getTitle();
        String denemeTitle = "Amazon";
        if (denemeTitle.contains(etkinTitles)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED  -- "+etkinTitles+" =icermiyor");
        }

        //11- kapat
        driver.close();
    }
}
