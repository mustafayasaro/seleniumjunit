package day13_Cookies_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestCaseBeforeClassAfterClass;

import java.util.List;

public class C02_WebTables extends TestCaseBeforeClassAfterClass {

    //Bir class oluşturun : C02_WebTables
    //login( ) metodun oluşturun ve oturum açın.
    //https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
    //Username : manager
    //Password : Manager1!
    //table( ) metodu oluşturun
    //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
    //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    //printRows( ) metodu oluşturun //tr
    //table body’sinde bulunan toplam satir(row) sayısını bulun.
    //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    //4.satirdaki(row) elementleri konsolda yazdırın.

    @Test
    public void test1() {
        //Bir class oluşturun : C02_WebTables
        //login( ) metodun oluşturun ve oturum açın.
        //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        login();
        //Username : manager
        //Password : Manager1!
        //table( ) metodu oluşturun
        table();
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        //printRows( ) metodu oluşturun //tr
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //4.satirdaki(row) elementleri konsolda yazdırın.
    }

    /*
    Genel HTML kodlari acisindan tablo elementleri tag'lerle belirlenmistir.
             - <table>
             - <header> tablonun baslik kismini belirler
                <tr> veya <th> satirlari
                <td> satirdaki cell numarasini verir(bunu sutun diye adlandirabiliriz ama kodlarda sutun yoktur)
             - <tbody> tablo body'si
                <tr> satirlari
                <td> satirdaki cell numarasini verir(bunu sutun diye adlandirabiliriz ama kodlarda sutun yoktur)
     */
    private void table() {
        /*
        tabloda <table> tag'i altinda tablonun basligini gosteren <thead> tag'i bulunur
        eger baslikta satir(row) varsa <thead> tag'i altinda <tr>(satir) tag'i vardir
        Basliktaki sutunlara yani hucrelere(cell) de <th> tag'i ile ulasilir
        Basligin altindaki tablodaki verilere <tbody> tag'i ile altindaki astirlara(row)
        <tr> tag'i ile sutunlara yani hucrelere<td> tag'i ile ulasiriz
         */
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun sayisi: " + sutunSayisi.size());
        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement tumBasliklar = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Basliklar: " + tumBasliklar.getText());
        WebElement body = driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum body: " + body.getText());
        //printRows( ) metodu oluşturun //tr
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirSayisi=driver.findElements(By.xpath("//tbody/tr"));
        System.out.println("satir sayisi: " + satirSayisi.size());
        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirSayisi.forEach(t-> System.out.println(t.getText()));
        //4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.print("4.row elements : ");
        satirSayisi.stream().map(WebElement::getText).limit(4).skip(3).forEach(System.out::println);
        // System.out.println("4.satir "+driver.findElements(By.xpath("//tbody//tr[4]")));
    }

    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
        //thead-->Title başlıklari
        //tbody --> Title tablo
    }
}
