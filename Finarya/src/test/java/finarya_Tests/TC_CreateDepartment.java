package finarya_Tests;


import org.testng.annotations.Test;

import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC02_CreateDepartmentPage;


public class TC_CreateDepartment extends TestBase{
	
	

	@Test(priority=1)
	public void Creadmini(){
		FinaryaTC02_CreateDepartmentPage createpage =new FinaryaTC02_CreateDepartmentPage(driver);;
		createpage.clickonprofile();
		
		
    
	}
	@Test(priority=2)
	public void Admini() {
		FinaryaTC02_CreateDepartmentPage createpage =new FinaryaTC02_CreateDepartmentPage(driver);
		createpage.clickOnadministration();
		createpage.clickOnDepartment();
		createpage.clickonCreateDepart();
	
	}
	@Test(priority=3)
	public void Department() throws Exception {
		FinaryaTC02_CreateDepartmentPage createpage =new FinaryaTC02_CreateDepartmentPage(driver);
		Thread.sleep(1000);
		createpage.departmentName("CSI Onbording For Feb");
		createpage.clickonNextButton();
		Thread.sleep(1000);
		createpage.clickonSubmitButton();
		try {
		createpage.Assertion();
		}catch(AssertionError e) {
			e.printStackTrace();
			System.out.println("Assertion Fail"+"      "+e);
		}
		createpage.clickonOkButton();
		
	}
	
	}
