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

public class TestNGDemo {
	@Test
	public void f1() {
		Reporter.log("In f2 method.....", true);
	}

	@Test
	public void f2() {
		Reporter.log("In f2 method.....",true);
	}

	@Test
	public void f3() {
		Reporter.log("In f2 method.....",true);
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

}
