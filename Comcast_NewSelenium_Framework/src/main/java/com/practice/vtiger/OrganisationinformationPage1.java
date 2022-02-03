package com.practice.vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationinformationPage1 {

	public OrganisationinformationPage1(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
     private WebElement InofPage;

	public WebElement getInofPage() {
		return InofPage;
	}
	
	
	
	
	
}
