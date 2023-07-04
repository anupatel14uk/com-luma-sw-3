package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MenTest extends BaseTest {
    String baseurl = "https://magento.softwaretestingboard.com/";
    String expectedText, actualText;

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }


    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() {
        //Mouse Hover on Men Menu
        WebElement men = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
        //Mouse Hover on Bottoms
        WebElement bottoms = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[3]/ul[1]/li[2]/a[1]/span[2]"));
        //Click on Pants
        WebElement pants = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[3]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(men).build().perform();
        action.moveToElement(bottoms).build().perform();
        action.moveToElement(pants).click().build().perform();

        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        WebElement prodName = driver.findElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        WebElement size = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(prodName).build().perform();
        action1.moveToElement(size).click().build().perform();

        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        WebElement color = driver.findElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
        Actions action2 = new Actions(driver);
        action2.moveToElement(color).click().build().perform();

        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[3]//div[1]//div[1]//form[1]//button[1]//span[1]")).click();

        //1 Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        //verifyAddedCartMessage();
        expectedText = "You added Cronus Yoga Pant to your shopping cart.";
        actualText = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
        Assert.assertEquals("Text Not Matched", expectedText, actualText);

        //Verify the text ‘Shopping Cart.’
        driver.findElement(By.xpath("//a[normalize-space()='shopping cart']")).click();
        actualText = driver.findElement(By.xpath("//span[@class='base']")).getText();
        expectedText = "Shopping Cart";
        Assert.assertEquals("NOt Matched", expectedText, actualText);

        // Verify the product name ‘Cronus Yoga Pant’
        actualText = driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")).getText();
        expectedText = "Cronus Yoga Pant";
        Assert.assertEquals("NOt Matched", expectedText, actualText);

        //Verify the product size ‘32’
        actualText = driver.findElement(By.xpath("//dd[contains(text(),'32')]")).getText();
        expectedText = "32";
        Assert.assertEquals("NOt Matched", expectedText, actualText);

        //Verify the product colour ‘Black’
        actualText = driver.findElement(By.xpath("//dd[contains(text(),'Black')]")).getText();
        expectedText = "Black";
        Assert.assertEquals("NOt Matched", expectedText, actualText);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }

}


