package tests;

import categories.FullTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@Category({FullTest.class})
public class prestigeTest extends baseTest
{
    private String siteUrl = "/prestige.php";

    @Test
    public void waitMinionsTest()
    {
        driver.get(baseUrl + siteUrl);

        WebElement klobuk = driver.findElement( By.cssSelector("div.hat img") );

        klobuk.click();

        new WebDriverWait( driver, 3 )
                .until(ExpectedConditions.invisibilityOf( klobuk ));

        new WebDriverWait( driver, 5 )
                .until(ExpectedConditions.visibilityOf( klobuk ));
    }
}
