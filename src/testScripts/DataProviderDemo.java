package testScripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DataProviderDemo {
	
	@Test(dataProvider="getUserData")
	public void dataProviderTest(String username,String password) {
		System.out.println(username+":::"+password);
	}
	
	@DataProvider(name="getUserData")
	public Object[][] getCredentials(){
		Object[][] data = new Object[3][2];
		return new Object[][] {{"nagaraju","jhjhjkh"},{"anirban","sdsds"},{"ullas","sdsdd"}};
	}
	

	
	@DataProvider(name="getuserObjects")
	public Object[][] getCredObject(){
		return new Object[][] {{new UserCredentials("nagaraju","jhjhjkh")},{new UserCredentials("anirban","sdsds")}};
	}
	
	
	@Test(dataProvider="getuserObjects")
	public void dataProviderTestUsingObject(UserCredentials userCredentials) {
		System.out.println(userCredentials.getUsername()+"::::"+userCredentials.getPassword());
	}
	
	
	@Test(dataProvider="getIntData",dataProviderClass=DataProviderDemo2.class)
	public void testEven(int number,boolean expected) {
	  boolean actual = number % 2 == 0 ? true : false;
	  System.out.println("actual:::"+actual);
	  System.out.println("expected:::"+expected);
	  assertEquals(actual, expected,number+" is not as expected");
	}
	
}
