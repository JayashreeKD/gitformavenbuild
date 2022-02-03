package com.com.comcast.Org.Test.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mysql.jdbc.Driver;

public class Testrmg {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException, SQLException {
		
		
	WebDriver driver;	
	FileInputStream fs= new FileInputStream("./Excel1/Fetchproject.xlsx");
	Workbook wb = WorkbookFactory.create(fs);
	Sheet sheet = wb.getSheet("Sheet1");
	String BROWSER = sheet.getRow(1).getCell(0).getStringCellValue();
	      // BROWSER=sheet.getRow(2).getCell(0).getStringCellValue();
	String URL = sheet.getRow(1).getCell(1).getStringCellValue();
	String USERNM = sheet.getRow(1).getCell(2).getStringCellValue();
	String PASS=sheet.getRow(1).getCell(3).getStringCellValue();
	String PROJNM = sheet.getRow(1).getCell(4).getStringCellValue();
	String PROJMAN = sheet.getRow(1).getCell(5).getStringCellValue();
	
	if(BROWSER.equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	else
	{
		driver=new FirefoxDriver();
	}
	driver.get(URL);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.id("usernmae")).sendKeys(USERNM);
	driver.findElement(By.id("inputPassword")).sendKeys(PASS);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	driver.findElement(By.linkText("Projects")).click();
	driver.findElement(By.xpath("//span[text()='Create Project']")).click();
	
	driver.findElement(By.name("projectName")).sendKeys(PROJNM);
	driver.findElement(By.name("createdBy")).sendKeys(PROJMAN);
	driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
	
	
	Thread.sleep(2000);
	driver.close();
	
	
	Driver driverref= new Driver();
	DriverManager.registerDriver(driverref);
	Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects" ,"root", "root");
	
	Statement stat = Conn.createStatement();
	String query = ("Select * from project;");
	
	ResultSet res = stat.executeQuery(query);
	
	while(res.next())
	{
		String match = res.getString(4);
		if(match.equals(PROJNM))
{
	System.out.println("match found ");
}
		
	}
	
	
		
	Conn.close();	

	}
	
}
