package tests;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import services.WebDriverService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;


public class baseTest
{

    protected WebDriver driver;

    protected String baseUrl = "http://localhost/seleniumweb";

    protected Boolean testFail = false;  // If true make a screenshot


    @Before
    public void baseSetUp() throws MalformedURLException
    {
        driver = (new WebDriverService()).getDriver();
        //driver = new ChromeDriver();
    }


    @After
    public void baseTearDown() throws IOException
    {
        makeScreenshot();  // Make screenshot

        driver.close();
        driver.quit();
    }


    protected void makeScreenshot() throws IOException
    {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(getScreenshotName()));
    }


    /**
     * Get date string for screenshot file name
     * @return
     */
    protected String getScreenshotName()
    {
        String date = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        Integer rand = new Random().nextInt(10000);
        String fileName = "./target/screenshots/" + getClass().getSimpleName() + "_" + date + "_" + rand + "_screenshot.png";

        return fileName;
    }
}
