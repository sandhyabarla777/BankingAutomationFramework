package com.banking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	By username=By.name("username");
	By password=By.name("password");
	By loginButton=By.xpath("//input[@value='Log In']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void enterUserName(String userName)
	{
		driver.findElement(username).sendKeys(userName);
	}
	public void enterPassword(String paswd)
	{
		driver.findElement(password).sendKeys(paswd);
	}
	public void clickLogin()
	{
		driver.findElement(loginButton).click();
	}
	
	public void loginOperation(String userName,String paswd)
	{
		enterUserName(userName);
		enterPassword(paswd);
		clickLogin();
	}

}
