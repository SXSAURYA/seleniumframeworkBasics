package demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.CSSSelectors;
import setup.DriverManager;

public class InvokeDrivers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		DriverManager driverManager = new DriverManager();
		// selenium latest feature
		try {
			driver = driverManager.setUp("chrome");
			// http://{username:password}@url
			// http://admin:admin@the-internet.herokuapp.com/basic_auth
			driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
			System.out.println("URL of the Site:::" + driver.getCurrentUrl());
			// get the page title
			System.out.println("Title of the Site::;" + driver.getTitle());
			driver.navigate().refresh();
			Thread.sleep(500);
			driver.navigate().back();
			Thread.sleep(500);
			driver.navigate().forward();
			Thread.sleep(500);
			waitAngularLoad(driver);
			driver.findElement(CSSSelectors.cssContainingText("#email_create")).sendKeys("uchandrakar143@gmail.com");
			driver.findElement(CSSSelectors.cssContainingText("button:contains(Create an account)")).click();
			Thread.sleep(1500);
			waitAngularLoad(driver);
			Thread.sleep(1500);
			CSSSelectors.highlightElement(CSSSelectors.cssSelectViaIndex("label:contains(First name):nth(0)"), driver);
			driver.findElement(CSSSelectors.cssSiblings("label:contains(First name):nth(0)::following-sibling::input"))
					.sendKeys("Ullas");
			Thread.sleep(1500);
			FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(90))
					.pollingEvery(Duration.ofSeconds(10)).ignoreAll(new ArrayList<Class<? extends Throwable>>() {
						{
							add(StaleElementReferenceException.class);
							add(NoSuchElementException.class);
							add(TimeoutException.class);
							add(InvalidElementStateException.class);
							add(WebDriverException.class);
						}
					})
					.withMessage("Message for timeout Exception");
			
			WebElement webElement = fluentWait.until(new Function<WebDriver, WebElement>() {
				@Override
				public WebElement apply(WebDriver driver) {
					// TODO Auto-generated method stub
					return driver.findElement(By.cssSelector(".input"));
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driverManager.tearDown(driver);
		}
		// X actions
		// Close browser

	}

	public static void waitAngularLoad(WebDriver driver) {
		ExpectedCondition<Boolean> jqueryAction = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver arg0) {
				JavascriptExecutor js = (JavascriptExecutor) arg0;
				String readyState = js.executeScript("return document.readyState").toString();
				System.out.println("####################Document Ready State###################" + readyState);
				System.out.println("Active or not::::"
						+ (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0"));
				return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
			}
		};

		new WebDriverWait(driver, 90).until(jqueryAction);
	}

}
