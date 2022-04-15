package finarya_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FinaryaTC06_UploadDepartmentPage {
	
	WebDriver driver;
	Finarya_AdministrationModule mainmodule;

	public FinaryaTC06_UploadDepartmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickonuploaddepartment() {
	    mainmodule=new Finarya_AdministrationModule(driver);
		mainmodule.Profile.click();
		mainmodule.Administration.click();
		mainmodule.Department.click();
		mainmodule.UploadDepartment.click();
		
	}

}
