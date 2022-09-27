package day11_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestCaseBeforeClassAfterClass;

public class C02_Actions extends TestCaseBeforeClassAfterClass {


    // Kisaca test methodu olusturma ==> alt + insert
    @Test
    public void test01() {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        WebElement cookies = driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']"));
        if (cookies.isDisplayed()){
            cookies.click();
        }
        // 2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isim = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        isim.sendKeys("Mustafa");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).
                sendKeys("Ozzengin").
                sendKeys(Keys.TAB).
                sendKeys("myozzengin@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("myozzengin@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("123456").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("1").
                sendKeys(Keys.TAB).
                sendKeys("Tem").
                sendKeys(Keys.TAB).
                sendKeys("1982").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        // 4- Kaydol tusuna basalim


    }
}
