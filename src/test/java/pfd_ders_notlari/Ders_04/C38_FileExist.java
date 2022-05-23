package pfd_ders_notlari.Ders_04;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C38_FileExist {

    @Test
    public void test() {
        // icinde oldugum projenin dosya yolunu verir
        System.out.println(System.getProperty("user.dir")); //C:\Users\Test\IdeaProjects\selenium_tekrar
        System.out.println("----------------");
        // benim pc min bana ozel kismi
        System.out.println(System.getProperty("user.home")); //C:\Users\Test
        System.out.println("----------------");
        // bizim bildigimiz dosyanin varligini test ederiz
        String dosyaYolu = System.getProperty("user.home")+"\\Desktop\\test.txt";
        System.out.println(dosyaYolu); // C:\Users\Test\Desktop\test.txt
        System.out.println("----------------");
        // pc deki bir dosyanin varligini test etmek icin dinamik yol
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\test.txt";
        String masaustuDosyaYolu = farkliKisim+ortakKisim;
        //
        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));

    }
}
