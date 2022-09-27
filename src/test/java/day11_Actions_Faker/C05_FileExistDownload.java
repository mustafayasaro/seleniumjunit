package day11_Actions_Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utulities.TestCaseBeforeClassAfterClass;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExistDownload extends TestCaseBeforeClassAfterClass {
    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='test.txt']")).click();

        //Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu ="C:\\Users\\Hp\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //Indirildigini konsolda gosterin
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
    }
}
