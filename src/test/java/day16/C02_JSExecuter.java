package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import utulities.TestCaseBeforeClassAfterClass;

public class C02_JSExecuter extends TestCaseBeforeClassAfterClass {

    @Test
    public void test01() {
        //Amazona gidelim
        driver.get("https://www.amazon.com");

        //Asagidaki carreers butonunu gorunceye kadar js ile scrool edelim
        WebElement careers =  driver.findElement(By.xpath("//*[text()='Careers']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",careers);

        //Carreers butonuna js ile click yapalim
        jse.executeScript("arguments[0].click()",careers);




    }
}
