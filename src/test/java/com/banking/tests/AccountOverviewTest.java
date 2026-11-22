package com.banking.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.base.BaseTest;
import com.banking.pages.AccountActivityPage;
import com.banking.pages.AccountOverviewPage;
import com.banking.pages.LoginPage;
import org.testng.annotations.Listeners;
import com.banking.listeners.TestListener;

@Listeners(TestListener.class)
public class AccountOverviewTest extends BaseTest {
	@Test(groups = {"smoke", "regression"})
	 public void verifyAccountOverview()	
	 {
		//System.out.println("Thread ID: " + Thread.currentThread().getId());
		System.out.println("AccountOverviewTest driver: " + getDriver());
		LoginPage loginPage=new LoginPage(getDriver());
		loginPage.loginOperation("sandhya_test_2028" ,"Test@123");
		System.out.println("Current URL: " + getDriver().getCurrentUrl());
		System.out.println("Page title: " + getDriver().getTitle());
		
		//Assert.fail("Testing screenshot capture");
		
		AccountOverviewPage overview=new AccountOverviewPage(getDriver());
		
		String actualTitle=overview.getAccountTitle();
		
		Assert.assertEquals(actualTitle, "Accounts Overview");
		
		String actualAccountNumber=overview.getAccountNumber();
		Assert.assertTrue(!actualAccountNumber.isEmpty(), "Account Number is not displaying");
		
		String actualBalance=overview.getAccountBalance();
		Assert.assertEquals(actualBalance,"$515.50");
		
		
		String actualAvailableAmount=overview.getAvailableAmount();
		Assert.assertEquals(actualAvailableAmount, "$515.50");
		
		String actualTotal = overview.getTotalBalance();

		System.out.println("Total Balance: " + actualTotal);

		Assert.assertEquals(actualTotal, "$515.50");
		
		
		overview.clickAccountNumber();

		System.out.println("Current URL: " + getDriver().getCurrentUrl());

		Assert.assertTrue(
		    getDriver().getCurrentUrl().contains("activity.htm"),
		    "Account Activity page is not displayed"
		);
		AccountActivityPage activity =
		        new AccountActivityPage(getDriver());
		// Create AccountActivityPage object
		

		// Call AccountActivityPage methods
		String actualNumber = activity.getAccountNumber();

		String actualType = activity.getAccountType();

		String actualBalance1 = activity.getAccountBalance();

		// Print values
		System.out.println("Account Number: " + actualNumber);
		System.out.println("Account Type: " + actualType);
		System.out.println("Account Balance: " + actualBalance);

		// Assertions
		Assert.assertEquals(actualNumber, "30882");
		Assert.assertEquals(actualType, "CHECKING");
		Assert.assertEquals(actualBalance, "$515.50");
		
	
		
	 }

}
