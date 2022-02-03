package com.vtiger.comcast.OrganisationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.GenericLib.Excelutilities;
import com.crm.GenericLib.Fileutilities;
import com.crm.GenericLib.JavaUtility;
import com.crm.GenericLib.WebdriverUtilities;
import com.crm.Pom.pages.CreateOrganisationPage;
import com.crm.Pom.pages.CreateOrganisationinfopage;
import com.crm.Pom.pages.Homepage;
import com.crm.Pom.pages.Loginpage;
import com.crm.Pom.pages.OrganisationPage;

public class CreateOrganisationwithIndustryTest {

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
		
		/**
		 * GET data from excel data
		 * @orgne
		 * CONTACTNAME
		 * INDUSTRY
		 * TYPE
		 */
		
		String ORGNAME = elib.getDataFromExcel("Sheet1", 1, 0)+ran;
		String CONTACTNAME = elib.getDataFromExcel("Sheet1", 1, 1)+ran;
		String INDUSTRY = elib.getDataFromExcel("Sheet1", 1, 2);
		String TYPE = elib.getDataFromExcel("Sheet1", 2, 3);
		
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
	//cop.createOrganisationPage(ORGNAME);
	cop.createOrganisationwithIndus(ORGNAME);
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
	 * close driver
	 */
	
	hp.home(driver);
	driver.quit();
}
}