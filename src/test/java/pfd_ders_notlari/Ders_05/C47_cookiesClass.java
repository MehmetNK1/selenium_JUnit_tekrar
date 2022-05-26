package pfd_ders_notlari.Ders_05;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C47_cookiesClass extends TestBase {
    @After
    public  void after() {
        driver.quit();
    }
    @Test
    public void test () {
        //Yeni bir class olusturun : cookiesAutomation
        //1 Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2 tum cookie’leri listeleyin
        Set<Cookie> cookieSet = driver.manage().getCookies();
        System.out.println(cookieSet);
        int sayac = 1;
        for (Cookie cookie : cookieSet){
            System.out.println(sayac + " cookie : " + cookie);
            System.out.println("name : " + cookie.getName());
            System.out.println("value : " + cookie.getValue());
            sayac++;
        }

        //3 Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayisi = cookieSet.size();
        Assert.assertTrue(cookieSayisi>5);

        //4 ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie each : cookieSet){
            if (each.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",each.getValue());
            }
        }

        //5 ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie yeniCookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(yeniCookie);
        sayac = 1;
        cookieSet = driver.manage().getCookies();
        for (Cookie each : cookieSet){
            System.out.println(sayac + " cookie : " + each);
            sayac++;
        }

        //6 eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(cookieSet.contains(yeniCookie));

        //7 ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookieSet.contains("skin"));

        //8 tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSet = driver.manage().getCookies();
        Assert.assertTrue(cookieSet.isEmpty());

    }

}
