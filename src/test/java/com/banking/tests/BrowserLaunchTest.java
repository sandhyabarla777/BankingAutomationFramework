package com.banking.tests;

import org.testng.annotations.Test;

import com.banking.base.BaseTest;

public class BrowserLaunchTest extends BaseTest{
	@Test
	public void browserLaunch()
	{
		System.out.println("Application title:"+getDriver().getTitle());
		System.out.println("Application Url:"+ getDriver().getCurrentUrl());
	}
	

}
