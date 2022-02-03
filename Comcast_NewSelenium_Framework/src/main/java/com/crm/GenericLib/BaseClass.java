package com.crm.GenericLib;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Parameters;

import com.crm.Pom.pages.Homepage;
import com.crm.Pom.pages.Loginpage;

public class BaseClass {
		public WebDriver driver;
		public static WebDriver sdriver;
		
	//Object creation for lib
	
	public Fileutilities flib= new Fileutilities();
	public Excelutilities elib= new Excelutilities();
	public JavaUtility jlib= new JavaUtility();
	public WebdriverUtilities wlib= new WebdriverUtilities();
	
	@BeforeSuite (groups= {"smokeTest","regressionTest"})
	public void ConfigBS()
	{
System.out.println("============connect to database===========");


    }
//@Parameters("browser")
@BeforeClass(groups= {"smokeTest","regressionTest"})
public void ConfigBC() throws IOException
{
	System.out.println("==============launch the browser=================");
	String BROWSER = flib.readDatafromPropertyfile("browser");
	String URL = flib.readDatafromPropertyfile("url");
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
	
		driver= new ChromeDriver();
	
}

	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		driver= new FirefoxDriver();
		
	}
    
	wlib.maximizeWindow(driver);
	wlib.waitForpageLoad(driver);


	driver.get(URL);
	sdriver=driver;
}

@BeforeMethod(groups= {"smokeTest","regressionTest"})
public void configBM() throws IOException
{
	String BROWSER = flib.readDatafromPropertyfile("browser");
	String URL = flib.readDatafromPropertyfile("url");
	String PASSWORD = flib.readDatafromPropertyfile("password");
	String USERNAME = flib.readDatafromPropertyfile("username");


	//navigate to loginpage
	Loginpage lp= new Loginpage(driver);
	lp.login(USERNAME, PASSWORD);
}

@AfterMethod(groups= {"smokeTest","regressionTest"})
public void configAM()
{
	//logout}}
	Homepage hp= new Homepage(driver);
	hp.home(driver);
}
@AfterClass(groups= {"smokeTest","regressionTest"})
public void configAC()
{

System.out.println("===================close=============");
driver.quit();

}

@AfterSuite(groups= {"smokeTest","regressionTest"})
public void configAS()
{
	System.out.println("========close database======");
}
	
	}
