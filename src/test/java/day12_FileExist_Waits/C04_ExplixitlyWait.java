package day12_FileExist_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utulities.TestCaseBeforeClassAfterClass;

import java.time.Duration;

public class C04_ExplixitlyWait extends TestCaseBeforeClassAfterClass {

    //1. Bir class olusturun : EnableTest
    //2. Bir metod olusturun : isEnabled()
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Textbox’in etkin olmadigini(enabled) dogrulayın
    //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    //7. Textbox’in etkin oldugunu(enabled) dogrulayın
    @Test
    public void test01() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        Assert.assertFalse(driver.findElement(By.xpath("//*[@type='text']")).isEnabled());
        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

        driver.findElement(By.xpath("//*[text()='Enable']")).click();

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement itsEnabled = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id='message']")));
        //7. Textbox’in etkin oldugunu(enabled) dogrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@type='text']")).isEnabled());
    }
}
