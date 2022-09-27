package day05_JUnit_BeforeAfter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {

    WebDriver driver;

    @Before
    // before notasyon her testten once calisir
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void method1(){
        // 1 defa before methodu calisir
        driver.get("https://www.amazzon.com");
        // 1 defa after methodu calisir
        // toplamda 3 method calisir
    }

    @After
    // after notasyon her testten sonra calisir
    public void tearDown(){
        driver.close();
    }

}
