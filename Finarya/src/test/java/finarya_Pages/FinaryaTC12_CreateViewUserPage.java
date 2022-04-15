package finarya_Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.csipl.finarya.properties.propertiesHandler;

public class FinaryaTC12_CreateViewUserPage {
	public propertiesHandler prop = new propertiesHandler();
	WebDriver driver;
	Finarya_AdministrationModule mainmodule;
	public static final String PROPERTY_FILE = "TC12_CreateViewUser.properties";

	public FinaryaTC12_CreateViewUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loadpropertiesfile() {
		prop.loadProperties(PROPERTY_FILE);
	}

	// Create User Page
	@FindBy(how = How.XPATH, using = "//*[@id='myUserId']")
	WebElement LoginIDTextBox;
	@FindBy(how = How.XPATH, using = "//*[@id='userFullName']")
	WebElement UserFullNameTextBox;
	@FindBy(how = How.XPATH, using = "//*[@id='password']")
	WebElement PassTextBox;
	@FindBy(how = How.XPATH, using = "//*[@id='email']")
	WebElement EmailTextBox;
	@FindBy(how = How.XPATH, using = "//*[@id='create_user_panel']/div/div[5]/div/span/span[1]/span")
	WebElement DepartmentDropDown;
	@FindBy(how = How.XPATH, using = "//input[@class='select2-search__field']")
	WebElement DropdownSearchBox;
	// List Of Element
	@FindBy(how = How.ID, using = "select2-departmentName-results")
	List<WebElement> autoSuggest;
	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/div[2]/div/button[2]")
	WebElement NextButton;
//Assign Role

	public void clickoncreateuser() throws Exception {
		mainmodule = new Finarya_AdministrationModule(driver);
		Thread.sleep(1400);
		mainmodule.Administration.click();
		mainmodule.UserManagement.click();
		mainmodule.CreateUser.click();
		Reporter.log(
				"System will open Create User page with tabs Create User Assign Role" + " " + driver.getCurrentUrl());
	}

	public void loginIDTextBox(String LoginID) {
		LoginIDTextBox.clear();
		LoginIDTextBox.sendKeys(LoginID);
	}

	public void verifyfullnametextbox() {
		UserFullNameTextBox.clear();
		UserFullNameTextBox.sendKeys("ASSDuiouoiRT");
		// Retrieve typed value
		String typedValue = UserFullNameTextBox.getAttribute("value");
		// Get the length of typed value
		int size = typedValue.length();
		System.out.println("Size Of Attribute" + size);
		if (size == 0) {
			Reporter.log("Alphabets are not allowed.");
			System.out.println("Alphabets are not allowed.");
		} else {
			Reporter.log("System should allow only Alpha numeric values only to be entered ");
			System.out.println("System should allow only Alpha numeric values only to be entered ");

		}
	}

	public void verifyfullnametextbox1() {
		UserFullNameTextBox.clear();
		UserFullNameTextBox.sendKeys("123456789");
		// Retrieve typed value
		String typedValue = UserFullNameTextBox.getAttribute("value");
		// Get the length of typed value
		int size = typedValue.length();
		System.out.println("Size Of Attribute" + size);
		if (size == 0) {
			Reporter.log("Numbers are not allowed.");
			System.out.println("Numbers are not allowed.");
		} else {
			Reporter.log("should allow only Alpha numeric values ");
			System.out.println(" should allow only Alpha numeric values");

		}

	}

	public void userFullNameTextBox(String userFullName) {
		UserFullNameTextBox.clear();
		UserFullNameTextBox.sendKeys(userFullName);

	}

	public void passTextBox(String Password) {
		PassTextBox.clear();
		PassTextBox.sendKeys(Password);
	}

	public void emailTextBox(String Email) {
		EmailTextBox.clear();
		EmailTextBox.sendKeys(Email);
	}

	public void departmentDropDown() {
		DepartmentDropDown.click();

	}

	public void searchDropDown(String Department) {
		DropdownSearchBox.click();
		DropdownSearchBox.sendKeys(Department);

	}

	public void dropdownvalue() throws Exception {
		Thread.sleep(3000);
		// print the auto suggest
		for (WebElement a : autoSuggest) {
			System.out.println("Values are = " + a.getText());
			Thread.sleep(1000);
			String p = a.getText();
			if (p.equalsIgnoreCase("department"))
				;
			a.click();
			Thread.sleep(3000);
			break;
		}
	}

	public void clickonNextButton() {
		NextButton.click();
	}
}
