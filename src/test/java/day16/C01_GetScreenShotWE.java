package day16;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utulities.TestCaseBeforeClassAfterClass;

import java.io.File;
import java.io.IOException;

public class C01_GetScreenShotWE extends TestCaseBeforeClassAfterClass {
    @Test
    public void test01() throws IOException {
        // Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        // Nutella kelimesini aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nuttela"+ Keys.ENTER);
        // Arama sonucunun resmini alalim
        WebElement aramaSoncu = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        File nutellaAramaSonucu = aramaSoncu.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(nutellaAramaSonucu, new File("target/ekranGoruntusuWE/WESS.jpeg"));

        /*
        Eger sadece WebElement'in ekran goruntusunu alacaksak
        TakesScreenShot class'ini kullanmamaiza gerek yok
        Locate ettigimiz WebElementi direkt gecici bir
        File Clas'indan olusturdugumuz bir variable'a attik
        FileUtils ile Kopyalayip yolunu(Path) belirtiriz
         */


    }
}
