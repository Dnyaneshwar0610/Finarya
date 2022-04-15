package finarya_Tests;

import org.testng.annotations.Test;

import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC06_UploadDepartmentPage;

public class TC06_UploadDepartment extends TestBase{
	@Test(priority=1)
	public void listdepartment() throws Exception {
		FinaryaTC06_UploadDepartmentPage uploaddep= new FinaryaTC06_UploadDepartmentPage(driver);
		uploaddep.clickonuploaddepartment();
		
	}
}
