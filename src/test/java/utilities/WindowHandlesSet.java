package utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowHandlesSet {
    WebDriver driver;
    public void handle(){
        String ilksayfa = driver.getWindowHandle();
        Set<String> windowHandlesSeti = driver.getWindowHandles();
        String ikincisayfa = "";
        for (String each : windowHandlesSeti) {
            if (!each.equals(ilksayfa)) {
                ikincisayfa = each;
            }
        }
        driver.switchTo().window(ikincisayfa);


    }
}