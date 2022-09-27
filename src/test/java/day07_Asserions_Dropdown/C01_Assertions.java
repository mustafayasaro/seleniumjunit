package day07_Asserions_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {

    /*
    Bir Class olusturalim YanlisEmailTesti
    http://automationpractice.com/index.php sayfasina gidelim
    Sign in butonuna basalim
    Email kutusuna @isareti olmayan bir mail yazip enter’a
    bastigimizda “Invalid email address” uyarisi ciktigini test edelim
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
        driver.close();
    }
    @Test
    public void test1(){
        //   1. http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");
        //   2. Sign in butonuna basalim
        WebElement signInButton = driver.findElement(By.xpath("//*[@class='login']"));
        signInButton.click();


        //   3.Email kutusuna @isareti olmayan bir mail yazip enter’a
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("denemegmail.com" + Keys.ENTER);
        //   4.bastigimizda "Invalid email address" uyarisi ciktigini testedelim
        WebElement warning=driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(warning.isDisplayed());
    }

}
