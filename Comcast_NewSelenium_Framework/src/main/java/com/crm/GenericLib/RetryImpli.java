package com.crm.GenericLib;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpli implements IRetryAnalyzer {


public boolean retry(ITestResult result) {
	int count =0;
	int retry =3;
	
	while(count<retry)
	{
		
		count++;
		return true;
	}
	
	
	
	return false;
}



}
