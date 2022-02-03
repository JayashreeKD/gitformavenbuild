package com.practice.vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

public class CreatenewOrganisationPage1 {
	
	WebElement driver;
	public CreatenewOrganisationPage1(WebDriver driver)
	{
PageFactory.initElements(driver, this);
}

@FindBy(name="accountname")
private WebElement AccountNM;

@FindBy(name="industry")
private WebElement Industrydrop;

@FindBy(name="accounttype")
private WebElement Type;


@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement SaveClcik;
public WebElement getSaveClcik() {
	return SaveClcik;
}

/**
 * getter 
 * @return
 */
public WebElement getAccountNM() {
	return AccountNM;
}

public WebElement getIndustrydrop() {
	return Industrydrop;
}

public WebElement getType() {
	return Type;
}

public void SendOrgnName(String ON)
{
	AccountNM.sendKeys(ON);
			
}
}