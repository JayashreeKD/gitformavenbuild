package com.crm.Pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	WebDriver driver;
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organizationEdt;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsEdt;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutIcon;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutclick;
	
	
	public WebElement getOrganizationEdt() {
		return organizationEdt;
	}


	public WebElement getContactsEdt() {
		return contactsEdt;
	}


	public WebElement getsignoutIcon() {
		return signoutIcon;
	}


	public WebElement getSignOutclick() {
		return signOutclick;
	}


	public void home(WebDriver driver)
	{
	
		Actions a= new Actions(driver);
		a.moveToElement(signoutIcon).perform();
		signOutclick.click();	
	
		
	}

}
