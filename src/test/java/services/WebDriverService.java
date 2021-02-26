package services;

import resources.BrowsersEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class WebDriverService
{

    public static String CHROME_EXE = "chromedriver.exe";
    public static String GECKO_EXE = "geckodriver.exe";

    public static String HUB_URL = "http://127.0.0.1:4444/wd/hub";

    private WebDriver driver = null;


    /**
     * This returns singleton driver
     * @return
     * @throws MalformedURLException
     */
    public WebDriver getDriver() throws MalformedURLException
    {
        String browser = System.getProperty("browser");
        browser = browser == null ? "" : browser.toLowerCase();

        if (browser.equals(BrowsersEnum.CHROME.getValue()))
        {
            this.driver = new RemoteWebDriver(this.getRemoteUrl(), new ChromeOptions());
        }
        else if (browser.equals(BrowsersEnum.FIREFOX.getValue()))
        {
            this.driver = new RemoteWebDriver(this.getRemoteUrl(), new FirefoxOptions());
        }
        else
        {
            this.driver = new RemoteWebDriver(this.getRemoteUrl(), getChromeOptions());
            //this.driver = this.getDriver(CHROME_EXE);
            //throw new IllegalArgumentException("Base::getDriver() invalid argument: " + browser);
        }

        return this.driver;
    }

    /**
     * Remote selenium server (nodes) needs to have new instance for every test (not singleton).
     * Otherwise on the driver.quit() lose the session.
     * @return
     * @throws MalformedURLException
     */
    public URL getRemoteUrl() throws MalformedURLException
    {
        return new URL( HUB_URL );
    }


    private ChromeOptions getChromeOptions()
    {
        ChromeOptions options = new ChromeOptions();

        //options.setCapability("browserVersion", "88");

        options.addArguments("headless");
        options.addArguments("window-size=1400,800");
        options.addArguments("disable-gpu");

        return options;
    }

    /**
     * Avoid using Selenium server GRID
     * @param which
     * @return
     */
    /*public WebDriver getDriver(String which)
    {
        if (which == CHROME_EXE) {
            System.setProperty("webdriver.chrome.driver", CHROME_EXE);
            this.driver = new ChromeDriver();
        } else if (which == GECKO_EXE) {
            System.setProperty("webdriver.gecko.driver", GECKO_EXE);
            this.driver = new FirefoxDriver();
        }

        return this.driver;
    }*/
}
