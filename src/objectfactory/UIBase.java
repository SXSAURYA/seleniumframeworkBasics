package objectfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class UIBase {

	public UIBase(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 90), this);
	}

}
