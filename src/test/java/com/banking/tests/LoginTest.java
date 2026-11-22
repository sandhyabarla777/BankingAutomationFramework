package com.banking.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.base.BaseTest;
import com.banking.pages.LoginPage;
import com.banking.listeners.RetryAnalyzer;


public class LoginTest extends BaseTest {
	//@Test(retryAnalyzer =RetryAnalyzer.class)
	//@Test(groups = {"smoke", "regression"})
	@Test(groups = {"smoke","regression"}, retryAnalyzer = RetryAnalyzer.class)
	public void verifyLogin()
	{
		//System.out.println("Thread ID: " + Thread.currentThread().getId());
		System.out.println("branch");
		LoginPage loginPage=new LoginPage(getDriver());
		loginPage.loginOperation("sandhya_test_2029" ,"Test@123");
		Assert.assertTrue(getDriver().getCurrentUrl().contains("overview"),"Login was not Successfull");
		
	}
	

}
