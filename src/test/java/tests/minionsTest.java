package tests;

import categories.FullTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@Category({FullTest.class})
public class minionsTest extends baseTest
{
    private String siteUrl = "/minions.php";

    @Test
    public void waitMinionsTest()
    {
        driver.get(baseUrl + siteUrl);
        int num = 7;

        driver.findElement( By.xpath("//input[@type='number']") ).sendKeys(String.valueOf(num));
        driver.findElement( By.xpath("//button[contains(@class, 'btn')]") ).click();

        new WebDriverWait(driver, 15)
                .withMessage("Waiting for img limit exceeded.")
                .until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='minions']//img"), num));

        Assert.assertEquals(num, driver.findElements( By.xpath("//div[@class='minions']//img") ).size());
    }

}
