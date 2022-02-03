package com.practice.vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage1 {
	
	
	public OrganisationPage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

@FindBy(linkText="Organizations")
private WebElement Orgnmodule1;

@FindBy(xpath="//img[@title='Create Organization...']")
private WebElement OrgPlusClick;

public WebElement getOrgnmodule1() {
	return Orgnmodule1;
}

public WebElement getOrgPlusClick() {
	return OrgPlusClick;
}




}
