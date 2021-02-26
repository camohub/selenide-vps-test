package tests;

import categories.FullTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


@Category({FullTest.class})
public class jsScrollTest extends baseTest
{
    private String siteUrl = "/tabulka.php";

    @Test
    public void scrollTest() throws InterruptedException
    {
        driver.get(baseUrl + siteUrl);

        JavascriptExecutor js = ((JavascriptExecutor) driver);

        WebElement tr = driver.findElement( By.xpath("//tbody/tr[last()]") );

        js.executeScript("arguments[0].style.border = '2px solid red'", tr );
        js.executeScript("arguments[0].scrollIntoView(true)", tr );
        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0, -300)" );
        Thread.sleep(3000);

    }

    @Test
    public void scrollToEnd() throws InterruptedException {
        driver.get(baseUrl + siteUrl);

        JavascriptExecutor js = ((JavascriptExecutor) driver);

        long height = (long)js.executeScript("return document.body.scrollHeight");
        js.executeScript("window.scrollBy(0, " + height + ")" );
        Thread.sleep(3000);
    }
}
