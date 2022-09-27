package day12_FileExist_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utulities.TestCaseBeforeClassAfterClass;

public class C02_FileExistUpload extends TestCaseBeforeClassAfterClass {

    //Tests packagenin altina bir class oluşturun : C05_UploadFile
    //https://the-internet.herokuapp.com/upload adresine gidelim
    //chooseFile butonuna basalim
    //Yuklemek istediginiz dosyayi secelim.
    //Upload butonuna basalim.
    //“File Uploaded!” textinin goruntulendigini test edelim.


    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
       WebElement dosyaSec= driver.findElement(By.xpath("//*[@id='file-upload']"));
       String dosyaYolu = "C:\\Users\\Hp\\Desktop\\text.txt.txt";
       dosyaSec.sendKeys(dosyaYolu);
        //Yuklemek istediginiz dosyayi secelim.
        //Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());
    }
}
