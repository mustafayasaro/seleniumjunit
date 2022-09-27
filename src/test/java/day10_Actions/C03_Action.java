package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestCaseBeforeClassAfterClass;

public class C03_Action extends TestCaseBeforeClassAfterClass {
    @Test
    public void test01() {
        // amazon sayfasina gidellim
        // account menusunden create a list bolumune tiklayalim

        driver.get("https://www.amazon.com");
        //amazon git
        driver.get("https://amazon.com");
        // accont menusunden create a list linkiine tıklayalım
        Actions action = new Actions(driver);
        WebElement accounLink = driver.findElement(By.xpath("//*[@id='nav-link-accountList-nav-line-1']"));
        action.moveToElement(accounLink).perform();
        driver.findElement(By.xpath("//*[text()='Create a List']"));
       /*
       Bir web sitesinde mouse ile acilan bir WebElementin'e ulamak istersek
       action.moveToElement() method'unu kullanmamiz gerekir
       aksi takdirde HTML kodlari arasinda webelementi bulur
       ama ulasamadigi icin  ElemenNotInteractableException: element not interactable exception'i fırlatır
        */


    }
}
