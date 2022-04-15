package finarya_BaseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseForUserLogin {
	
	
	public WebDriver driver;

	@BeforeMethod
	@Parameters({"CrossBrowserTesting","application_url"})
	public void LaunchBrowser(String CrossBrowserTesting,String application_url ) throws Exception {

		if (CrossBrowserTesting.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(application_url);

		} else if (CrossBrowserTesting.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(application_url);
			driver.findElement(By.xpath("//*[@id='details-button']")).click();
			driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
		} else if (CrossBrowserTesting.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(application_url);

		} else if (CrossBrowserTesting.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get(application_url);
		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");

		}
	}

	
}
