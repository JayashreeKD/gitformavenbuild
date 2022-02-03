package com.crm.GenericLib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListImpClass implements ITestListener{
	
	public void onTestFailure(ITestResult  result) {
		// TODO Auto-generated method stub
		String TestName = result.getMethod().getMethodName();
		System.out.println(TestName +"=====execute=====am Listening");
		
		EventFiringWebDriver eDriver= new EventFiringWebDriver(BaseClass.sdriver);
		File src = eDriver.getScreenshotAs(OutputType.FILE);
	
		File dest= new File("./Screenshot/"+TestName+".png");
		try {
		FileUtils.copyFile(src, dest);
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();	
	}
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
}
/*public void onTestFailure(ITestResult result)
	{
		
		String TestName = result.getMethod().getMethodName();
		System.out.println(TestName +"=====execute=====am Listening");
		
		EventFiringWebDriver eDriver= new EventFiringWebDriver(BaseClass.sdriver);
		File src = eDriver.getScreenshotAs(OutputType.FILE);
	
		File dest= new File("./Screenshot/"+TestName+".png");
		try {
		FileUtils.copyFile(src, dest);
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}*/



