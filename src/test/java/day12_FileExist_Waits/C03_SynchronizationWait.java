package day12_FileExist_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utulities.TestCaseBeforeClassAfterClass;

import java.time.Duration;

public class C03_SynchronizationWait extends TestCaseBeforeClassAfterClass {
    // 1. Bir class olusturun : WaitTest
// 2. Iki tane metod olusturun : implicitWait() , explicitWait()
//    Iki metod icin de asagidaki adimlari test edin.
// 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
// 4. Remove butonuna basin.
// 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
// 6. Add buttonuna basin
// 7. It's back mesajinin gorundugunu test edin


    //implicitly wait testten once calsitirilir ve calistirilan testin tamamina etki eder
    //explicitly wait ise once obje olarak olusturulur sonra
    // sadece kullanildigi yerde ve belirlenen sarta gore calisir class yada test in tamamina uygulanmaz
    //İmplicitly ile her elementi Max 15 sn bekletiyoruz ama bir yerde 30 saniye beklemesi gerekiyorsa o zaman eksplicitly kullanıyoruz

    @Test
    public void implicitlytest01() throws InterruptedException {

        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        // 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's gone!\"]")).isDisplayed());
        // 6. Add buttonuna basin
        driver.findElement(By.xpath("(//*[@type='button'])[1]")).click();
        // 7. It's back mesajinin gorundugunu test edin
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());
    }
    @Test
    public void explicitlytest02() {
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        // 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement itsGone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        // 6. Add buttonuna basin
        driver.findElement(By.xpath("(//*[@type='button'])[1]")).click();
        // 7. It's back mesajinin gorundugunu test edin
        WebElement itsBack = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='message']")));


    }


}
