package com.com.comcast.Org.Test.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PropertyFile {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileInputStream fs= new FileInputStream("./data/data1.properties.txt");
		Properties po= new Properties();
		po.load(fs);
		
		String URL =po.getProperty("url");
		String USERNAME=po.getProperty("username");
		String PASSWORD=po.getProperty("password");
		String BROWSER=po.getProperty("browser");
		

		FileInputStream fs1= new FileInputStream("./Exceldata2.xlsx");
	    Workbook wb = WorkbookFactory.create(fs1);
	   String orgname = wb.getSheet("Sheet1").getRow(1)
	   .getCell(0).getStringCellValue();
	    
	    
	    WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(orgname );
	
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	/*driver.findElement(By.name("website")).sendKeys(WEBSITE);
	driver.findElement(By.name("tickersymbol")).sendKeys(Ticket);
	driver.findElement(By.xpath("//img[@alt='Select']")).click();
	driver.findElement(By.id("search_txt")).sendKeys("vitiger");
	driver.findElement(By.name("search")).click();
	driver.findElement(By.id("1")).click();
	driver.findElement(By.id("employees")).sendKeys(EMPLOYEES);
	
	
	*/
	String actual = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	
	if(actual.contains(orgname))
	{
		System.out.println("organaisation created sucessfully");
	}
	else
	{
		System.out.println("organisation creation failed");
	}
	
	Actions act= new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	
	
	 
	
	Thread.sleep(2000);
	driver.close();
	
	/*WebDriver driver =null;
	if(BROWSER.equals("chrome"))
	{
	driver=new ChromeDriver();
    }
else if(BROWSER.equals("firefox"))
 	{
	driver=new FirefoxDriver();
    }
else if(BROWSER.equals("IE"))
    {
	driver= new InternetExplorerDriver();*/
	}
	

	




	}


