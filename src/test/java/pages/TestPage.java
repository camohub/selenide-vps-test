package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class TestPage {

    private String URL = "https://tatrytec.eu";

    private WebDriver driver;


    public TestPage(WebDriver driver)
    {
        this.driver = driver;
    }


    public void openPage()
    {
        driver.get(URL);
        driver.manage().window().maximize();
    }


    public void test1() throws InterruptedException
    {
        System.out.println("Test 1 is running.");

        WebElement header = driver.findElement(By.id("header"));

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(header));

        Assert.assertEquals( "Homepage nemá očakávaný titulok.", "Tatrytec.euu", header.getText());
    }


    public void test2()
    {
        System.out.println("Test 2 is running.");

        WebElement h = driver.findElement(By.xpath("//*[@id=\"main\"]/h1[3]"));

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(h));
    }


    public void test3()
    {
        System.out.println("Test 3 is running.");

        WebElement h = driver.findElement(By.xpath("//*[@id=\"main\"]/h1[3]"));

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(h));

        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        List<String> filteredRows = rows
                .stream()
                .filter(element -> element.getText().equals("Vendelin"))
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
