package day14_ReadExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        // belirtilen satir no ve sutun no degerlerini parametre olarak alip
        // o cell'deki datayi konsola yazdirin
        // sonra sonucun konsolda yazanla ayni oldugunu dogrulayin

        int satir = 12;
        int sutun = 2;


        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        String actualData = workbook.getSheet("Sayfa1")
                .getRow(11)
                .getCell(2)
                .toString();

        //Index 0'dan başladığı için bizden istenen satıra ulaşabilmek için bir eksiğini alırız
        System.out.println(actualData);

        String expected =  "Baku";
        Assert.assertEquals(expected,actualData);





    }
}
