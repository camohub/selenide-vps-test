package tests;

import categories.FullTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@Category({FullTest.class})
public class jsBlurEventTest extends baseTest
{
    private String siteUrl = "/waitForIt.php";

    @Test
    public void blurTest() throws InterruptedException
    {
        driver.get(baseUrl + siteUrl);

        JavascriptExecutor js = ((JavascriptExecutor) driver);

        WebElement input = driver.findElement( By.cssSelector("#waitForBlur"));
        input.sendKeys("aaaaaaaaaaaaaaaaa");

        js.executeScript("arguments[0].blur()", input);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeToBe(input, "value", "blured!"));

    }
}
