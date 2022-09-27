package day12_FileExist_Waits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utulities.TestCaseBeforeClassAfterClass;

public class C01_Actions extends TestCaseBeforeClassAfterClass {
    @Test
    public void test01() {
        //Automationexercises.com sitesine gidelim
        driver.get("https://www.automationexercise.com");
        //Product bölümüne girelim
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();
        //ilk ürüne tıklayalım
        action.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.cssSelector("a[data-product-id=\"1\"]")).click();
    }
}
