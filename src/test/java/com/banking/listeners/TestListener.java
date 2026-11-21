package com.banking.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.banking.base.BaseTest;
import com.banking.reports.ExtentReportManager;
import com.banking.utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest = ExtentReportManager
                .getReportInstance()
                .createTest(result.getName());

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test passed successfully");
    }
    

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());

        BaseTest baseTest = (BaseTest) result.getInstance();
        WebDriver driver = baseTest.getDriver();

        if (driver != null) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(
                    driver, result.getName());

            if (screenshotPath != null) {
                test.get().addScreenCaptureFromPath(screenshotPath);
            }
        } else {
            test.get().fail("WebDriver is null. Screenshot could not be captured.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test skipped");
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {

        ExtentReportManager.getReportInstance().flush();
    }
} 