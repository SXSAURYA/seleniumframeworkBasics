package objectRepository;

import org.openqa.selenium.By;

public class DemoObjects {

	public static By frameworkTextBox = By.cssSelector("#automationsdsdsd");
	
	public static By fieldTextBox(String attribute) {
		return By.cssSelector("textarea[name='"+attribute+"'],input[name='"+attribute+"']");
	}
	
	public static By jsonCheckBox = By.cssSelector("input[type='checkbox'][name='JSON']");
	
	public static By submitButton = By.tagName("button");
	
	public static By selectDropdown = By.id("automationtype");
	
	public static By demoLink1 = By.xpath("//a[text()='Demo1']");
	
	public static By scrollToTopButton = By.cssSelector(".search-searchProductsContainer div.scrollToTop-button");
	
	public static By pTagName = By.tagName("p");
	
	public static By frameworkNameTextBox = By.cssSelector("input[id='automation']");
	
}
