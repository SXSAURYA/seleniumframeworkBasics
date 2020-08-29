package readers;

import java.io.FileReader;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONReader {

	
	public static String getValue(String fileName,String keyName,String locatorType) {
		String locatorValue = null;
		try {
			JSONParser jsonParser = new JSONParser();
			Object object = jsonParser.parse(new FileReader(System.getProperty("user.dir")+"/resources/"+fileName+".json"));
			JSONObject jsonObjectLocatorType = new JSONObject(object.toString());
			System.out.println("Main JSON");
			System.out.println(jsonObjectLocatorType.toString());
			System.out.println("Main JSON");
			System.out.println("Nested JSON");
			JSONObject jsonObject = jsonObjectLocatorType.getJSONObject(locatorType);
			System.out.println("Nested JSON");
			locatorValue = jsonObject.getString(keyName);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return locatorValue;
	}
}
