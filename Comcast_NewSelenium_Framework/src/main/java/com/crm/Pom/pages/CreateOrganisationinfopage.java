package com.crm.Pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganisationinfopage {

	
	public CreateOrganisationinfopage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement sucesstitle;

	public WebElement getSucesstitle() {
		return sucesstitle;
	}

	
	
	
	
}
	
	