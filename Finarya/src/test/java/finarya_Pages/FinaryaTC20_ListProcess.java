package finarya_Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class FinaryaTC20_ListProcess {

	WebDriver driver;
	Finarya_ProcessDocumentationModule mainprodoc;

	public FinaryaTC20_ListProcess(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='csi-dt-process_length']/label/select"),
			@FindBy(how = How.CSS, using = "#csi-dt-process_length > label > select") })
	WebElement selectshowentries;

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='csi-dt-process_length']/label/select"),
			@FindBy(how = How.CSS, using = "#csi-dt-process_length > label > select") })
	List<WebElement> entriesselect;

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='csi-dt-process_info']"),
			@FindBy(how = How.CSS, using = "#csi-dt-process_info") })
	WebElement ListEntriesInfo;

	public void clickonlistprocess() {
		mainprodoc = new Finarya_ProcessDocumentationModule(driver);
		mainprodoc.ProcessDocumentation.click();
		mainprodoc.ProcessLibrary.click();
		mainprodoc.ListProcess.click();
		Reporter.log("System will open page List Process Master with Search Functionality at various levels:-"+driver.getCurrentUrl());
	}

	public void scrolldown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("window.scrollBy(0,700)", "");
		// jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		jse.executeScript("arguments[0].scrollIntoView();", selectshowentries);

	}

	public void showentriesfromlist() throws Exception {

		Select select = new Select(selectshowentries);
		Thread.sleep(1000);
		select.selectByValue("5");
		Thread.sleep(1000);
		Reporter.log("List Value Select 5" + ":-" + ListEntriesInfo.getText());
		scrolldown();
		Thread.sleep(1000);
		select.selectByValue("10");
		Thread.sleep(1000);
		Reporter.log("List Value Select 10" + ":-" + ListEntriesInfo.getText());
		scrolldown();
		Thread.sleep(1000);
		select.selectByValue("25");
		Thread.sleep(1000);
		Reporter.log("List Value Select 25" + ":-" + ListEntriesInfo.getText());
		scrolldown();
		Thread.sleep(1000);
		select.selectByValue("50");
		Thread.sleep(1000);
		Reporter.log("List Value Select 50" + ":-" + ListEntriesInfo.getText());
		scrolldown();
		Thread.sleep(1000);
		select.selectByValue("100");
		Thread.sleep(1000);
		Reporter.log("List Value Select 100" + ":-" + ListEntriesInfo.getText());
		scrolldown();
		Thread.sleep(1000);
		select.selectByValue("10000");
		Thread.sleep(1000);
		Reporter.log("List Value Select 10,000" + ":-" + ListEntriesInfo.getText());
		scrolldown();
		Thread.sleep(1000);
		select.selectByValue("100000");
		Thread.sleep(1000);
		Reporter.log("List Value Select 100000" + ":-" + ListEntriesInfo.getText());

	}

	public void listselectentries() throws Exception {
		// webelement
		Select select = new Select(selectshowentries);
		// list of webelement
		entriesselect = select.getOptions();
		System.out.println(entriesselect.size());

		for (int i = 0; i < entriesselect.size(); i++) {
			scrolldown();
			Thread.sleep(3000);
			select.selectByIndex(i);
			WebElement option = select.getFirstSelectedOption();
			String Selectedvalues = option.getText();
			Thread.sleep(3000);
			Reporter.log("List Value Select:-" + Selectedvalues + "List Info Massage:-" + ListEntriesInfo.getText());
			Thread.sleep(1500);
		}
	}

}
