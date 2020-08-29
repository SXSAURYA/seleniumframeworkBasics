package testScripts;

import java.util.HashMap;

import org.testng.annotations.Test;

public class ElementsInteraction extends CopyBase {

	// Validate all the UI
	@Test
	public static void verifyElementClickable() {
           driver.get("file:///D:/tutor/seleniumBasics/resources/Demo.html");
           System.out.println(driver.getCurrentUrl());
	}
	
	@Test
	public static void elemementHandle() {
           driver.get("https://testng.org/doc/documentation-main.html#native-dependency-injection");
           System.out.println(driver.getCurrentUrl());
	}

	// TODO:
	public static void verifyFormSubmission() {

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
