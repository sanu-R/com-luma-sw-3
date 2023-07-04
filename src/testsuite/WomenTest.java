package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilites.Utility;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";
    @Before
    public void setUp() {
        openBrowser();
    }
@Test
public void verifyTheSortByProductNameFilter(){
    //Mouse Hover on Women Menu
    mouseHover(By.xpath("//span[text()='Women']"),By.xpath("//span[text()='Women']"));

    //Mouse Hover on Tops
    mouseHover(By.linkText("Tops"),By.linkText("Jackets"));

    // Click on Jackets
    clickOnElement(By.xpath("//strong[contains(text(),'Jackets')]"));

   // Select Sort By filter “Product Name”
   selectByValueFromDropDown(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]"),"name");
    clickOnElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/a[1]"));
    //Verify the products name display in alphabetical order
    String expectedText = "Set Ascending Direction";
    String actualText = getTextFromElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/a[1]"));
    Assert.assertEquals("Message not found", expectedText, actualText);

}
@Test
public void verifyTheSortByPriceFilter(){
      //Mouse Hover on Women Menu
    mouseHover(By.xpath("//span[text()='Women']"),By.xpath("//span[text()='Women']"));
    // Mouse Hover on Tops
    mouseHover(By.linkText("Tops"),By.linkText("Jackets"));
    // Click on Jackets
    clickOnElement(By.xpath("//strong[contains(text(),'Jackets')]"));
    //Select Sort By filter “Price”
    selectByValueFromDropDown(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]"),"price");
    clickOnElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/a[1]"));
    // Verify the products price display in Low to High
    String expectedText1 = "Set Ascending Direction";
    String actualText1 = getTextFromElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/a[1]"));
    Assert.assertEquals("Message not found", expectedText1, actualText1);

}





@After

    public void closeBrowser() {
        driver.quit();
    }


}
