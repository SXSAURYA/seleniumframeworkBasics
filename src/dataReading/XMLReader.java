package dataReading;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

public class XMLReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String xpathValue = getData("errorMessage", "//LOGIN//BLANK");

		System.out.println(xpathValue);

		String xpathValue1 = getData("errorMessage", "//EXPECTED_TEXT//LOGIN//USERNAME");

		System.out.println(xpathValue1);

	}

	public static String getData(String fileName, String xpath) {
		String sData = null;
		try {
			String FILE_PATH = System.getProperty("user.dir") + "/resources/" + fileName + ".xml";
			InputSource in = new InputSource(FILE_PATH);
			// An XPathFactory instance can be used to create XPath objects.
			/*
			 * public static XPathFactory newInstance()
			 * 
			 * Get a new XPathFactory instance using the default object model,
			 * DEFAULT_OBJECT_MODEL_URI,the W3C DOM.
			 */
			/**
			 * public abstract XPath newXPath() Return a new XPath using the underlying
			 * objectmodel determined when the XPathFactory was instantiated.
			 */
			XPath xp = XPathFactory.newInstance().newXPath();
			// Evaluate an XPath expression in the context of the specified InputSourceand
			// return the result as the specified type.
			sData = (String) xp.evaluate(xpath, in, XPathConstants.STRING);
			//System.out.println(sData);
		} catch (Exception e) {

		}
		return sData;
	}
}
