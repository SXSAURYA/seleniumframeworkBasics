package objectRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Ullas
 * @description: This class will work only when we have jQuery is active
 * 
 */
public class CSSSelectors {

	/**
	 * @author Ullas
	 * @description: This function will give capability to extend the capability
	 *               contains function
	 * @example : how : locator : tagName:contains({text}) i.e. label:contains(First
	 *          name)
	 * 
	 */
	public static By cssContainingText(String locator) {
		return new By() {
			@Override
			public List<WebElement> findElements(SearchContext arg0) {
				System.out.println("Using Locator::::" + locator);
				List<WebElement> elements = (List<WebElement>) ((JavascriptExecutor) (arg0))
						.executeScript("return jQuery.find('" + locator + "');");
				return elements;
			}
		};
	}

	/**
	 *
	 * @author: Ullas
	 * @description : this method will get the Following sibling of sent locator
	 * @example : locator we need to Syntax like
	 * 
	 *          tagNameUsed::following-sibling::tagNameRequired label:contains(First
	 *          name)::following-sibling::input label:contains(First
	 *          name)::previous-sibling::input different relator 1. parent 2.
	 *          following-siblings 3. previous-siblings 4. ancestor //TODO: Need to
	 *          work on this
	 * 
	 * 
	 */
	public static By cssSiblings(String locator) {
		String parent = locator.split("::")[0];
		String script = locator.toLowerCase().contains("following")
				? "var parent=jQuery.find('" + parent + "'); return parent[0].nextElementSibling;"
				: "var parent=jQuery.find('" + parent + "');return parent[0].previousElementSibling;";
		System.out.println(script);
		return new By() {

			@Override
			public List<WebElement> findElements(SearchContext arg0) {
				// TODO Auto-generated method stub
				List<WebElement> elements = new ArrayList<WebElement>(
						Arrays.asList((WebElement) ((JavascriptExecutor) (arg0)).executeScript(script)));
				return elements;
			}
		};
	}

	/**
	 * @Send need to pass the locator in locator:nth(index) i.e :
	 *       label:contains(FirstName):nth(1), here 1 is index
	 */
	public static By cssSelectViaIndex(String locator) {
		System.out.println("jQuery.find('" + locator + "')");
		System.out.println("var allel = jQuery.find('" + locator + "'); return allel[0];");
		return new By() {

			@Override
			public List<WebElement> findElements(SearchContext arg0) {
				// TODO Auto-generated method stub
				List<WebElement> elements = new ArrayList<WebElement>(
						Arrays.asList((WebElement) ((JavascriptExecutor) (arg0))
								.executeScript("var allel = jQuery.find('" + locator + "'); return allel[0];")));
				return elements;
			}
		};
	}

	public static void highlightElement(By locator, WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px dashed red'",
				driver.findElement(locator));
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}

		((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", driver.findElement(locator));
	}
}
