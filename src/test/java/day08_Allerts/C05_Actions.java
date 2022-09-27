package day08_Allerts;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestCaseBeforeClassAfterClass;

public class C05_Actions extends TestCaseBeforeClassAfterClass {
    @Test
    public void test01() throws InterruptedException {
        //https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));

        Actions action = new Actions(driver);
        // Extends yaptigimiz TestBase class'da Action class'ini olusturdugumuz icin direkt objeyi burada kullandik
        Thread.sleep(2000);
        action.dragAndDrop(dragMe,dropHere).perform();

        //“Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertEquals("Dropped!", driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());
    }
}
