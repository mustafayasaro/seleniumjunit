package day11_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utulities.TestCaseBeforeClassAfterClass;

public class Odev extends TestCaseBeforeClassAfterClass {
    //Yeni Class olusturun ActionsClassHomeWork
    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin  2- Hover over Me First" kutusunun ustune gelin
    //Link 1" e tiklayin
    //Popup mesajini yazdirin
    //Popup'i tamam diyerek kapatin
    //“Click and hold" kutusuna basili tutun
    //7-“Click and hold" kutusunda cikan yaziyi yazdirin
    //8- “Double click me" butonunu cift tiklayin


    @Test
    public void test01() {
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin  2- Hover over Me First" kutusunun ustune gelin
        driver.get("http://webdriveruniversity.com/Actions");
        //Link 1" e tiklayin
        WebElement link1 = driver.findElement(By.xpath("//*[text()='Hover Over Me Second!']"));
        action.moveToElement(link1).perform();
        driver.findElement(By.xpath("(//*[text()='Link 1'])[2]")).click();
        //Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //“Click and hold" kutusuna basili tutun
        action.sendKeys(Keys.PAGE_DOWN).perform();
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.xpath("//*[@id='click-box']")).getText());
        //8- “Double click me" butonunu cift tiklayin
        action.sendKeys(Keys.PAGE_UP).perform();
        WebElement clickMe = driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
        action.doubleClick(clickMe).perform();


    }
}
