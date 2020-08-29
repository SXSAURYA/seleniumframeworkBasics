package reusables;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Common {

	/**
	 * Scroll to the element till it scrolls to view
	 */
	public Common scrollIntoView(WebDriver driver, String locator, String direction) {
		boolean isScrolled = false;
		driver.findElement(By.cssSelector("div[ref='eBodyViewport']")).click();
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
				isScrolled = driver.findElement(By.xpath(locator)).isDisplayed();
				isScrolled = true;
			} catch (Exception e) {
				isScrolled = false;
			}

		}
		System.out.println("Find element with text::::::" + driver.findElement(By.xpath(locator)).getText()
				+ " status:::" + isScrolled);
		return this;
	}
}
