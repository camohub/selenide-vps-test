
package tests;

import categories.FastTest;
import categories.FullTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Category({FullTest.class})
public class waitTest extends baseTest
{
    private String siteUrl = "/waitForIt.php";

    @Test
    public void waitForTest()
    {
        driver.get(baseUrl + siteUrl);

        driver.findElement( By.id("startWaitForText") ).click();

        WebElement input = driver.findElement( By.id("waitForTextInput") );

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeToBe(input, "value", "dary !!!"));


        Assert.assertEquals("dary !!!", input.getAttribute("value") );
    }


    @Test
    public void waitForTest2()
    {
        driver.get(baseUrl + siteUrl);

        driver.findElement( By.id("startWaitForProperty") ).click();

        WebElement input = driver.findElement( By.id("waitForProperty") );

        new WebDriverWait(driver, 10)
                .withMessage("Some ERRRORRR message!!!")
                .until(ExpectedConditions.attributeContains( input, "class", "error"));

        Assert.assertFalse( "waitForIt btn startWaitForProperty should be disabled after click()", driver.findElement( By.id("startWaitForProperty") ).isEnabled() );
        Assert.assertEquals( "true",  driver.findElement( By.id("startWaitForProperty") ).getAttribute("disabled") );
    }
}
