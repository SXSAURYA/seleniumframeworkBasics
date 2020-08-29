package demo;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import testScripts.SubmitForm;
import testScripts.SubmitFormCopied;

public class InvokeDrivers2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//SubmitForm.verifyAttributeValidation();
			
			//https://www.toolsqa.com/handling-alerts-using-selenium-webdriver/ : Alert
			//https://www.naukri.com/ : For Window Handle
			//http://the-internet.herokuapp.com/iframe
			//https://www.seleniumeasy.com/test/javascript-alert-box-demo.html
			SubmitFormCopied.verifyFrameDemo();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		  try {
			Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		// X actions
		// Close browser

	}
	
	public static void waitAngularLoad(WebDriver driver) {
		ExpectedCondition<Boolean> jqueryAction = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver arg0) {
				JavascriptExecutor js = (JavascriptExecutor) arg0;
				String readyState = js.executeScript("return document.readyState").toString();
				System.out.println("####################Document Ready State###################"+readyState);
				System.out.println("Active or not::::"+(Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0"));
				return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
			}
		};
		
		//new WebDriverWait(driver, 90).until(jqueryAction);
	}

}
