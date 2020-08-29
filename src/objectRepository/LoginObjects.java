package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginObjects extends By{
 
	private static String locator;
	private static By by;
	//xpath 
	//css ==> try to add css
	//id tagName \
	
	//usernameTextBox=
	
	
	//FindBy ==> WebElement
	//By ==> Locator 
	
	//findElement : 
	public static By LoginButton = By.xpath("//button");
	
	
	public static By usernameTextBox() {
		return By.xpath("//input[name='email']");
	}
	
	
	public static By textBoxes(String labelName) {
		return By.xpath("//label[text()='"+labelName+"']//following-sibling::div//input");
	}
	
	public static By passwordTextBox() {
		return By.xpath("//input[name='pass']");
	}
	
	public static By loginButton() {
		return By.xpath("//input[name='pass']");
	}


	@Override
	public List<WebElement> findElements(SearchContext arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
