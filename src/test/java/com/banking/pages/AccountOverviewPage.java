package com.banking.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountOverviewPage {
	WebDriver driver;
	
	By accountTitle=By.xpath("//div[@id='showOverview']//h1");
	//By accountNumber = By.xpath("//table[@id='accountTable']//tbody//tr/td[1]/a");
	By accountNumber = By.xpath("//table[@id='accountTable']//a");
	By accountBalance=By.xpath("//table[@id='accountTable']//tr[1]/td[2]");
	By availableAmount=By.xpath("//table[@id='accountTable']//tr[1]/td[3]");
	By totalBalance = By.xpath("//table[@id='accountTable']//tr[td/b[text()='Total']]/td[2]");
	By accountNumber1 = By.xpath("//a[contains(@href,'activity.htm')]");
	
	public AccountOverviewPage(WebDriver driver) {
	    this.driver = driver;
	}

	public String getAccountTitle() {
	    return driver.findElement(accountTitle).getText();
	}
	public String getAccountNumber() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement account = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(accountNumber)
	    );

	    return account.getText();
	}
	public String getAccountBalance()
	{
		return driver.findElement(accountBalance).getText();
	}
	public String getAvailableAmount()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		WebElement availableAccount=wait.until(ExpectedConditions.visibilityOfElementLocated(availableAmount));
		
		return availableAccount.getText();
		
	}
	public String getTotalBalance() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement total = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(totalBalance)
	    );

	    return total.getText();
	}
	public void clickAccountNumber() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement account = wait.until(
	        ExpectedConditions.elementToBeClickable(accountNumber1)
	    );

	    account.click();
	}

}
