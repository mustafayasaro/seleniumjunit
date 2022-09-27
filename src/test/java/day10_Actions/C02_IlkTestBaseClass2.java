package day10_Actions;

import org.junit.Test;
import utulities.TestCaseBeforeClassAfterClass;

public class C02_IlkTestBaseClass2 extends TestCaseBeforeClassAfterClass {

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
    }

}
