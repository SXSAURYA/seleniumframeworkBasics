package testScripts;

import java.util.HashMap;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.TestListeners;
import objectRepository.DemoObjects;
import reusables.UIInteraction;
import setup.DriverManager;

@Listeners({TestListeners.class})

public class SubmitForm {
	static WebDriver driver = null;
	static DriverManager driverManager = new DriverManager();

	
	
	@BeforeTest
	public void runBeforeTest() {
		System.out.println("Run Before Test......");
	}
	
	@AfterTest
	public void runAfterTest() {
		System.out.println("Run After Test......");
	}
	
	@BeforeMethod
	public void runBeforeMethod() {
		driver = driverManager.setUp("chrome");
		
	}
	
	@AfterMethod
	public void runAfterMethod() {
		driverManager.tearDown(driver);
	}
	// Validate all the UI
	@Test
	public static void verifySubmitFormUI() {
		// Validate all the Input TextBox present or not in UI
		try {
			driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
			HashMap<String, String> interactionMap = getUIInteractionMap();
			Iterator<String> attributeKeys = interactionMap.keySet().iterator();
			System.out.println("Started Validation for all Input Text Boxes");

			while (attributeKeys.hasNext()) {
				String attribute = attributeKeys.next();
				UIInteraction.checkElementPresent(driver, DemoObjects.fieldTextBox(attribute),
						attribute + " Input TextBox");
				
				UIInteraction.enterDataInTextBox(driver, interactionMap.get(attribute), DemoObjects.fieldTextBox(attribute), attribute,true);
			}
			Assert.assertEquals(false, true);
			System.out.println("Completed Validation for all Input Text Boxes");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			driverManager.tearDown(driver);
		}
		
	}
	
	@Test(enabled=false)
	public static void verifySubmitFormUISkipped() {
		// Validate all the Input TextBox present or not in UI
		try {
			driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
			HashMap<String, String> interactionMap = getUIInteractionMap();
			Iterator<String> attributeKeys = interactionMap.keySet().iterator();
			System.out.println("Started Validation for all Input Text Boxes");

			while (attributeKeys.hasNext()) {
				String attribute = attributeKeys.next();
				UIInteraction.checkElementPresent(driver, DemoObjects.fieldTextBox(attribute),
						attribute + " Input TextBox");
				
				UIInteraction.enterDataInTextBox(driver, interactionMap.get(attribute), DemoObjects.fieldTextBox(attribute), attribute,true);
			}
			Assert.assertEquals(false, true);
			System.out.println("Completed Validation for all Input Text Boxes");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			driverManager.tearDown(driver);
		}
		
	}

	@Test
	public static void verifyDemoLinkNavigation() {
		// Validate all the Input TextBox present or not in UI
		try {
			//driver = driverManager.setUp("chrome");
			driver.get("file:///D:/tutor/seleniumBasics/resources/Demo.html");
			UIInteraction.clickElement(driver, DemoObjects.demoLink1, "Demo 1 link");
			WebDriverWait wait = new WebDriverWait(driver, 120);
			//90 : 
			String expectedURL = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";
			
			//Implicit wait & explicit wait ?
			//ExpectedCondition
			
			//findElement and findElements : Implicit 
			
			//String expectedURL = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";
			String actualURL = driver.getCurrentUrl();
			System.out.println("Actual URL::::" + actualURL + " Expected URL:::::::" + expectedURL);
			if (actualURL.equalsIgnoreCase(expectedURL)) {
				System.out.println("Its working as expected");
			} else {
				throw new Exception(actualURL + " is not matching with expected URL " + expectedURL);
			}
		} catch (Exception e) {
			System.out.println("test Script demo link navigation is failing due to " + e.getMessage());
		} finally {
			//driverManager.tearDown(driver);
		}
	}

	
	
	public static void verifyAttributeValidation() {
		// Validate all the Input TextBox present or not in UI
		try {
			driver = driverManager.setUp("chrome");
			driver.get("file:///D:/tutor/seleniumBasics/resources/Demo.html");
			//

			WebElement inputText = driver.findElement(DemoObjects.frameworkNameTextBox);
			
			System.out.println(UIInteraction.getElementAttribute(driver, DemoObjects.frameworkNameTextBox, "value"));
			
			
			System.out.println(UIInteraction.getCSSAttribute(driver, DemoObjects.frameworkNameTextBox, "background-color"));
			
			UIInteraction.enterDataInTextBox(driver, "Nagaraju", DemoObjects.frameworkNameTextBox,"framework Name", true);
			
			System.out.println(UIInteraction.getElementAttribute(driver, DemoObjects.frameworkNameTextBox, "value"));

		} catch (Exception e) {
			System.out.println("Form Submission is not working fine due to " + e.getMessage());
		} finally {
			//driverManager.tearDown(driver);
		}
	}

	// Validate all the UI
	public static void verifySubmitSubmission() {
		// Validate all the Input TextBox present or not in UI
		try {
			driver = driverManager.setUp("chrome");
			driver.get("file:///D:/tutor/seleniumBasics/resources/Demo.html");
			//

			// CheckBox Selection
			// TODO: Write one method to click Radio Button
			UIInteraction.checkElement(driver, DemoObjects.jsonCheckBox, "JSON");

			// Checking whether element is enabled or not
			System.out.println(UIInteraction.isEnabled(driver, DemoObjects.submitButton, "Submit Button"));

			// Selecting option using different mechanism
			// TODO : Re-write the method to select value if the option is not selected
			// already?

			UIInteraction.selectOptionViaIndex(driver, DemoObjects.selectDropdown, "Automation Type", 2);
			UIInteraction.selectOptionViaValue(driver, DemoObjects.selectDropdown, "Automation Type", "Service");
			UIInteraction.selectOptionViaVisibleText(driver, DemoObjects.selectDropdown, "Automation Type", "UI");

			UIInteraction.clickElement(driver, DemoObjects.submitButton, "Submit Button");

			String expectedText = "Congrats you have completed All Webelements Type";
			String actualText = UIInteraction.getElementText(driver, By.tagName("h1")).trim();
			System.out.println("Expected Text:::::::::::::" + expectedText);
			System.out.println("Actual Text:::::::::::::" + actualText);
			boolean formSubmission = actualText.contains(expectedText);
			if (!formSubmission) {
				throw new Exception(actualText + " is not equals to " + expectedText);
			} else {
				System.out.println("Form Submission is working as expected");
			}

		} catch (Exception e) {
			System.out.println("Form Submission is not working fine due to " + e.getMessage());
		} finally {
			//driverManager.tearDown(driver);
		}
	}


	public static HashMap<String, String> getUIInteractionMap() {
		HashMap<String, String> textBoxInteractionMap = new HashMap<String, String>();
		textBoxInteractionMap.put("first_name", "Naga Raju");
		textBoxInteractionMap.put("last_name", "Ramisetty");
		textBoxInteractionMap.put("email", "nagaraju145@gmail.com");
		textBoxInteractionMap.put("phone", "6261087789");
		textBoxInteractionMap.put("address", "Chanda Nagar, Hyderabad");
		textBoxInteractionMap.put("city", "Hyderabad");
		textBoxInteractionMap.put("zip", "500089");
		textBoxInteractionMap.put("website", "www.demoSite.com");
		textBoxInteractionMap.put("comment", "Added Comment for Automation");
		return textBoxInteractionMap;
	}

}
