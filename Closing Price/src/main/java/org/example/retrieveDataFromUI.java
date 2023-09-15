package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class retrieveDataFromUI {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;



    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void testWebApplication() throws InterruptedException {

        // Step 1 : Opens a webpage www.google.com/finance on a chrome browser
        driver.get("https://www.google.com/finance");
        TimeUnit.SECONDS.sleep(4);

        //Step 2 : Search ticker: GOOGL
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-" +
                "wiz[2]/div/div[3]/div[3]/div/div/div/div[1]/input[2]"));
        searchBox.sendKeys("GOOGL");
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz[2]/div/div[3]/" +
                "div[3]/div/div/span")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(new By.ByPartialLinkText("Alphabet Inc Class A")).click();
        TimeUnit.SECONDS.sleep(2);

        // Step 3 : Get previous closing price
        String closingPrice = driver.findElement(By.className("P6K39c")).getText();

        //Step 4 : Print the previous closing price
        Assert.assertNotNull(closingPrice);
        System.out.println("Previous Close : " + closingPrice);

      }

    @AfterTest
    public void tearDown() {
        // Close the browser after the test is complete
        driver.quit();
    }
}


/*

1. Opens a webpage www.google.com/finance on a chrome browser
2. Search ticker: GOOGL
3. Get previous closing price
4. Print the previous closing price
When you submit your solution, make sure to include:
TestNG file to run the test

 */
