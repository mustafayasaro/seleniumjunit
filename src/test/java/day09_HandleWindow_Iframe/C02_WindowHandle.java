package day09_HandleWindow_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {
    //1- Amazon Sayfasina girelim
//2- Url'nin amazon içerdiğini test edelim
//3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
//4- title'in BestBuy içerdiğini test edelim
//5- İlk sayfaya dönüp sayfada java aratalım
//6- Arama sonuclarının java içerdiğini test edelim
//7- Yeniden bestbuy sayfasına gidelim
//8- Logonun görünürlüğünü test edelim
//9- Sayfaları Kapatalım

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
        //1- Amazon Sayfasina girelim
        driver.get("https://www.amazon.com");
        String amazonWindowHandle = driver.getWindowHandle();
        /*
        Eger bize verilen textte sayfalar arasi gecis varsa
        her driver.get() methodundan sonra driverin window handle
        degerini String bir degiskene atariz
        daha sonra farkli bir saydaya ya da sekmeye gittikten sonra
        tekrar ilk sasyfaya donmemiz istenirse String
        degiskene atadigimiz window handle degerleri ile sayfalar
        arasi gecis yapariz
         */

    //2- Url'nin amazon içerdiğini test edelim
        String Url = driver.getCurrentUrl();
        Assert.assertTrue(Url.contains("amazon"));


    //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)

        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.bestbuy.com");
        // yeni pencere acmak icin bu methodu kullaniriz
        String bestBuyWH = driver.getWindowHandle();


    //4- title'in BestBuy içerdiğini test edelim
        String betsyTitle = driver.getTitle();
        Assert.assertTrue(betsyTitle.contains("Best Buy"));

    //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("java", Keys.ENTER);

    //6- Arama sonuclarının java içerdiğini test edelim

        WebElement aramaSonuclari = driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']"));
        String arananKelime = "java";
        Assert.assertTrue(aramaSonuclari.getText().contains(arananKelime));

    //7- Yeniden bestbuy sayfasına gidelim

        driver.switchTo().window(bestBuyWH);// sayfalar arasi ecis icin kullanilan method

    //8- Logonun görünürlüğünü test edelim
        WebElement logo = driver.findElement(By.xpath("//*[@alt='Best Buy Logo']"));
        Assert.assertTrue(logo.isDisplayed());
        // Assert.assertTrue(driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]")).isDisplayed());

    //9- Sayfaları Kapatalım
        driver.quit();


    }





}
