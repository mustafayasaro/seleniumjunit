package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestCaseBeforeClassAfterClass;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestCaseBeforeClassAfterClass {

    @Test
    public void test01(){
        //Yeni bir class olusturalim: MouseActions1
        //https://the-internet.herokuapp.com/context_menu sitesine gidelim  3- Cizili alan uzerinde sag click yapalim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //Cizili alan uzerine sag click yapin
        //Alert’te cikan yazinin “You selected a context menu” oldugunu
        //test edelim.
        WebElement ciziliAlan = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(ciziliAlan).perform();
        Assert.assertEquals("You selected a context menu", driver.switchTo().alert().getText());
        //Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        driver.navigate().refresh(); // acik

        //Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        List<String> windowlist = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowlist.get(1));
        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Assert.assertEquals("Elemental Selenium", (driver.findElement(By.xpath("//h1")).getText()));

    }
}
