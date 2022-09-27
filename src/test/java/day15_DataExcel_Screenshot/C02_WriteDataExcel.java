package day15_DataExcel_Screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteDataExcel {
    @Test
    public void writeDataExcel() throws IOException {

        //Yeni bir Class olusturalim WriteExcel
        //Yeni bir test method olusturalim writeExcelTest()
        //Adimlari takip ederek 1.satira kadar gidelim
        String dosyaYolu ="C:\\Users\\Hp\\Downloads\\ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        //5.hucreye yeni bir cell olusturalim
        //Olusturdugumuz hucreye “Nufus” yazdiralim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");

        //2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue(15000000);

        //10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue(250000);

        //15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue(54000);

        //Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        /*
        Excel dosyamizaa veri girisi yaptikdan sonra dosyayi akisa aldigimiz gibi
        sonlandirmamiz gerekir.
        Daha sonra workbook objemize kayit etmemiz gerekir
        write() methodu ile yazilari excele aktaririzz
         */
        workbook.write(fos);


        //Dosyayi kapatalim
        fis.close();
        fos.close();
        workbook.close();

    }

}
