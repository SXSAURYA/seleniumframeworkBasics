package testScripts;

import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.DemoObjects;
import reusables.UIInteraction;
import setup.DriverManager;

public class SubmitFormCopied {
	static WebDriver driver = null;
	static DriverManager driverManager = new DriverManager();

	// Validate all the UI
	public static void verifySubmitFormUI() {
		// Validate all the Input TextBox present or not in UI
		try {
			driver = driverManager.setUp("chrome");
			//60 Second 10 , 10, 10 ... 
			driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
			HashMap<String, String> interactionMap = getUIInteractionMap();
			Iterator<String> attributeKeys = interactionMap.keySet().iterator();
			System.out.println("Started Validation for all Input Text Boxes");
			
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class)
					.withMessage("No able to identify the element");
			

			while (attributeKeys.hasNext()) {
				String attribute = attributeKeys.next();
				WebElement wb = wait.until(new Function<WebDriver, WebElement>() {
					@Override
					public WebElement apply(WebDriver t) {
						// TODO Auto-generated method stub
						return driver.findElement(DemoObjects.fieldTextBox(attribute));
					}
				});
				wb.getAttribute("value");
				UIInteraction.checkElementPresent(driver, DemoObjects.fieldTextBox(attribute),
						attribute + " Input TextBox");
			}

			System.out.println("Completed Validation for all Input Text Boxes");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			driverManager.tearDown(driver);
		}
	}

	public static void verifyDemoLinkNavigation() {
		// Validate all the Input TextBox present or not in UI
		try {
			driver = driverManager.setUp("chrome");
			driver.get("file:///D:/tutor/seleniumBasics/resources/Demo.html");
			UIInteraction.clickElement(driver, DemoObjects.demoLink1, "Demo 1 link");
			Thread.sleep(1500);
			String expectedURL = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";
			String actualURL = driver.getCurrentUrl();
			System.out.println("Actual URL::::" + actualURL + " Expected URL:::::::" + expectedURL);
			if (actualURL.equalsIgnoreCase(expectedURL)) {
				System.out.println("Its working as expected");
			} else {
				throw new Exception(actualURL + " is not matching with expected URL " + expectedURL);
			}
		} catch (Exception e) {
			System.out.println("test Script demo link navigation is failing due to " + e.getMessage());
		} finally {
			driverManager.tearDown(driver);
		}
	}

	public static void jsDemo() {
		// Validate all the Input TextBox present or not in UI
		try {
			driver = driverManager.setUp("chrome");
			driver.get("file:///D:/tutor/seleniumBasics/resources/Demo.html");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// Object[] args / Object ...
			// Object ...
			js.executeScript("onClickButton();", "");
			// executeScript
			// executeAsyncScript
			Thread.sleep(1500);
			System.out.println(driver.getCurrentUrl());
		} catch (Exception e) {
			System.out.println("test Script demo link navigation is failing due to " + e.getMessage());
		} finally {
			driverManager.tearDown(driver);
		}
	}

	public static void jsDemo1() {
		// Validate all the Input TextBox present or not in UI
		try {
			driver = driverManager.setUp("chrome");
			driver.get(
					"https://www.seleniumeasy.com/selenium-tutorials/resizing-a-web-element-using-webdriver-action-class-movebyoffset");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// Object[] args / Object ...

			int[] arry = new int[3];
			arry[0] = 1;

			// Object ...
			js.executeScript("arguments[0].scrollIntoView(true);",
					driver.findElement(By.xpath("//a[text()='Add new comment']")));
			// executeScript
			// executeAsyncScript
			Thread.sleep(1500);
			System.out.println(driver.getCurrentUrl());
		} catch (Exception e) {
			System.out.println("test Script demo link navigation is failing due to " + e.getMessage());
		} finally {
			driverManager.tearDown(driver);
		}
	}

	public static void performDragAndDropFrame() {
		// Validate all the Input TextBox present or not in UI
		try {
			driver = driverManager.setUp("chrome");
			driver.get("https://codepen.io/rjsmer/full/vvewWp");
			Thread.sleep(1500);
//			new WebDriverWait(driver, 60).until(Exp);
//			new WebDriverWait(driver, 60)
//					.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".dropFrame.dragDrop")));
			int X = driver.findElement(By.cssSelector("li#element2-2")).getLocation().getX();
			int Y = driver.findElement(By.cssSelector("li#element2-2")).getLocation().getY();
			int ychanged = driver.findElement(By.cssSelector("li#element2-2")).getSize().height + Y;
			driver.switchTo().defaultContent();
			Thread.sleep(1500);
//			new WebDriverWait(driver, 60).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("result")));
//			new WebDriverWait(driver, 60)
//					.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".dragFrame.dragDrop")));
			System.out.println("");
			int i = 0;
			new Actions(driver).clickAndHold(driver.findElement(By.id("dragFrame-0"))).moveByOffset(48 + 300, 83)
					.release().build().perform();
			while (i < 3) {
				try {
					System.out.println("In Try" + i);
					System.out.println(driver.findElement(By.id("dragFrame-0")).getLocation().getX() + ":::::"
							+ driver.findElement(By.id("dragFrame-0")).getLocation().getY());
					new Actions(driver).clickAndHold(driver.findElement(By.id("dragFrame-0")))
							.moveByOffset(48 + 300, 83).release().build().perform();
				} catch (Exception e) {
					System.out.println(i);
					e.printStackTrace();
				}
				i++;
			}
			Thread.sleep(1500);
			driver.switchTo().defaultContent();
//			new WebDriverWait(driver, 60).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("result")));
//			new WebDriverWait(driver, 60)
//					.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".dropFrame.dragDrop")));

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test Script demo link navigation is failing due to " + e.getMessage());
		} finally {
			driverManager.tearDown(driver);
		}
	}

	// Validate all the UI
	public static void verifySubmitSubmission() {
		// Validate all the Input TextBox present or not in UI
		try {
			driver = driverManager.setUp("chrome");
			driver.get("file:///D:/tutor/seleniumBasics/resources/Demo.html");
			//

			// CheckBox Selection
			// TODO: Write one method to click Radio Button
			UIInteraction.checkElement(driver, DemoObjects.jsonCheckBox, "JSON");

			// Checking whether element is enabled or not
			System.out.println(UIInteraction.isEnabled(driver, DemoObjects.submitButton, "Submit Button"));

			// Selecting option using different mechanism
			// TODO : Re-write the method to select value if the option is not selected
			// already?

			UIInteraction.selectOptionViaIndex(driver, DemoObjects.selectDropdown, "Automation Type", 2);
			UIInteraction.selectOptionViaValue(driver, DemoObjects.selectDropdown, "Automation Type", "Service");
			UIInteraction.selectOptionViaVisibleText(driver, DemoObjects.selectDropdown, "Automation Type", "UI");

			UIInteraction.clickElement(driver, DemoObjects.submitButton, "Submit Button");

			String expectedText = "Congrats you have completed All Webelements Type";
			String actualText = UIInteraction.getElementText(driver, By.tagName("h1")).trim();
			System.out.println("Expected Text:::::::::::::" + expectedText);
			System.out.println("Actual Text:::::::::::::" + actualText);
			boolean formSubmission = actualText.contains(expectedText);
			if (!formSubmission) {
				throw new Exception(actualText + " is not equals to " + expectedText);
			} else {
				System.out.println("Form Submission is working as expected");
			}

		} catch (Exception e) {
			System.out.println("Form Submission is not working fine due to " + e.getMessage());
		} finally {
			// driverManager.tearDown(driver);
		}
	}

	// Validate all the UI
	public static void verifyWindowHandle() {
		// Validate all the Input TextBox present or not in UI
		try {
			driver = driverManager.setUp("chrome");
			driver.get("file:///D:/tutor/seleniumBasics/resources/Demo.html");
			System.out.println(driver.getCurrentUrl());
			driver.findElement(By.cssSelector("a[id='demo2']")).click();
			Thread.sleep(1500);
			System.out.println(driver.getWindowHandles().size());
			System.out.println(driver.getCurrentUrl());
			// Before switching
			UIInteraction.switchToOtherWindow(driver);

			System.out.println(driver.getCurrentUrl());
			Thread.sleep(1500);
		} catch (Exception e) {
			System.out.println("Form Submission is not working fine due to " + e.getMessage());
		} finally {
			// driverManager.tearDown(driver);
		}
	}

	public static void verifyFrameDemo() {
		// Validate all the Input TextBox present or not in UI
		try {
			driver = driverManager.setUp("chrome");
			driver.get("https://codepen.io/rjsmer/full/vvewWp");
			Thread.sleep(1500);
			
			WebDriverWait wait = new WebDriverWait(driver, 90);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("#result")));
			
			UIInteraction.switctToFrame(driver, By.cssSelector("#result"));
			UIInteraction.switctToFrame(driver, By.cssSelector(".dragFrame.dragDrop"));
			System.out.println(UIInteraction.getElementText(driver, By.cssSelector("#dragFrame-1")));
			driver.switchTo().defaultContent();
			UIInteraction.switctToFrame(driver, By.cssSelector("#result"));
			UIInteraction.switctToFrame(driver, By.cssSelector(".dropFrame.dragDrop"));
			System.out.println(UIInteraction.getElementText(driver, By.cssSelector("#element2-1")));
		} catch (Exception e) {
			System.out.println("Form Submission is not working fine due to " + e.getMessage());
		} finally {
			driverManager.tearDown(driver);
		}
	}

	// Validate all the UI
	public static void verifyBackToTopButton() {
		// Validate all the Input TextBox present or not in UI
		try {
			driver = driverManager.setUp("chrome");
			driver.get("https://www.myntra.com/men-apparel-polos-tshirts");
			long defaulScroll = (long) ((JavascriptExecutor) driver).executeScript("return window.scrollY;", "");

			// Scroll to to
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight);", "");
			defaulScroll = (long) ((JavascriptExecutor) driver).executeScript("return window.scrollY;", "");
			System.out.println("Default Scroll:::" + defaulScroll);

			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0);", "");
			defaulScroll = (long) ((JavascriptExecutor) driver).executeScript("return window.scrollY;", "");

			System.out.println("Default Scroll:::" + defaulScroll);

			((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight);", "");
			defaulScroll = (long) ((JavascriptExecutor) driver).executeScript("return window.scrollY;", "");
			System.out.println("Default Scroll:::" + defaulScroll);
			Thread.sleep(1500);
			System.out.println(defaulScroll + " after scroll");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					driver.findElement(DemoObjects.scrollToTopButton));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
					driver.findElement(DemoObjects.scrollToTopButton));
			Thread.sleep(1500);
			defaulScroll = (long) ((JavascriptExecutor) driver).executeScript("return window.scrollY;", "");
			System.out.println(defaulScroll + " after scroll with back to top button");
		} catch (Exception e) {
			System.out.println("Form Submission is not working fine due to " + e.getMessage());
		} finally {
			driverManager.tearDown(driver);
		}
	}

	public static void verifyCSSProp() {
		// Validate all the Input TextBox present or not in UI
		try {
			driver = driverManager.setUp("chrome");
			driver.get("file:///D:/tutor/seleniumBasics/resources/BoldItallic.html");
			System.out.println(
					"font style:::" + UIInteraction.getCSSAttribute(driver, DemoObjects.pTagName, "font-style"));
			UIInteraction.performMouseHover(driver, "P Tage", DemoObjects.pTagName);
			Thread.sleep(1500);
			System.out.println(
					"font style:::" + UIInteraction.getCSSAttribute(driver, DemoObjects.pTagName, "font-style"));
		} catch (Exception e) {
			System.out.println("Form Submission is not working fine due to " + e.getMessage());
		} finally {
			driverManager.tearDown(driver);
		}
	}

	public static void dragAndDrop() {
		// Validate all the Input TextBox present or not in UI
		try {
			driver = driverManager.setUp("chrome");
			driver.get("https://jqueryui.com/droppable/");
//			new WebDriverWait(driver, 30)
//					.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("[class='demo-frame']")));

			// (x,y)
			// Point will get you coordinate of the WebElement
			Point point = driver.findElement(By.cssSelector("#draggable")).getLocation();
			Dimension dimension = driver.findElement(By.cssSelector("#draggable")).getSize();
			dimension.getHeight();
			dimension.getWidth();
			System.out.println(String.format("Element Location %1d %2d",
					driver.findElement(By.cssSelector("#draggable")).getLocation().getX(),
					driver.findElement(By.cssSelector("#draggable")).getLocation().getY()));

			UIInteraction.performDragAndDrop(driver, "Drag Element", By.cssSelector("#draggable"), "Target Element",
					By.cssSelector("#droppable"));
			// get all the CSS Prop

			Thread.sleep(1500);
			System.out.println(String.format("Element Location %1d %2d",
					driver.findElement(By.cssSelector("#draggable")).getLocation().getX(),
					driver.findElement(By.cssSelector("#draggable")).getLocation().getY()));
		} catch (Exception e) {
			System.out.println("Form Submission is not working fine due to " + e.getMessage());
		} finally {
			driverManager.tearDown(driver);
		}
	}

	public static void resizeTest() {
		// Validate all the Input TextBox present or not in UI
		try {
			driver = driverManager.setUp("chrome");
			driver.get("https://jqueryui.com/resizable/");
//			new WebDriverWait(driver, 30)
//					.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("[class='demo-frame']")));
			Actions actions = new Actions(driver);
			String elementLocationText = String.format("Element Location %1d %2d",
					driver.findElement(By.cssSelector("#resizable")).getLocation().getX(),
					driver.findElement(By.cssSelector("#resizable")).getLocation().getY());
			System.out.println(elementLocationText);
			Thread.sleep(1500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					driver.findElement(By.cssSelector("#resizable")));
			actions.clickAndHold(driver.findElement(By.cssSelector("#resizable"))).moveByOffset(50, 50).release()
					.build().perform();
			// Thread.sleep(1500);
			System.out.println(String.format("Element Location %1d %2d",
					driver.findElement(By.cssSelector("#resizable")).getLocation().getX(),
					driver.findElement(By.cssSelector("#resizable")).getLocation().getY()));
			// get all the CSS Prop
			// System.out.println(String.format("Element Location %1d %2d",
			// driver.findElement(By.cssSelector("#draggable")).getLocation().getX(),driver.findElement(By.cssSelector("#draggable")).getLocation().getY()));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Form Submission is not working fine due to " + e.getMessage());
		} finally {
			// driverManager.tearDown(driver);
		}
	}

	public static void rightClick() {
		// Validate all the Input TextBox present or not in UI
		try {
			driver = driverManager.setUp("chrome");
			driver.navigate().to("http://swisnl.github.io/jQuery-contextMenu/demo.html");
			// driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
			By locator = By.cssSelector(".context-menu-one.btn");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Actions actions = new Actions(driver);
			UIInteraction.performRightClick(driver, "Right Click Button", By.cssSelector(".context-menu-one.btn"));
			Thread.sleep(1500);
			
//			  wait.until(ExpectedConditions .presenceOfElementLocated(By.
//			  cssSelector(".context-menu-list li:nth-of-type(1)")));
			 
			WebElement elementEdit = driver.findElement(By.cssSelector(".context-menu-list li:nth-of-type(1)"));
			elementEdit.click();
			Alert alert = driver.switchTo().alert();
			String textEdit = alert.getText();
			Thread.sleep(1500);
			alert.accept();

			System.out.println("You alert:::" + textEdit);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Form Submission is not working fine due to " + e.getMessage());
		} finally {
			driverManager.tearDown(driver);
		}
	}

	public static void performMultipleAction() {
		// Validate all the Input TextBox present or not in UI
		try {
			driver = driverManager.setUp("chrome");
			driver.get("http://www.google.com/");

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			WebElement text = driver.findElement(By.name("q"));

			Actions actions = new Actions(driver);
			Action action = actions.moveToElement(driver.findElement(By.cssSelector("[name='q']"))).keyDown(Keys.SHIFT)
					.sendKeys("Selenium WebDriver Automation").keyUp(Keys.SHIFT).release().build();

			action.perform();

			Thread.sleep(1500);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Form Submission is not working fine due to " + e.getMessage());
		} finally {
			driverManager.tearDown(driver);
		}
	}

	public static void verifyAlertHandle() {
		// Validate all the Input TextBox present or not in UI
		try {
			driver = driverManager.setUp("chrome");
			driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
			Thread.sleep(1500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					driver.findElement(By.xpath("//button[text()='Simple Alert']")));
			driver.findElement(By.xpath("//button[text()='Simple Alert']")).click();
			Thread.sleep(1500);
			UIInteraction.alertHandle(driver, "", true);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Form Submission is not working fine due to " + e.getMessage());
		} finally {
			// driverManager.tearDown(driver);
		}
	}

	public static HashMap<String, String> getUIInteractionMap() {
		HashMap<String, String> textBoxInteractionMap = new HashMap<String, String>();
		textBoxInteractionMap.put("first_name", "Naga Raju");
		textBoxInteractionMap.put("last_name", "Ramisetty");
		textBoxInteractionMap.put("email", "nagaraju145@gmail.com");
		textBoxInteractionMap.put("phone", "6261087789");
		textBoxInteractionMap.put("address", "Chanda Nagar, Hyderabad");
		textBoxInteractionMap.put("city", "Hyderabad");
		textBoxInteractionMap.put("zip", "500089");
		textBoxInteractionMap.put("website", "www.demoSite.com");
		textBoxInteractionMap.put("comment", "Added Comment for Automation");
		return textBoxInteractionMap;
	}

}
