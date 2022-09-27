package day08_Allerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_Iframe {
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
        // https://html.com/tags/iframe/ adresine gidiniz
        // youtube videosunu calisirin

        driver.get("https://html.com/tags/iframe/");
        List<WebElement> IframeList = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(IframeList.get(0));
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();
        /*
        Bir web sitesinde bir video(youtube vb.) varsa <iframe> tagi icrisinde ise
        bu videoyu direkt locate edip calistirmak dinamik olmaz
        cunkulink degisebilir ve locater'imiz calismaz
        Bunun icin butun frame'leri bir array liste atip index ile
        frame'i secip daha sonra play tusunu locate edip click() yapariz
         */


        //WebElement youtubeFrame = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        //youtubeFrame.click();

    }
}
