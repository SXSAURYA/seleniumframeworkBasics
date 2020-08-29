package demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.concurrent.TimedSemaphore;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.grid.internal.exception.NewSessionException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import setup.DriverManager;

public class InvokeDriversCopy2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		DriverManager driverManager = new DriverManager();
		// selenium latest feature
		try {
			driver = driverManager.setUp("chrome");
			// http://{username:password}@url
			// http://admin:admin@the-internet.herokuapp.com/basic_auth
			driver.get("https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");
			System.out.println("URL of the Site:::" + driver.getCurrentUrl());
			// get the page title
			System.out.println("Title of the Site::;" + driver.getTitle());
			driver.navigate().refresh();
			Thread.sleep(500);
			driver.navigate().back();
			Thread.sleep(500);
			driver.navigate().forward();
			Thread.sleep(500);
                   
			Thread.sleep(1500);

			// get the URL
			new Select(driver.findElement(By.cssSelector("#files"))).selectByVisibleText("Java");
			Thread.sleep(1500);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driverManager.tearDown(driver);
		}
		// X actions
		// Close browser

	}

}
