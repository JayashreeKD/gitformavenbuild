package com.vtiger.comcast.OrganisationTest;

/*import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLib.BaseClass;
import com.crm.GenericLib.Excelutilities;
import com.crm.Pom.pages.CreateOrganisationPage;
import com.crm.Pom.pages.Homepage;
import com.crm.Pom.pages.OrganisationPage;

public class Dataproviderorg extends BaseClass {

	@Test (dataProvider="getData")
	public void createOrganisation(String Orgname, String Lastname) throws Throwable
	{	
		
		
	System.out.println("orgname"+Orgname+"and"+Lastname);
	
		
	
    
    // acess random number form java utilities
	int ran = jlib.getRandomNumber();
	
	/**
	 * Access the properties file
	 * browser
	 * url
	 * username
	 * password
	 */
/*	
	//acess the excel data
	String ORGNAME = elib.getDataFromExcel("Practice",1, 0)+ran;
		
	//navigate to homepage
	Homepage hp= new Homepage(driver);
	hp.getOrganizationEdt().click();
	
	//navigate to organisation
	OrganisationPage op1= new OrganisationPage(driver);
	op1.getOrgPlusicon().click();
	
	CreateOrganisationPage cop1= new CreateOrganisationPage(driver);
	cop1.createOrganisationPage(obj);
	
	}	
	
	*/
	/*@DataProvider
	public Object[][] getData() throws Throwable
	{
		
		
		Excelutilities eu= new Excelutilities();
		Object obj[][]=new Object[4][2];
	    obj[1][0]=eu.getDataFromExcel("Practice", 1, 0);
	    obj[1][1]=eu.getDataFromExcel("Practice", 1, 1);
	     
	    obj[2][0]=eu.getDataFromExcel("Practice", 2, 0);
	    obj[2][1]= eu.getDataFromExcel("Practice", 2,1 );
	    
	    obj[3][0]=eu.getDataFromExcel("Practice", 3, 0);
	    obj[3][1]=eu.getDataFromExcel("Practice", 3, 1);
	    
	    obj[4][0]=eu.getDataFromExcel("Practice", 4, 0);
	    obj[4][1]=eu.getDataFromExcel("Practice", 4, 1);

	    
	    		return obj;

}
} 
*/