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

public class C03_BasicAuthentication {

    /*
    1Bir class olusturun :BasicAuthentication
    2https://the-internet.herokuapp.com/basic_auth sayfasinagidin
    3asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    Html komutu :https://username:password@URL
    Username:admin
    password:admin
    4Basarili sekilde sayfaya girildiginidogrulayin
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown() {
        // driver.close();
    }


    @Test
    public void test1(){
        // //the-internet.herokuapp.com/basic_auth sayfasinagidin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        // 4Basarili sekilde sayfaya girildiginidogrulayin
        WebElement tebrikler = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(tebrikler.isDisplayed());
        System.out.println(tebrikler.getText());
    }


}
