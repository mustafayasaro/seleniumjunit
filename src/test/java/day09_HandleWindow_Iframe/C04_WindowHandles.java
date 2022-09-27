package day09_HandleWindow_Iframe;

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
import java.util.ArrayList;
import java.util.List;

public class C04_WindowHandles {
    /*
    Tests package’inda yeni bir class olusturun: WindowHandle2
https://the-internet.herokuapp.com/windows adresine gidin.
Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
Click Here butonuna basın.
Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
Sayfadaki textin “New Window” olduğunu doğrulayın.
Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
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
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text = driver.findElement(By.xpath("//*[text()='Opening a new window']"));
        Assert.assertTrue(text.getText().equals("Opening a new window"));

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("The Internet"));

        //Click Here butonuna basın.
        WebElement clickButonu = driver.findElement(By.xpath("(//*[@target='_blank'])[1]"));
        clickButonu.click();
        //Acilan yeni pencereye gectik
        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        System.out.println("Window handle degerleri = " + windowList);
        driver.switchTo().window(windowList.get(1));
        /*
        NOT: String'lerden oluşan bir list oluşturup getWindowHandles() method'u ile
        açık bulunan tüm sayfaların / pencerelerin WindowHandle değerlerini o list'e atıyoruz.
        Daha sonra driver.switchTo().window() method'unun içine oluşturduğumuz list'ten
        hangi web sayfasını istiyorsak onun indeksini yazarak sayfalar arasında geçiş yapabiliyoruz.
        Yapı şu şekilde: driver.switchTo().window(listAdı.get(window'un indeks numarası))
        Örneğimizde windowList adındaki list'imizden 1. elementi getirdik.
        0 ilk sayfanın WindowHandle değerini, 1 ise ikinci sayfanın WindowHandle değerini verir.
        */

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String title2 = driver.getTitle();

        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement newWindow = driver.findElement(By.xpath("//  h3"));
        Assert.assertTrue(newWindow.isDisplayed());

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowList.get(0));
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }





}
