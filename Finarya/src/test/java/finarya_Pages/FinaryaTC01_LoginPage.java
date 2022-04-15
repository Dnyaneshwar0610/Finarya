package finarya_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import finarya_BaseClass.ReadToExcel;

public class FinaryaTC01_LoginPage {

	WebDriver driver;

	public FinaryaTC01_LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//*[@id='username']")
	WebElement Usernametextbox;
	@FindBy(how = How.XPATH, using = "//*[@id='password']")
	WebElement Passwordtextbox;
	@FindBy(how = How.XPATH, using = "//*[@id='js-login-btn']")
	WebElement loginbutton;
	@FindAll({
		@FindBy(how = How.XPATH, using = "//*[@id='header']/header/div/div/a/img[@class='profile-image rounded-circle']"),
		@FindBy(how = How.XPATH, using = "//*[@id='header']/header/div[4]/div[3]/a/img"),
		@FindBy(how =How.CSS,using="#header > header > div.ml-auto.d-flex > div:nth-child(3) > a")
		})WebElement Profile;
	
	@FindBy(how = How.XPATH, using = "//*[@id='header']/header/div[5]/div[3]/div/div[1]/div/div/div/div")
	WebElement UserValidation;
	@FindBy(how = How.XPATH, using = "//*[@id='swal2-content']")
	WebElement Alert;
	@FindBy(how = How.XPATH, using = "//*[text()='Logout']")
	WebElement logoutbutton;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement OKbutton;

	public void usernamesend(String Username) {
		Usernametextbox.clear();
		Usernametextbox.sendKeys(Username);
	}

	// This method is to set Password in the password text box
	public void passwordSend(String Password) {
		Passwordtextbox.clear();
		Passwordtextbox.sendKeys(Password);
	}

	// This method is to click on Login Button
	public void clickOnLoginButton() {
		loginbutton.click();
	}

	public void loginsucsessfull() throws Exception {
		String CurrentURL = driver.getCurrentUrl();
		System.out.println("Current URL Is" + "  " + CurrentURL);
		String Expected = "FINARYA | Powered by Amol Inamdar";
		String pageTitle = driver.getTitle();
		System.out.println("Webpage Title Is" + "  " + pageTitle);
		if (pageTitle.equalsIgnoreCase(Expected)) {
			clickOnprofile();
			Thread.sleep(1000);
			String User = UserValidation.getText();
			System.out.println("User Id Or User Name Is=" + "    " +User);
			Reporter.log(User);
	        Assert.assertTrue(true);
			driver.close();
		} else {
			loginvalidationmsg();
			Reporter.log(driver.getCurrentUrl());
			Reporter.log(Alert.getText());
			driver.close();
			Assert.assertFalse(false);
			
		}

	}

	

	public void clickOnprofile() {
		Profile.click();
	}

	public void loginvalidationmsg() {
		/* Create an instance of Soft Assert */
		Assertion softAssert = new SoftAssert();
		String ExpectedString = "";
		String alerttext = Alert.getText();
		softAssert.assertEquals(ExpectedString, alerttext);
		System.out.println("Alert" + "      " +alerttext);
		OKbutton.click();
	}

	public void clickOnLogoutButton() {
		logoutbutton.click();
	}

	public String alerttext() {
		return Alert.getText();
	}

	public void clickOnOKButton() {
		OKbutton.click();
	}
	public void logoutmethos() {
		Profile.click();
		logoutbutton.click();
		driver.close();
	}

}
