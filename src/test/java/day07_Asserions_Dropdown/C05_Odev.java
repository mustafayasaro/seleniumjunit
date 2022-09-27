package day07_Asserions_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C05_Odev {

    /*
        1. http://zero.webappsecurity.com/ Adresine gidin
        2. Sign in butonuna basin
        3. Login kutusuna “username” yazin
        4. Password kutusuna “password.” yazin
        5. Sign in tusuna basin
        6. Pay Bills sayfasina gidin
        7. “Purchase Foreign Currency” tusuna basin
        8. “Currency” drop down menusunden Eurozone’u secin
        9. “amount” kutusuna bir sayi girin
        10. “US Dollars” in secilmedigini test edin
        11. “Selected currency” butonunu secin
        12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
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
    public void test() throws InterruptedException {
        // 1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");


        //        2. Sign in butonuna basin
        driver.findElement(By.xpath("//*[@class='icon-signin']")).click();


        //        3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");

        //        4. Password kutusuna “password.” yazin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");

        //        5. Sign in tusuna basin
        driver.findElement(By.xpath("//*[@value='Sign in']")).click();
        driver.navigate().back();

        //        6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        //        7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        //        8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddm = driver.findElement(By.xpath("//*[@name='currency']"));
        Select option = new Select(ddm);
        option.selectByVisibleText("Eurozone (euro)");

        //        9. “amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("1500");

        //        10. “US Dollars” in secilmedigini test edin
        WebElement USButton = driver.findElement(By.xpath("(//*[@style='padding-bottom: 8px'])[1]"));
        Assert.assertFalse(USButton.isSelected());

        //        11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();

        //        12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//*[@id='pc_calculate_costs']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='purchase_cash']")).click();

        //        13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement passed = driver.findElement(By.xpath("//*[text()='Foreign currency cash was successfully purchased.']"));
        Assert.assertTrue(passed.isDisplayed());
    }

}
