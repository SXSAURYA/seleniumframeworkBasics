package testScripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGDemo2 {
	@Test(enabled=false)
	public void f4() {
		Reporter.log("In f4 method.....", true);
	}

	//How we can do perfomance testing using testNG
	//Volume/ Load Test
	@Test(invocationCount=20,threadPoolSize=4)
	public void f5() {
		Reporter.log("In f5 method.....",true);
	}

	@Test
	public void f6() {
		Reporter.log("In f6 method.....",true);
	}

	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("In Before Method.....",true);
	}

	@AfterMethod
	public void afterMethod() {
		Reporter.log("In After Method.....",true);
	}

	@BeforeClass
	public void beforeClass() {
		Reporter.log("In Before Class.....",true);
	}

	@AfterClass
	public void afterClass() {
		Reporter.log("In After Class.....",true);
		
	}

	@BeforeTest
	public void beforeTest() {
		Reporter.log("In Before Test.....",true);
	}

	@AfterTest
	public void afterTest() {
		Reporter.log("In After Test.....",true);
	}

	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("In Before Suite .....",true);
	}

	@AfterSuite
	public void afterSuite() {
		Reporter.log("In After Suite .....",true);
	}

}
