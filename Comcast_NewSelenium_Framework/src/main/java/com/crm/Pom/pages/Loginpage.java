package com.crm.Pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
public Loginpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(name="user_name")
	private WebElement username;
	
	@FindBy(name="user_password")
	private WebElement password;
	
	@FindBy(id="submitButton")
	private WebElement submit;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmit() {
		return submit;
	}
	
	public void login(String USERNAME, String PASSWORD)
	{

	username.sendKeys(USERNAME);
	password.sendKeys(PASSWORD);
	submit.click();
	}
}