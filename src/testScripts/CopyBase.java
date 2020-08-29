package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import setup.DriverManager;

public class CopyBase {
	public static WebDriver driver = null;
	public DriverManager driverManager = new DriverManager();

	@BeforeMethod
	public void beforeMethod() {
		driver = driverManager.setUp("chrome");
	}

	@AfterMethod
	public void afterMethod() {
		driverManager.tearDown(driver);
	}

}
