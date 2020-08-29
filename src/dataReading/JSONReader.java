package dataReading;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import objectIdentifier.ObjectDriver;

public class JSONReader {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub

		//https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple/1.1.1
		//https://mvnrepository.com/artifact/org.json/json/20180813 : click on bundle
		JSONParser jsonParser = new JSONParser();
		Object obj = jsonParser.parse(new FileReader(System.getProperty("user.dir")+"/resources/LoginLocator.json"));
		
		JSONObject jsonObject = (JSONObject) obj;
		
		String locatorname = "submitButton";
		String locatorType="xpath";
		JSONObject locatorTypes = (JSONObject) jsonObject.get(locatorType);
		
		//get the Text
		System.out.println(locatorTypes.get(locatorname).toString());
		
		uiLocator("frameworkType", "css");
		
		ObjectDriver objectDriver = new ObjectDriver("LoginLocator");
		
		objectDriver.uiElement("css", "frameworkType", new String[]{"frameworkType","select","value"});
	}
	
	
	public static String uiLocator(String locatorName,String locatorType) {
		String locator = null;
		try {
			JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(new FileReader(System.getProperty("user.dir")+"/resources/LoginLocator.json"));
			JSONObject jsonObject = (JSONObject) obj;
			org.json.JSONObject jsonLocatorType = new org.json.JSONObject(jsonObject.toString());
			System.out.println(jsonLocatorType.toString());
			System.out.println(String.format((jsonLocatorType.getJSONObject(locatorType).getString(locatorName)), "frameworkType","select","value"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locator;
	}
}
