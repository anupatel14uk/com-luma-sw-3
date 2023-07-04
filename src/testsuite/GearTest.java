package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GearTest extends BaseTest {
    String baseurl = "https://magento.softwaretestingboard.com/";

    String expectedText, actualText;

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() {
        //Mouse Hover on Gear Menu
        WebElement geraMenu = driver.findElement(By.xpath("//a[@id='ui-id-6']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(geraMenu).build().perform();

        //Click on Bags

        driver.findElement(By.xpath("//span[contains(text(),'Bags')]")).click();

        //Click on Product Name ‘Overnight Duffle’
        driver.findElement(By.xpath("//a[contains(text(),'Overnight Duffle')]")).click();

        //Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        driver.findElement(By.xpath("//input[@id='qty']")).sendKeys("3");

        //Click on ‘Add to Cart’ Button.
        driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]")).click();

        //Verify the text
        //‘You added Overnight Duffle to your shopping cart.’
        actualText = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
        expectedText = "You added Overnight Duffle to your shopping cart.";
        Assert.assertEquals("Not Matched Any Text", expectedText, actualText);

        //Click on ‘shopping cart’ Link into
        //message
        driver.findElement(By.xpath("//a[contains(text(),'shopping cart')]")).click();

        //Verify the product name ‘Overnight Duffle’
        actualText = driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']")).getText();
        expectedText = "Overnight Duffle";
        Assert.assertEquals("Not Matched Any Text", expectedText, actualText);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}


