package day11_Actions_Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utulities.TestCaseBeforeClassAfterClass;

import java.util.ArrayList;
import java.util.List;

public class Odev2 extends TestCaseBeforeClassAfterClass {
    // https://html.com/tags/iframe/ sayfasina gidelim
    // 3- video’yu gorecek kadar asagi inin
    // videoyu izlemek icin Play tusuna basin
    // videoyu calistirdiginizi test edin


    @Test
    public void test01() {
        // https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        // 3- video’yu gorecek kadar asagi inin
        action.sendKeys(Keys.PAGE_DOWN).
                moveToElement(driver.findElement(By.xpath("(//*[@class='render'])[1]"))).
                perform();
        // videoyu izlemek icin Play tusuna basin
        List<WebElement> iframeList = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframeList.get(0)); // //iframe
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();
        // videoyu calistirdiginizi test edin
        WebElement duraklatButonu = driver.findElement(By.xpath("//*[@title='Duraklat (k)']"));
        Assert.assertTrue(duraklatButonu.isDisplayed());
    }
}
