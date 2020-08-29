package objectfactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends UIBase{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="#create-account_form div.form-group input")
	public WebElement emailAdd;
	
	@FindAll(value = { @FindBy (css="#create-account_form div.form-group input")})
	public List<WebElement> lst_we;
	
	
}
