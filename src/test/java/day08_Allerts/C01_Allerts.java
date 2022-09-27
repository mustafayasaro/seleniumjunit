package day08_Allerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Allerts {

    /*
    1) https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
    2) Click for Js Alert butonuna tiklayalim
    3) Tikladindak sanra cikan uyari mesajina (alert) tamam diyelim
     */

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test1() throws InterruptedException {
        //1) https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


        //    2) Click for Js Alert butonuna tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        //    3) Tikladindak sanra cikan uyari mesajina (alert) tamam diyelim
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
    }


}
