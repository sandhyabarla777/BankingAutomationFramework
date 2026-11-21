package com.banking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
	WebDriver driver;
	
	By register=By.xpath("//a[text()='Register']");
	By fName=By.id("customer.firstName");
	By lName=By.id("customer.lastName");
	By addressStreet=By.id("customer.address.street");
	By city=By.id("customer.address.city");
	By state=By.id("customer.address.state");
	By zipCode=By.id("customer.address.zipCode");
	By phoneNumber=By.id("customer.phoneNumber");
	By ssn=By.id("customer.ssn");
	By userName=By.id("customer.username");
	By password=By.id("customer.password");
	By confirm=By.id("repeatedPassword");
	By registerClickBtn=By.xpath("//input[@value='Register']");
	By welcomeMessage = By.xpath("//div[@id='rightPanel']//h1");

	public String getWelcomeMessage() {
	    return driver.findElement(welcomeMessage).getText();
	}
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void clickRegister()
	{
		driver.findElement(register).click();
	}
	
	public void enterFname(String firstName)
	{
		driver.findElement(fName).sendKeys(firstName);
	}
	public void enterLname(String lastName)
	{
		driver.findElement(lName).sendKeys(lastName);
	}
	public void enterAddressStreet(String street)
	{
		driver.findElement(addressStreet).sendKeys(street);
	}
	public void enterCity(String cityAddress)
	{
		driver.findElement(city).sendKeys(cityAddress);
	}
	public void enterState(String stateAddress)
	{
		driver.findElement(state).sendKeys(stateAddress);
	}
	public void enterZipCode(String zipCodeAddress)
	{
		driver.findElement(zipCode).sendKeys(zipCodeAddress);
	}
	public void enterPhoneNumber(String mobile)
	{
		driver.findElement(phoneNumber).sendKeys(mobile);
	}
	public void enterSSN(String ssnNumber)
	{
		driver.findElement(ssn).sendKeys(ssnNumber);
	}
	public void enterUserName(String uName)
	{
		driver.findElement(userName).sendKeys(uName);
	}
	public void enterPassword(String paswd)
	{
		driver.findElement(password).sendKeys(paswd);
	}
	public void confirmPass(String repeatPaswd)
	{
		driver.findElement(confirm).sendKeys(repeatPaswd);
	}
	public void clickRegisterButton()
	{
		driver.findElement(registerClickBtn).click();
	}

	
	public void registrationForm(
	        String firstName,
	        String lastName,
	        String street,
	        String cityAddress,
	        String stateAddress,
	        String zip,
	        String mobile,
	        String ssnNumber,
	        String uName,
	        String paswd
	       ) {

	    enterFname(firstName);
	    enterLname(lastName);
	    enterAddressStreet(street);
	    enterCity(cityAddress);
	    enterState(stateAddress);
	    enterZipCode(zip);
	    enterPhoneNumber(mobile);
	    enterSSN(ssnNumber);
	    enterUserName(uName);
	    enterPassword(paswd);
	    confirmPass(paswd);
	   
	
	    clickRegisterButton();
	}

}


