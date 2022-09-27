package day08_Allerts;

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

public class C02_Allerts2 {
    /*
    Bir web sitesine girm=digimizde karsima=z=iza bir uyari mesaji
    ya da bir butona tikladigimizda bir uyari (allert) cikabilir
    Eger bu uyariya incele (sag tik-inspect) yapabiliyorsak bu tur allert'lere
    HTML Allert denir ve istedigimiz locate'i alabiliriz ama
    gelen uyari kutusuna incele(inspect) edemiyorsak bu tur allertlere
    JS Allert denir. JS Allert'lere mudahele edebilmek icin
    -- tamam ya da OK icin = driver.switchTo.alert.accept()  kullanilir
    -- iptal icin == driver.switchTo.alert.dismiss()  kullanilir
    -- Alert icindeki mesaji almak icin =  driver.switchTo.alert.getText()  kullanilir
    -- Alert bizden bir metin istiyorsa ==> driver.switchTo.alert.sendKeys("Metin")  kullanilir
     */

    /*
    Bir class olusturun: Alerts
    https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    Bir metod olusturun: acceptAlert
    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    “You successfully clicked an alert” oldugunu test edin.
    Bir metod olusturun: dismissAlert
    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    “successfuly” icermedigini test edin.
    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
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
      //  driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
//        1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
//    “You successfully clicked an alert” oldugunu test edin.

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        WebElement mesaj = driver.findElement(By.xpath("//*[@id='result']"));

        Assert.assertTrue(mesaj.isDisplayed());
        //  Assert.assertTrue(driver.getPageSource().contains("You successfully clicked an alert"));

    }


    @Test
    public void test2() throws InterruptedException {
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //    “successfuly” icermedigini test edin.

        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        Thread.sleep(3000);
        // Allert mesajini yazdirin
        driver.switchTo().alert().getText();

        driver.switchTo().alert().dismiss();
        WebElement mesaj2 = driver.findElement(By.xpath("//*[@id='result']"));
        String expectedMesaj = "successfully";
        String actualMesaj = mesaj2.getText();
        Assert.assertNotEquals(actualMesaj,expectedMesaj);
    }

    @Test
    public void test3() throws InterruptedException {
        // 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Mustafa");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        WebElement isim = driver.findElement(By.xpath("//*[@id='result']"));
        Assert.assertTrue(isim.isDisplayed());
    }

}
