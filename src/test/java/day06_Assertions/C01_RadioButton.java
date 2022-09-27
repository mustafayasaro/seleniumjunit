package day06_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_RadioButton {
    /*
    Bir class oluşturun : RadioButtonTest
    Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    https://www.facebook.com adresine gidin
    Cookies’i kabul edin
    “Create an Account” button’una basin
    “radio buttons” elementlerini locate edin
    Secili degilse cinsiyet butonundan size uygun olani secin

     */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
        //   https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //    Cookies’i kabul edin
        WebElement cookies = driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']"));
        if (cookies.isDisplayed()){
            cookies.click();
        }
        //    “Create an Account” button’una basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //    “radio buttons” elementlerini locate edin
        WebElement femaleButton = driver.findElement(By.xpath("//input[@value='1']"));
                    // * yerine input yazinca getirmeyebiliyor onu icin bazen input yazmaliyiz
        WebElement maleButton = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement privateButton = driver.findElement(By.xpath("//input[@value='-1']"));

        //    Secili degilse cinsiyet butonundan size uygun olani secin
        Thread.sleep(2000);
        if (!maleButton.isSelected()){
            maleButton.click();
        }


    }
}
