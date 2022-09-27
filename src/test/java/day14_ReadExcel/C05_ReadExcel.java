package day14_ReadExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {

        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "C:\\Users\\Hp\\Downloads\\ulkeler.xlsx";

        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        //-sayfa 2'ye gidip satir sayisinin 6, kullanilan satir sayisinin ise 3 oldugunu test edin
        int sonSatir = workbook.getSheet("Sayfa2").getLastRowNum();
        System.out.println(sonSatir);
        int expectedLastRow = 6;
        Assert.assertEquals(expectedLastRow, sonSatir);

        //Kullanilan satir sayisini bulunuz
        int kullanilanSatirSaysi = workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        System.out.println(kullanilanSatirSaysi);
        int expectedKullanilanSatir = 3;
        Assert.assertEquals(kullanilanSatirSaysi,expectedKullanilanSatir);

        //lastRow --> en son yazilan satir
        //Physical --> kullanilan satir sayisi

    }
}
