package com.vtiger.comcast.OrganisationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.GenericLib.BaseClass;
import com.crm.GenericLib.Excelutilities;
import com.crm.GenericLib.Fileutilities;
import com.crm.GenericLib.JavaUtility;
import com.crm.GenericLib.WebdriverUtilities;
import com.crm.Pom.pages.CreateOrganisationPage;
import com.crm.Pom.pages.CreateOrganisationinfopage;
import com.crm.Pom.pages.Homepage;
import com.crm.Pom.pages.Loginpage;
import com.crm.Pom.pages.OrganisationPage;



public class CreateOrganisationTest extends BaseClass {
	
	
	private static final String[] regressionTest = null;


	@Test(groups="smokeTest")
	public void createOrganisation() throws Throwable
	{	
		
    
    // acess random number form java utilities
	int ran = jlib.getRandomNumber();
	
	/**
	 * Access the properties file
	 * browser
	 * url
	 * username
	 * password
	 */
	
	//acess the excel data
	String ORGNAME = elib.getDataFromExcel("Practice",1, 0)+ran;
		
	//navigate to homepage
	Homepage hp= new Homepage(driver);
	hp.getOrganizationEdt().click();
	
	//navigate to organisation
	OrganisationPage op1= new OrganisationPage(driver);
	op1.getOrgPlusicon().click();
	
	//create the organatisation

	CreateOrganisationPage cop1= new CreateOrganisationPage(driver);
	cop1.createOrganisationPage(ORGNAME);
	
	
	//verify
	 CreateOrganisationinfopage cip= new  CreateOrganisationinfopage(driver);
	String Header = cip.getSucesstitle().getText();
	Assert.assertTrue(Header.contains(ORGNAME));
	
	
	
	
	}
	

   @Test(groups="regressionTest")
   public void createOrganisationwithIndustry() throws Throwable
   {
	  
		/**
	 * Get random numbers
	 */
	int ran = jlib.getRandomNumber();

	
	/**
	 * GET data from excel data
	 * @orgne
	 * CONTACTNAME
	 * INDUSTRY
	 * TYPE
	 */
	
	String ORGNAME = elib.getDataFromExcel("Sheet1", 1, 0)+ran;
	
	String INDUSTRY = elib.getDataFromExcel("Sheet1", 1, 2);
	String TYPE = elib.getDataFromExcel("Sheet1", 2, 3);


/**
 * cretae for homepage
 * click on orgnisation module
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
/**
 * create organization page
 * pass-orgnisation name
 * select industry
 * select Engineering from dropdown
 * select type 
 * select Customer form dropdown
 * 
 */

CreateOrganisationPage cop= new CreateOrganisationPage(driver);

cop.createOrganisationwithIndus(ORGNAME);
WebElement org = cop.getOrgname();
Assert.assertNotNull(org);
cop.saveorg();


/*WebElement Indus = cop.getIndustry();
wlib.select(Indus, 11);


WebElement Typ = cop.getType();

wlib.select(Typ, 3);*/

/**
 * create object to CreateOrganisationinfopage
 * Explicit wait
 * Gettitle
 * 
 */
CreateOrganisationinfopage coip= new CreateOrganisationinfopage(driver);
wlib.waitForElementToBeClickable(driver, coip.getSucesstitle());

String Header1=coip.getSucesstitle().getText();

Assert.assertTrue(Header1.contains(ORGNAME));

/*if(Header.contains(ORGNAME))
{
	System.out.println("passed");
}
else
{
System.out.println("fail");*/






}
}