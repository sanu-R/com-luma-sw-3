package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilites.Utility;

public class MenTest extends Utility {


    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser();
    }


    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        // Mouse Hover on Men Menu,Mouse Hover on Bottoms,and click on Pants
        mouseHoverActionForThree(By.xpath("//span[contains(text(),'Men')]"), By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"), By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));

        // Mouse Hover on product name Cronus Yoga Pant and click on size32
        mouseHover(By.xpath("//div[2]//div[3]//select[1]"), By.linkText("Product Name"));

        clickOnElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));

        //* Mouse Hover on product name and click on size 32.
        mouseHover(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"), By.xpath("(//div[@id='option-label-size-143-item-175'])[1]"));
        Thread.sleep(700);
        //‘Cronus Yoga Pant’ and click on colour black
        clickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));


        //‘Cronus Yoga Pant’ and click on
        //‘Add To Cart’ Button.
        clickOnElement(By.xpath("//li[1]//div[1]//div[1]//div[3]//div[1]//div[1]//form[1]//button[1]//span[1]"));
        // Verify the text
        //‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
        String actualText = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals("Text not found", expectedText, actualText);
        Thread.sleep(700);
        //* Click on ‘shopping cart’ Link into
        //message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //* Verify the text ‘Shopping Cart.’
        String expectedText1 = "Shopping Cart";
        String actualText1 = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals("Text not found", expectedText1, actualText1);
        Thread.sleep(700);
        //* Verify the product name ‘Cronus Yoga Pant’
        String expectedText2 = "Cronus Yoga Pant";
        String actualText2 = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        Assert.assertEquals("Text not found", expectedText2, actualText2);
        Thread.sleep(700);
        //* Verify the product size ‘32’
        String expectedText3 = "32";
        String actualText3 = getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        Assert.assertEquals("Text not found", expectedText3, actualText3);
        //* Verify the product colour ‘Black’
        Thread.sleep(700);
        String expectedText4 = "Black";
        String actualText4 = getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        Assert.assertEquals("Text not found", expectedText4, actualText4);

    }


    @After

    public void closeBrowser() {
        driver.quit();
    }

}
