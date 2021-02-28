
package rules;


import org.apache.commons.io.FileUtils;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class TestWatcher extends org.junit.rules.TestWatcher
{

    WebDriver driver;

    // Because of screenshot name
    String testClass;


    public void setDriver(WebDriver driver)
    {
        this.driver = driver;
    }


    public void setTestClass(String className)
    {
        this.testClass = className;
    }


    @Override
    protected void finished(Description description)
    {
        driver.close();
        driver.quit();
    }


    @Override
    protected void failed(Throwable e, Description description)
    {
        try
        {
            makeScreenshot();
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
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
        int rand = new Random().nextInt(10000);
        String fileName = "./target/screenshots/" + testClass + "_" + date + "_" + rand + "_screenshot.png";

        return fileName;
    }
}
