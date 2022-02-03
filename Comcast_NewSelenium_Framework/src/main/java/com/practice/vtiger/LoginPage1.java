package com.practice.vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {
	
	
	public LoginPage1(WebDriver driver)
	{
PageFactory.initElements(driver, this);
}

@FindBy(name="user_name")
private WebElement UserNameEdt;
	

@FindBy(name="user_password")
private WebElement PasswordEdt;


@FindBy(id="submitButton")
private WebElement ClickSubmit;


public WebElement getUserNameEdt() {
	return UserNameEdt;
}


public WebElement getPasswordEdt() {
	return PasswordEdt;
}


public WebElement getClickSubmit() {
	return ClickSubmit;
}

public void LoginCredentials(String UN, String Pw)
{

	UserNameEdt.sendKeys(UN);
	PasswordEdt.sendKeys(Pw);
	ClickSubmit.click();
}
}