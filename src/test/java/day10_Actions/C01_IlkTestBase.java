package day10_Actions;

import org.junit.Test;
import utulities.TestBaseBeforeAfter;

public class C01_IlkTestBase extends TestBaseBeforeAfter {

    //utilities package'ında abstract class oluşturduk. Buradaki class'ı Utilites package'ındaki
    // class'a extent yaptik.@Before ve @after methodlarını oradaki class'ta olusturdugumuz icin bu ssyfada olusturmamıza
        //gerek kalmadı
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
    }

}
