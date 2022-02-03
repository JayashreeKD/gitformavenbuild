package com.crm.Pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContatcPage {

	
	public ContatcPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
}

	
	@FindBy(linkText="Contacts")
	private WebElement ContactModule;
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement Contactlookup;

	public WebElement getContactModule() {
		return ContactModule;
	}

	public WebElement getContactlookup() {
		return Contactlookup;
	}
	
	
	
	
	
}