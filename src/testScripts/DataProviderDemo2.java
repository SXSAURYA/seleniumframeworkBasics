package testScripts;

import org.testng.annotations.DataProvider;

public class DataProviderDemo2 {
	
	@DataProvider(name="getIntData")
	public static Object[][] intData(){
		return new Object[][] {{1,true},{2,true}};
	}
	
	
}
