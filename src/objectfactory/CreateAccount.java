package objectfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {

	WebDriver driver = null;
	
	 public CreateAccount(WebDriver driver) {
		 this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 
	@FindBy(css="#create-account_form div.form-group input")
	public WebElement emailAdd;
	
}
