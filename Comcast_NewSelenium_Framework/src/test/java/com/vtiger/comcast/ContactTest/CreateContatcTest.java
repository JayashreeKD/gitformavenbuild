package com.vtiger.comcast.ContactTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.GenericLib.BaseClass;
import com.crm.GenericLib.Excelutilities;
import com.crm.GenericLib.Fileutilities;
import com.crm.GenericLib.JavaUtility;
import com.crm.GenericLib.WebdriverUtilities;
import com.crm.Pom.pages.ContactInformationPage;
import com.crm.Pom.pages.ContatcPage;
import com.crm.Pom.pages.CreateContactPage;
import com.crm.Pom.pages.CreateOrganisationPage;
import com.crm.Pom.pages.CreateOrganisationinfopage;
import com.crm.Pom.pages.Homepage;
import com.crm.Pom.pages.Loginpage;
import com.crm.Pom.pages.OrganisationPage;

public class CreateContatcTest extends BaseClass {

	@Test(groups="smokeTest", retryAnalyzer=com.crm.GenericLib.RetryImpli.class)
	public void CreateContatc() throws Throwable
	{
			
		/**
		 * Get random numbers
		 */
		int ran = jlib.getRandomNumber();
		
		/**
		 * get data from excel
		 */
		String ORGNAME = elib.getDataFromExcel("sheet1", 1, 0)+ran;
		String CONTACTLN = elib.getDataFromExcel("sheet1", 1, 1)+ran;
		
	
		/**
		 * navigate to homepage
		 * click on Contacts link
		*/
		Homepage hp= new Homepage(driver);
		hp.getContactsEdt().click();
		
		
		/**
		 *click on lookup
		 * 
		 */
		ContatcPage op= new ContatcPage(driver);
		op.getContactlookup().click();
		
		//create contatc page 
		
		CreateContactPage ccp= new CreateContactPage(driver);
		ccp.createContactLastNameonly(CONTACTLN);
		
		
		
		//verify
		ContactInformationPage cip= new ContactInformationPage(driver);
		String Header1 = cip.getContactInformationConfrimation().getText();
		
		Assert.assertTrue(Header1.contains(CONTACTLN));
		
		/*if(Header1.contains(CONTACTLN))
		{
		
		System.out.println("pass");
		
		}
		else
		{
			
		System.out.println("fail");	
		}
			*/
		
	}

@Test(groups="regressionTest")
public void createOrgwithContact() throws Throwable

{	

	/**
	 * Get random numbers
	 */
	int ran = jlib.getRandomNumber();
	
	
	
	String ORGNAME = elib.getDataFromExcel("sheet1", 1, 0)+ran;
	String CONTACTNM = elib.getDataFromExcel("sheet1", 1, 1)+ran;
	


	/**
	 * cretae for homepage
	 * click on orgnisation module
	 * 
	 *
	*/
	Homepage hp= new Homepage(driver);
	hp.getOrganizationEdt().click();
	
	/**
	 *organization page
	 *click on lookup
	 * 
	 */
	OrganisationPage op= new OrganisationPage(driver);
	op.getOrgPlusicon().click();
	
	CreateOrganisationPage cop= new CreateOrganisationPage(driver);
	cop.createOrganisationPage(ORGNAME);
	
	CreateOrganisationinfopage coip= new CreateOrganisationinfopage(driver);
	wlib.waitForElementToBeClickable(driver, coip.getSucesstitle());
	
	
	String Header=coip.getSucesstitle().getText();
	
	Assert.assertTrue(Header.contains(ORGNAME));
	/*if(Header.contains(ORGNAME))
		
	{
		System.out.println("passed");
	}
	else
	{
	System.out.println("fail");
	
	
	
	}*/
	/**
	 * navigate to contatc module
	 * 
	 */
hp.getContactsEdt().click();

ContatcPage cp = new ContatcPage(driver);
cp.getContactlookup().click();


CreateContactPage ccp= new CreateContactPage(driver);
ccp.createContactLastName(CONTACTNM, ORGNAME);

ContactInformationPage cip= new ContactInformationPage(driver);
String Header1 = cip.getContactInformationConfrimation().getText();

if(Header1.contains(CONTACTNM))
{

System.out.println("pass");

}
else
{
	
System.out.println("fail");	
}


}
}


