package testScripts;

import java.lang.reflect.Method;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGDemo3 {
	
	int i = 0;
	
	public void setI(int i) {
		i = i;
	}
	
	public int getI() {
		return i;
	}
	
	@Test(invocationCount=9,threadPoolSize=3)
	public void invocationCountDemo() {	
		//System.out.println("printing....");
		setI(i++);
		System.out.println(Thread.currentThread().getId());
		//System.out.println(getI());
	}
	
	@Test
	public void getServiceData() {
		System.out.println("Firstly this will execute");
	}
	
	@Test(dependsOnMethods= {"getServiceData"})
	public void validateInUI() {
		System.out.println("It will run after dependOnMethodDemo");
	}
	
	@Test(enabled=true)
	public void disableTestDemo() {
		System.out.println("Printing... disabled.....");
	}
	
	
	@Parameters({"browser","url"})
	@Test
	public void parameterTest(@Optional("firefox") String browser,@Optional("https://google.com") String url) {
		System.out.println("Printing... disabled.....");
		System.out.println("Parameter Browser::::"+browser);
		System.out.println("Parameter url::::"+url);
	}
	
	
	@Test(groups= {"sanity","regression"})
	public void sanityTest() {
	System.out.println("Sanity and regression ");	
	}
	
	@Test(groups= {"smoke"})
	public void smokeTest() {
		System.out.println("Smoke..");
	}
	
	@Test(groups= {"regression"})
	public void regressionTest() {
		System.out.println("regression...");
	}
}
