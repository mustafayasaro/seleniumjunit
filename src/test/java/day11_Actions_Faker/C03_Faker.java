package day11_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utulities.TestCaseBeforeClassAfterClass;

public class C03_Faker extends TestCaseBeforeClassAfterClass {

    @Test
    public void test01() {
        //"https://facebook.com"  Adresine gidin
        //“create new account”  butonuna basin
        //“firstName” giris kutusuna bir isim yazin
        //“surname” giris kutusuna bir soyisim yazin
        //“email” giris kutusuna bir email yazin
        //“email” onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin
        //Kaydol butonuna basın
        //Sayfayi kapatin

        //"https://facebook.com"  Adresine gidin
        driver.get("https://www.facebook.com");
        WebElement cookies = driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']"));
        if (cookies.isDisplayed()){
            cookies.click();
        }

        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        //“firstName” giris kutusuna bir isim yazin

        Faker fake = new Faker();
        WebElement isim = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        String mail = fake.internet().emailAddress();
        // Ayni mail adresini girmesini icin String bir degiskene atadik

        action.click(isim).sendKeys(fake.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(fake.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(mail).
                sendKeys(Keys.TAB).
                sendKeys(mail).
                sendKeys(Keys.TAB).
                sendKeys(fake.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("1").
                sendKeys(Keys.TAB).
                sendKeys("Tem").
                sendKeys(Keys.TAB).
                sendKeys("1982").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        /*
            Faker class'ını kullanma amacımız form doldurmamız gereken
            web sitelerinde defalarca kendi üreteceğimiz veriler yerine
            bizim için random veriler üretir ve işimizi kolaylaştırır.

            Faker class'ını kullanmak için mvnrespository.com adresinden
            java faker kütüphanesini aratır ve en çok kullanılanı
            pom.xml dosyamıza (dependencies tagları arasına) ekleriz.
            Sonra faker class'ından bir obje oluşturup;

            email için: faker.internet() methodunu kullanarak emailAddress() method'unu seçeriz.
            password: faker.internet().password()
            isim: faker.name().firstName()
            soyisim: faker.name().lastName()

            method'larını kullanırız.
            */




    }
}
