package reusables;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class UIInteraction {

	/**
	 * @description: This function will enter some data in input textbox
	 * @param textToEnter : Which Text you want to enter
	 * @param textBox     : This is the locator for your input textbox
	 * @param textBoxName : This is textbox name like we can pass like username
	 * @param isClear     : whether you want to clear the textBox or not
	 */
	public static void enterDataInTextBox(WebDriver driver, String textToEnter, By textBox, String textBoxName,
			boolean isClear) {
		try {
			Reporter.log("##############Entering text as " + textToEnter + "########### Begins",true);
			waitForVisiblity(driver, 90, textBox);
			if (isClear)
				clearTextBox(driver, textBox);
			WebElement textBo = driver.findElement(textBox);
			textBo.sendKeys(textToEnter);
			Reporter.log("##############Entering text as " + textToEnter + "########### end");
			takeScreenshot("Taking screenshot for clearance", driver);
		} catch (Exception e) {
			Reporter.log("Exception occurred while entering text " + textToEnter + " due to " + e.getMessage(),true);
		}
	}
	
	
	
	public static void enterDataInTextBox(WebDriver driver, String textToEnter, WebElement textBox, String textBoxName,
			boolean isClear) {
		try {
			Reporter.log("##############Entering text as " + textToEnter + "########### Begins");
			waitForVisiblity(driver, 90, textBox);
			textBox.clear();
			textBox.sendKeys(textBoxName);
			Reporter.log("##############Entering text as " + textToEnter + "########### end");
		} catch (Exception e) {
			Reporter.log("Exception occurred while entering text " + textToEnter + " due to " + e.getMessage());
		}
	}
	
	
	//TODO : Wrapper for Webelement
	/*
	 * */
	public static void waitForVisiblity(WebDriver driver,By uiElement) {
		try {
			waitForVisiblity(driver,90,uiElement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/*
	 * */
	public static void waitForVisiblity(WebDriver driver, int waitTime,By uiElement) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 90);
			//prresence of and visiblity of 
			//wait.until((Function< super WebDriver, V>) ExpectedConditions.visibilityOfElementLocated(uiElement));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void waitForVisiblity(WebDriver driver, int waitTime,WebElement wb) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			//prresence of and visiblity of 
			//wait.until(ExpectedConditions.visibilityOf(wb));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//TODO

	/**
	 * @description: This function will use to clear the textBox
	 * @param textBox : This is the locator for your input textbox
	 */
	public static void clearTextBox(WebDriver driver, By textBox) {
		Reporter.log("##############Clearing the textbox########### Begins");
		driver.findElement(textBox).clear();
		Reporter.log("##############Clearing the textbox########### ends");
	}

	/**
	 * @description : This function will be used whether element is displaying or
	 *              not in UI
	 * @param               uiElement: Locator for the element i.e.
	 *                      button[name='submit']
	 * @param uiElementName : This is the element name
	 */
	public static boolean checkElementPresent(WebDriver driver, By uiElement, String uiElementName) {
		boolean uiDisplayed = false;
		try {
			waitForVisiblity(driver, uiElement);
			uiDisplayed = driver.findElement(uiElement).isDisplayed();
			if (uiDisplayed)
				Reporter.log("UI element " + uiElementName + " is displaying properly");
			else
				Reporter.log("UI element " + uiElementName + " is displaying properly");
		} catch (Exception e) {
			Reporter.log("Exception occured while validating the " + uiElementName + " element in UI due to "
					+ e.getMessage());
		}
		return uiDisplayed;
	}

	/**
	 * @description : This function will be used whether element is displaying
	 *              selected or not
	 * @param uiElement: Locator for the element i.e. button[name='submit']
	 */
	public static boolean isElementSelected(WebDriver driver, By uiElement) {
		boolean isSelected = false;
		
		WebDriverWait wait = new WebDriverWait(driver, 90);
		
		//wait.until(ExpectedConditions.elementToBeSelected(uiElement));
		
		
		isSelected = driver.findElement(uiElement).isSelected();
		return isSelected;
	}

	public static void checkElement(WebDriver driver, By uiElement, String checkBoxName) {
		Reporter.log("CheckBox Selection for " + checkBoxName + " checkbox");
		
		WebDriverWait wait = new WebDriverWait(driver, 90);
		//wait.until(ExpectedConditions.elementToBeClickable(uiElement));
		
		if (isElementSelected(driver, uiElement))
			Reporter.log(checkBoxName + " checkbox is alreadyy selected");
		else
			driver.findElement(uiElement).click();

		// Check whether element is selected or not
		if (isElementSelected(driver, uiElement))
			Reporter.log("Checkbox " + checkBoxName + " is successfully selected");
		Reporter.log("CheckBox Selection for " + checkBoxName + " checkbox");
	}

	// TODO: Need to Implement this
	public static void unCheckElement(WebDriver driver, By uiElement, String checkBoxName) {
		Reporter.log("CheckBox Selection for " + checkBoxName + " checkbox");
		if (isElementSelected(driver, uiElement))
			driver.findElement(uiElement).click();
		else
		// driver.findElement(uiElement).click();

		// Check whether element is selected or not
		if (isElementSelected(driver, uiElement))
			Reporter.log("Checkbox " + checkBoxName + " is successfully selected");
		Reporter.log("CheckBox Selection for " + checkBoxName + " checkbox");
	}

	public static void clickElement(WebDriver driver, By uiElement, String elementName) {
		Reporter.log("Clicking on Element " + elementName + " begins");
		driver.findElement(uiElement).click();
		Reporter.log("UI Element " + elementName + " is clicked successfully");
		Reporter.log("Clicking on Element " + elementName + " ends");
	}

	public static boolean isEnabled(WebDriver driver, By uiElement, String elementName) {
		boolean enabled = false;
		Reporter.log("Checking whether element " + elementName + " is enabled or not");
		enabled = driver.findElement(uiElement).isEnabled();
		return enabled;
	}

	public static void selectOptionViaIndex(WebDriver driver, By uiElement, String selectDropdownName,
			int optionIndex) {
		Reporter.log("Starting selection of option with index " + optionIndex + " begins");
		Select selectDropdown = new Select(driver.findElement(uiElement));
		selectDropdown.selectByIndex(optionIndex);
		// Get the selected Option
		WebElement selectedOption = selectDropdown.getFirstSelectedOption();
		String optionText = selectedOption.getText();
		Reporter.log(optionText + " is selected successfully from " + selectDropdownName);
		Reporter.log("Starting selection of option with index " + optionIndex + " ends");
	}

	public static void selectOptionViaValue(WebDriver driver, By uiElement, String selectDropdownName,
			String optionValue) {
		Reporter.log("Starting selection of option with index " + optionValue + " begins");
		Select selectDropdown = new Select(driver.findElement(uiElement));
		selectDropdown.selectByValue(optionValue);
		// Get the selected Option
		WebElement selectedOption = selectDropdown.getFirstSelectedOption();
		String optionText = selectedOption.getText();
		Reporter.log(optionText + " is selected successfully from " + selectDropdownName);
		Reporter.log("Starting selection of option with index " + optionValue + " ends");
	}

	public static void selectOptionViaVisibleText(WebDriver driver, By uiElement, String selectDropdownName,
			String optionText) {
		Reporter.log("Starting selection of option with index " + optionText + " begins");
		Select selectDropdown = new Select(driver.findElement(uiElement));
		selectDropdown.selectByVisibleText(optionText);
		// Get the selected Option
		WebElement selectedOption = selectDropdown.getFirstSelectedOption();
		Reporter.log(optionText + " is selected successfully from " + selectDropdownName);
		Reporter.log("Starting selection of option with index " + optionText + " ends");
	}

	public static void deselectOptionViaValue(WebDriver driver, By uiElement, String selectDropdownName,
			String optionValue) {
		Select selectDropdown = new Select(driver.findElement(uiElement));
		selectDropdown.deselectByValue(optionValue);
	}

	public static String getSelectedOption(Select selectDropdown) {
		return selectDropdown.getFirstSelectedOption().getText().trim();
	}

	public static String getElementText(WebDriver driver, By uiElement) {
		return driver.findElement(uiElement).getText();
	}

	public static String getElementAttribute(WebDriver driver, By uiElement, String attributeName) {
		return driver.findElement(uiElement).getAttribute(attributeName).trim();
	}

	public static String getCSSAttribute(WebDriver driver, By uiElement, String attributeName) {
		return driver.findElement(uiElement).getCssValue(attributeName);
	}

	public static void performDragAndDrop(WebDriver driver, String sourceName, By uiSourceElement, String targetName,
			By uiTargetElement) {
		try {
			Actions actions = new Actions(driver);
			Action action = actions
					.dragAndDrop(driver.findElement(uiSourceElement), driver.findElement(uiTargetElement)).build();
			
			action.perform();
			Reporter.log("Drag and Drop for source "+sourceName+" to "+targetName+" performed successfully");
		} catch (Exception e) {
			Reporter.log("There is some issues in performing drag and drop for " + sourceName + " to target "
					+ targetName + " due to " + e.getMessage());
		}

	}

	public static void performRightClick(WebDriver driver, String uiElementName, By uiElement) {
		Actions actions = new Actions(driver);
		Action action = actions.contextClick(driver.findElement(uiElement)).build();
		action.perform();
	}	
	
	
	public static void performDoubleClick(WebDriver driver, String uiElementName, By uiElement) {
		Actions actions = new Actions(driver);
		Action action = actions.doubleClick(driver.findElement(uiElement)).build();
		action.perform();
	}
	
	public static void performMouseHover(WebDriver driver, String uiElementName, By uiElement) {
		Actions actions = new Actions(driver);
		Action action = actions.moveToElement(driver.findElement(uiElement)).build();
		action.perform();
	}

	
	
	//closeAllWindow : Close all window except main window 
	//TODO : writeMethod
	
	
	public static void switctToFrame(WebDriver driver,By uiElement) {
		
		driver.switchTo().frame(driver.findElement(uiElement));
	}
	
	
	public static void switchToOtherWindow(WebDriver driver) {
		Set<String> windows = driver.getWindowHandles();
		String mainWindow = getMainWindow(driver);
		//driver.quit and driver.close
		//a,b,c
		for (String window : windows) {
			if (!window.equalsIgnoreCase(mainWindow)) {
				driver.switchTo().window(window);
			}
		}
	}
	
	
	public static String getMainWindow(WebDriver driver) {
		return driver.getWindowHandle();
	}
	
	public static void alertHandle(WebDriver driver,String enterText,boolean accept) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		//wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		int length = enterText.length();
		if (length>0) {
			alert.sendKeys(enterText);
		}
		//filter on the basis of accept
		if (accept) {
			alert.accept();
		}else {
			alert.dismiss();
		}
		
	}
	
	public UIInteraction scrollIntoView(WebDriver driver, By uiElement, String direction) {
		boolean isScrolled = false;
		Keys key = null;
		switch (direction.toLowerCase()) {
		case "right":
			key = Keys.ARROW_RIGHT;
			break;
		case "left":
			key = Keys.ARROW_LEFT;
			break;
		case "down":
			key = Keys.ARROW_DOWN;
			break;
		case "up":
			key = Keys.ARROW_UP;
			break;
		default:
			break;
		}
		while (!isScrolled) {
			new Actions(driver).sendKeys(key).build().perform();
			try {
				isScrolled = driver.findElement(uiElement).isDisplayed();
				isScrolled = true;
			} catch (Exception e) {
				isScrolled = false;
			}

		}
		Reporter.log(
				"Find element with text::::::" + driver.findElement(uiElement).getText() + " status:::" + isScrolled);
		return this;
	}
	
	public static void takeScreenshot(String message,WebDriver driver) {
		String filePath = System.getProperty("user.dir") + "/screenshots/screenshots_"
				+ new SimpleDateFormat("dd_MM_YYYY_HH_mm_ss").format(new Date()) + ".png";
		File targetFile = new File(System.getProperty("user.dir") + "/screenshots/screenshots_"
				+ new SimpleDateFormat("dd_MM_YYYY_HH_mm_ss").format(new Date()) + ".png");
		if (!targetFile.exists()) {
			try {
				targetFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(Paths.get(file.getAbsolutePath()), new FileOutputStream(targetFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// com.google.common.io.Files.copy(file, new FileOutputStream(targetFile));
		Reporter.log(message+"Please find the attached screenshot <a href=\"file:///"+filePath+"\">"
						+ targetFile.getAbsolutePath().split("/")[0] + "</a>");
	}
}
