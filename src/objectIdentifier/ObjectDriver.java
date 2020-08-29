package objectIdentifier;

import java.io.FileReader;
import java.util.Arrays;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;

public class ObjectDriver {

	private String fileName;

	public ObjectDriver(String fileName) {
		this.fileName = fileName;
	}

	public By uiElement(String locatorType, String locatorName) {
		By ui = null;
		try {
			JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser
					.parse(new FileReader(System.getProperty("user.dir") + "/resources/" + this.fileName + ".json"));
			JSONObject jsonObject = (JSONObject) obj;
			org.json.JSONObject jsonLocatorType = new org.json.JSONObject(jsonObject.toString());
			System.out.println(jsonLocatorType.toString());
			ui = retrunLocator(locatorType, jsonLocatorType.getString(locatorName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ui;
	}

	public By uiElement(String locatorType, String locatorName, String... args) {
		By ui = null;
		try {
			JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser
					.parse(new FileReader(System.getProperty("user.dir") + "/resources/"+this.fileName+".json"));
			JSONObject jsonObject = (JSONObject) obj;
			org.json.JSONObject jsonLocatorType = new org.json.JSONObject(jsonObject.toString());
			System.out.println(jsonLocatorType.toString());
			StringBuilder sb = new StringBuilder(jsonLocatorType.getJSONObject(locatorType).getString(locatorName));
			int index = 1;
			for (String replacer : args) {
				sb = new StringBuilder(sb.toString().replace("%" + index + "s", replacer));
				index++;
			}
			System.out.println(sb.toString());
			ui = retrunLocator(locatorType, sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ui;
	}

	private By retrunLocator(String locatorType, String locator) {
		By uiLocator = null;
		switch (locatorType.toLowerCase()) {
		case "xpath":
			uiLocator = By.xpath(locator);
			break;
		case "css":
			uiLocator = By.cssSelector(locator);
			break;
		case "linkText":
			uiLocator = By.linkText(locator);
			break;
		case "tagname":
			uiLocator = By.tagName(locator);
			break;
		case "id":
			uiLocator = By.id(locator);
			break;
		case "classname":
			uiLocator = By.className(locator);
			break;
		case "name":
			uiLocator = By.name(locator);
			break;
		case "partiallinkText":
			uiLocator = By.partialLinkText(locator);
			break;
		default:
			System.out.println("Please pass the proper locator out of " + Arrays.asList("xpath", "css", "linkText",
					"tagName", "id", "className", "name", "partialLinkText"));
			break;
		}
		return uiLocator;
	}
}
