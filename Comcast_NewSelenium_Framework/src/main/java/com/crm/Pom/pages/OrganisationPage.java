package com.crm.Pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {

	public OrganisationPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
}
	
	@FindBy(linkText="Organizations")
	private WebElement orgnizationEdt;
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement OrgPlusicon;
	
	@FindBy(xpath="//td[@class='moduleName']")
	private WebElement OrgnNewWindow;
	

	@FindBy(xpath="//input[@name='search_text']")
	private WebElement SearchOrgTxtbox;
	
	@FindBy(name="search")
	private WebElement SearchNowbttn;
	
	
	
	

	


	public WebElement getOrgnNewWindow() {
		return OrgnNewWindow;
	}

	public WebElement getSearchOrgTxtbox() {
		return SearchOrgTxtbox;
	}




	public WebElement getSearchNowbttn() {
		return SearchNowbttn;
	}

	
	

	public WebElement getOrgnizationEdt() {
		return orgnizationEdt;
	}

	public WebElement getOrgPlusicon() {
		return OrgPlusicon;
	
	}
	

	public void orgSearchName(String ORGNAME)
	{
		SearchOrgTxtbox.sendKeys(ORGNAME);
		SearchNowbttn.click();
	}
}