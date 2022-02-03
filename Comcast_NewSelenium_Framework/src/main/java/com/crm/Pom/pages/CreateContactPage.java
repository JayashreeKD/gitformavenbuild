package com.crm.Pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLib.WebdriverUtilities;

public class CreateContactPage extends WebdriverUtilities {
	//private static final CharSequence ORGNAME = null;

	WebDriver driver;
	public CreateContactPage(WebDriver driver)
    {
		this.driver=driver;
		PageFactory.initElements(driver, this);
    }

	@FindBy(name="lastname")
	private WebElement ContactLastname;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement ContactOrgaNameLookUp;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement ConatactSaveBttn;

	public WebElement getConatactSaveBttn() {
		return ConatactSaveBttn;
	}

	public WebElement getContactLastname() {
		return ContactLastname;
	}

	public WebElement getContactOrgaNameLookUp() {
		return ContactOrgaNameLookUp;
	}
	
	public void createContactLastName(String CONTACTLN,String ORGNAME ) throws InterruptedException
	{
		
	    
		ContactLastname.sendKeys(CONTACTLN);
		ContactOrgaNameLookUp.click();
		OrganisationPage op1= new  OrganisationPage(driver);
		WebElement newwin = op1.getOrgnNewWindow();
		
	
		
		
		
       switchToWindow(driver,"Accounts&action");
       
   //	waitForElementToBeClickable(driver, newwin);
       waitForElementVissibleText(driver, newwin);
       op1.getSearchOrgTxtbox().sendKeys(ORGNAME);
       op1.getSearchNowbttn().click();
       driver.findElement(By.xpath("//a[text() ='"+ORGNAME+"']")).click();
      
       
       switchToWindow(driver,"Contacts&action");
       ConatactSaveBttn.click();  
}

	public void createContactLastNameonly(String CONTACTLN)
	{
		ContactLastname.sendKeys(CONTACTLN);
		ConatactSaveBttn.click(); 
    }



}