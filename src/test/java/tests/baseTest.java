package tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import rules.TestWatcher;
import services.WebDriverService;
import java.io.IOException;
import java.net.MalformedURLException;


public class baseTest
{

    protected WebDriver driver;

    protected String baseUrl = "http://localhost/seleniumweb";


    /**
     * This is the JUnit way how to catch fail event.
     */
    @Rule
    public TestWatcher failWatcher = new TestWatcher();


    @Before
    public void baseSetUp() throws MalformedURLException
    {
        driver = (new WebDriverService()).getDriver();

        failWatcher.setDriver(driver);
    }


    @After
    public void baseTearDown() throws IOException
    {
        // Is implemented in TestWatcher::finish()
        //driver.close();
        //driver.quit();
    }
}
