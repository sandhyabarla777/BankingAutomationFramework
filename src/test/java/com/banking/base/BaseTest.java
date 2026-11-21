package com.banking.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {




    // ThreadLocal WebDriver for future parallel execution
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Application URL
    String url = "https://parabank.parasoft.com/parabank/index.htm";

    // Browser setup
    @BeforeMethod
    public void setUp() {
    	//System.out.println("SETUP RUNNING FOR: " + getClass().getName());

        ChromeOptions options = new ChromeOptions();

        WebDriver webDriver = new ChromeDriver(options);

        driver.set(webDriver);

        getDriver().manage().window().maximize();

        getDriver().get(url);

        System.out.println("Browser launched successfully");
    }

    // Get WebDriver instance
    public WebDriver getDriver() {
        return driver.get();
    }

    // Browser teardown
    @AfterMethod
    public void tearDown() {

        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }

        System.out.println("Browser closed successfully");
    }



	

}
