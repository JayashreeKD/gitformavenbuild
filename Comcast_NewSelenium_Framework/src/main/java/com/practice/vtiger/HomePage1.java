package com.practice.vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage1 {
	
	WebDriver driver;
	

	public HomePage1(WebDriver driver) {
	
		
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Organizations")
	private WebElement OrgnPage;
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Sigoutimg;
	
	@FindBy(linkText="Sign Out")
	private WebElement ClickSignout;

	public WebElement getOrgnPage() {
		return OrgnPage;
	}

	public WebElement getSigoutimg() {
		return Sigoutimg;
	}

	public WebElement getClickSignout() {
		return ClickSignout;
	}
	
	
	public void ActiononSignout()
	{
	
	Actions a = new Actions(driver);
	a.moveToElement(Sigoutimg).perform();
	ClickSignout.click();
			
	
}
}