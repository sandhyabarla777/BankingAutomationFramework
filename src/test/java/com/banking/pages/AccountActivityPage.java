
package com.banking.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountActivityPage {

    WebDriver driver;

    // Locators
    By accountNumber = By.id("accountId");
    By accountType = By.id("accountType");
    By accountBalance = By.id("balance");

    // Constructor
    public AccountActivityPage(WebDriver driver) {
        this.driver = driver;
    }

    // Reusable method to wait until element contains text
    private String getTextAfterLoading(By locator) {

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(15));

        return wait.until(d -> {

            WebElement element = d.findElement(locator);

            String text = element.getText().trim();

            return text.isEmpty() ? null : text;
        });
    }

    // Get Account Number
    public String getAccountNumber() {
        return getTextAfterLoading(accountNumber);
    }

    // Get Account Type
    public String getAccountType() {
        return getTextAfterLoading(accountType);
    }

    // Get Account Balance
    public String getAccountBalance() {
        return getTextAfterLoading(accountBalance);
    }
}
