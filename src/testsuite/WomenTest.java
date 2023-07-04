package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WomenTest extends BaseTest {
    String baseurl = "https://magento.softwaretestingboard.com/";
    String expectedText, actualText;

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {
        //Mouse Hover on Women Menu
        WebElement women = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        //Mouse Hover on Tops
        WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
        //Click on Jackets
        WebElement jacket = driver.findElement(By.xpath("//a[@id='ui-id-11']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(women).build().perform();
        actions.moveToElement(tops).build().perform();
        actions.moveToElement(jacket).click().build().perform();

        //Select Sort By filter “Product Name”
        WebElement dropDown3 = driver.findElement(By.id("sorter"));
        Select select3 = new Select(dropDown3);
        select3.selectByValue("name");
        select3 = new Select(driver.findElement(By.id("sorter")));

        //Verify the products name display in alphabetical order
        expectedText = "Product Name";
        actualText = select3.getFirstSelectedOption().getText();
        Assert.assertEquals("Matched Text", expectedText, actualText);

    }

    @Test
    public void verifyTheSortByPriceFilter() {
        //Mouse Hover on Women Menu
        WebElement Women = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        //* Mouse Hover on Tops
        WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
        //* Click on Jackets
        WebElement jacket = driver.findElement(By.xpath("//a[@id='ui-id-11']"));
        Actions action = new Actions(driver);
        action.moveToElement(Women).build().perform();
        action.moveToElement(tops).build().perform();
        action.moveToElement(jacket).click().build().perform();

        //Select Sort By filter “Price”
        WebElement dropDown3 = driver.findElement(By.id("sorter"));
        Select select3 = new Select(dropDown3);
        select3.selectByValue("price");

        select3 = new Select(driver.findElement(By.id("sorter")));

        //Select Sort By filter “Price”
        expectedText = "Price";
        actualText = select3.getFirstSelectedOption().getText();
        Assert.assertEquals("Matched Text", expectedText, actualText);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
