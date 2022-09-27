package day06_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions3 {

    /*
     * https://www.youtube.com adresine gidin
     * Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
     * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
     * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
     * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
     * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
        WebElement cookies = driver.findElement(By.xpath("//*[text()='Tümünü kabul et']"));
        if (cookies.isDisplayed()) {
            cookies.click();
        }
    }

    @AfterClass
    public static void tearDown() {
        // driver.close();
    }


    @Test
    public void test1() {
        // * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitile = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.equals(expectedTitile));
    }

    @Test
    public void test2() {
        // * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logo = driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void test3() {
        //  * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searcBox = driver.findElement(By.xpath("//*[@name='search_query']"));
        Assert.assertTrue(searcBox.isEnabled());
    }

    @Test
    public void test4() {
        // * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String expectedTitile = "youtube";
        String actualTitle = driver.getTitle();
        Assert.assertNotEquals(actualTitle, expectedTitile);
    }


}
