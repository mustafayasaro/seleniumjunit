package day15_DataExcel_Screenshot;


import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utulities.TestCaseBeforeClassAfterClass;

import java.io.File;
import java.io.IOException;


public class C04_ScreenShot extends TestCaseBeforeClassAfterClass {
    @Test
    public void screenShotTest1() throws IOException {


        // Amazon sayfasina gidin ve tum sayfanin resmini alin
        driver.get("https://www.amazon.com");
        TakesScreenshot ts = (TakesScreenshot) driver;
        /*
        Bir web sitesinin resmini alabilmek icin TakesScreenshot
        class'indan obje olusturup gecici bir File class'indan
        degiskene TakeScreenShot 'dan ousturdugum objeden
        getScreenShotAs method'unu kullanarak gecici bir File olustuturuz
         */


        System.out.println(tarih);


        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/AllPage"+tarih+".jpeg"));

        //resmi resmin uzerine degil de yeni bir resim olarak alabilmek icin image ismine tarih ekleyip atadik
        //tarih in normal formati dosya isimlendirmeye uygun olmadigi icin tarih yazim formati ile oynayip uygun hale getirdik
        //sonra bu sekil bize her zaman lazim olabilir diye TestDataBase imize attik

    }
}
