package day11_Actions_Faker;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExist {
    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir")); // D:\com.Batch81JuUnit
        //suanki icinde bulundugum yolu gosterir
        System.out.println(System.getProperty("user.home")); // C:\Users\Hp
        // gecerli kullanicin ana dizikimini verir


        String dosyaYolu = "C:\\Users\\Hp\\Desktop\\text.txt.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
        Bir web sitesinden indirdigimiz veeya windows icersinde olusturdugumuz
        dosyanin localde oldugunu test edebilmem icin oo dosyanin
        uzerine  SHIFT(hold) + RIGHT CLICK  ile dosyanin yolunu
        String bir variable'a atadiktan sonra
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        ile dogrulariz.
         */


    }
}
