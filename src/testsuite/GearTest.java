package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilites.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser();
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {


        //Mouse Hover on Gear Menu click on bags
        mouseHover(By.xpath("//a[@id='ui-id-6']"), By.xpath("//span[contains(text(),'Bags')]"));


        //* Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));
        //* Verify the text ‘Overnight Duffle’
        //  String expectedText = "Overnight Duffle";
        //  String actualText = getTextFromElement(By.xpath("//span[contains(text(),'Overnight Duffle')]"));
        //  Assert.assertEquals("Overnight Duffle", expectedText, actualText);
        //* Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");
        //* Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[contains(text(),'Add to Cart')]"));

        //* Verify the text You added Overnight Duffle to your shopping cart.
        String expectedText1 = "You added Overnight Duffle to your shopping cart.";
        String actualText1 = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals("Message not found", expectedText1, actualText1);

        //* Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //Verify the Qty is ‘3’
        //* Verify the product price ‘$135.00’
        //* Change Qty to ‘5’
        //* Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[text()='Update Shopping Cart']"));
        //* Verify the product price ‘$225.00’
        String expectedText2 = "$225.00";
        String actualText2 = getTextFromElement(By.xpath("//span[@class='cart-price']//span[@class='price'][text()='$225.00']"));
        Assert.assertEquals("Message not found", expectedText2, actualText2);

    }

    @After

    public void closeBrowser() {
        driver.quit();
    }
}
