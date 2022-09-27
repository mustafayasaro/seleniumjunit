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
import java.util.List;

public class C02_DropdownHandle {

    /*
●Bir class oluşturun:C3_DropDownAmazon
●https://www.amazon.com/ adresinegidin.
-Test1
Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
oldugunu testedin
-Test2
1.Kategori menusunden Books seceneginisecin
2.Arama kutusuna Java yazin vearatin
3.Bulunan sonuc sayisiniyazdirin
4.Sonucun Java kelimesini icerdigini testedin
*/

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");

    }
    @AfterClass
    public static void tearDown(){
        // driver.close();
    }

    @Test
    public void test1(){
        //-Test1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
        //oldugunu testedin
        List<WebElement> drops = driver.findElements(By.xpath("//option"));
        System.out.println(drops.size());
        for (WebElement w: drops
             ) {
            System.out.println(w.getText());
        }
        int dropDownList = drops.size();
        int expectedSayi = 45;
        Assert.assertNotEquals(expectedSayi,dropDownList);

    }

    @Test
    public void test2(){
        //-Test2
        //1.Kategori menusunden Books secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        ddm.sendKeys("Book");
        //2.Arama kutusuna Java yazin ve aratin
        WebElement armaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        armaKutusu.sendKeys("Java", Keys.ENTER);
        //3.Bulunan sonuc sayisiniyazdirin
        WebElement sonucYazisii = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYazisii.getText());
        //4.Sonucun Java kelimesini icerdigini testedin
        String expectedKelime = "Java";
        String actualSonucYazisi = sonucYazisii.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));


    }







}
