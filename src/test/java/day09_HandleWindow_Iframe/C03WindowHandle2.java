package day09_HandleWindow_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03WindowHandle2 {
    /*
    Yeni bir class olusturun: WindowHandle
Amazon anasayfa adresine gidin.
Sayfa’nin window handle degerini String bir degiskene atayin
Sayfa title’nin “Amazon” icerdigini test edin
Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
Sayfa title’nin “Walmart” icerdigini test edin
Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
Collapse
     */



    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
        // driver.close();
    }

    @Test
    public void test1(){
        //Yeni bir class olusturun: WindowHandle
        //Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

        //Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindowHandle = driver.getWindowHandle();

        //Sayfa title’nin “Amazon” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.techproeducation.com");

        //Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        Assert.assertFalse(driver.getTitle().contains("TECHPROEDUCATION"));


        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.walmart.com");
        String walmartWindowHandle = driver.getWindowHandle();

        //Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));

        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindowHandle);
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
    }





}
