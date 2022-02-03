package com.crm.Pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLib.WebdriverUtilities;

public class CreateOrganisationPage extends WebdriverUtilities{
	
	
	
	public CreateOrganisationPage(WebDriver driver) {
		
		
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgname;


	@FindBy(name="industry")
	private WebElement Industry;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	@FindBy(xpath="//select[@name='accounttype']")
    private WebElement type;
	
	
	public WebElement getOrgname() {
		return orgname;
	}


	public WebElement getSavebutton() {
		return savebutton;
	}


	public WebElement getIndustry() {
		return Industry;
	}


	public WebElement getType() {
		return type;
	}


	public void createOrganisationPage(String ORGNAME)
	{
		
		orgname.sendKeys(ORGNAME);
		savebutton.click();
		
		
	}
	
	public void createOrganisationwithIndus(String ORGNAME)
	{
	
		orgname.sendKeys(ORGNAME);
		WebElement Indus = getIndustry();
		select("Engineering", Indus);
		
		
		
		WebElement Type = getType();
		
		select("Customer", Type);
		
		
		

}
	
	public void datacreateOrganisationwithIndus(String ORGNAME)
	{
	
		orgname.sendKeys(ORGNAME);
		WebElement Indus = getIndustry();
		select("Engineering", Indus);
		
		
		
		WebElement Type = getType();
		
		select("Customer", Type);
		
		
		

}

	public void saveorg()
	{
		savebutton.click();
}
}
