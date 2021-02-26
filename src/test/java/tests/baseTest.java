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
import java.util.Date;


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
        if( testFail )  makeScreenshot();  // Make screenshot

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
        String fileName = "./tmp/" + getClass().getName() + "_" + date + "_screenshot.png";

        return fileName;
    }
}
