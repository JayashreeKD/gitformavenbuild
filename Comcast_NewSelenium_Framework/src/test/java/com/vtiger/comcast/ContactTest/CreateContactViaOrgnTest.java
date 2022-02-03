package com.vtiger.comcast.ContactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

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

public class CreateContactViaOrgnTest {
	
	
	public static void main(String[] args) throws Throwable {
		WebDriver driver;
		
		Fileutilities flib= new Fileutilities();
		Excelutilities elib= new Excelutilities();
		JavaUtility jlib= new JavaUtility();
		WebdriverUtilities wlib= new WebdriverUtilities();
		

		/**
		 * Get random numbers
		 */
		int ran = jlib.getRandomNumber();
		/**
		 * 
		 * get the data from property file
		 * @browser
		 * @url
		 * @password
		 * @USERNAME
		 */
		String BROWSER = flib.readDatafromPropertyfile("browser");
		String URL = flib.readDatafromPropertyfile("url");
		String PASSWORD = flib.readDatafromPropertyfile("password");
		String USERNAME = flib.readDatafromPropertyfile("username");
		
		
		String ORGNAME = elib.getDataFromExcel("sheet1", 1, 0)+ran;
		String CONTACTNM = elib.getDataFromExcel("sheet1", 1, 1)+ran;
		/**
		 * 
		 *  for browser
		 */
		
	
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
		
			driver= new ChromeDriver();
		
	}

		else
		{
			driver= new FirefoxDriver();
			
		}
	
	
		/**
		 * open browser
		 * maximize
		 * implicitly wait
		 * URl
		 * @author Jayashree
		 */
		wlib.maximizeWindow(driver);
		wlib.waitForpageLoad(driver);
		driver.get(URL);
		/**
		 * create object for loginpage
		 * username
		 * password
		 
		 */
		
		
		Loginpage lp= new Loginpage(driver);
		lp.login(USERNAME, PASSWORD);
		
	
	

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
		if(Header.contains(ORGNAME))
		{
			System.out.println("passed");
		}
		else
		{
		System.out.println("fail");
		
		
		
		}
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
	
	Assert.assertTrue(Header1.contains(CONTACTNM));
	
	/*if(Header1.contains(CONTACTNM))
	{
	
	System.out.println("pass");
	
	}
	else
	{
		
	System.out.println("fail");	
	}
	*/
	hp.home(driver);
	driver.close();
	
}
	

}
	