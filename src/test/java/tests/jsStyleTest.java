package tests;

import categories.FullTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;


@Category({FullTest.class})
public class jsStyleTest extends baseTest
{
    private String siteUrl = "/tabulka.php";

    @Test
    public void javascriptTest() throws InterruptedException
    {
        driver.get(baseUrl + siteUrl);

        JavascriptExecutor js = ((JavascriptExecutor) driver);

        List<WebElement> rows = driver.findElements( By.cssSelector("table tr") );

        for(WebElement row : rows) {
            js.executeScript("arguments[0].style.border = '3px solid red'", row);
        }
    }
}
