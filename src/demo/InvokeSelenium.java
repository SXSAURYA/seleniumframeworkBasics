package demo;

import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

public class InvokeSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setProperty("webdriver.chrome.driver", "D:\\tutor\\seleniumBasics\\browserDriver\\chromedriver.exe");
			System.setProperty("webdriver.gecko.driver", "D:\\tutor\\seleniumBasics\\browserDriver\\geckodriver.exe");
			LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
			ChromeOptions co = new ChromeOptions();
			co.setAcceptInsecureCerts(true);
			
			new InternetExplorerOptions().is(CapabilityType.ACCEPT_INSECURE_CERTS);
////			DesiredCapabilities capabilities1 = new DesiredCapabilities(); 
////			capabilities1.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//			DesiredCapabilities capabilities = new DesiredCapabilities();
//			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//			System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
			// ChromeOptions options = new ChromeOptions();
			WebDriver driver = new ChromeDriver(co);
//			FirefoxOptions options = new FirefoxOptions();
//			options.setLogLevel(FirefoxDriverLogLevel.TRACE);
//			options.setCapability("marionette", true);
//			WebDriver driver1 = new FirefoxDriver(options);
			//driver1.get("https://facebook.com");
			driver.get("https://www.cacert.org/");
			// quiting
			//when we call driver.manage() : return Options interface
			Options opt = driver.manage();
			//When we call options.windows it return Window Interface
			Window opt1 = opt.window();
			//Under windows 
			opt1.maximize();
			Timeouts opt3 = opt.timeouts();
			
			

			/*
			 * boolean bfalse = false; System.out.println(bfalse); new
			 * Common().scrollIntoView(driver, "//span[text()='Dec' and @ref='eText']",
			 * "Right") .scrollIntoView(driver, "//span[text()='Name' and @ref='eText']",
			 * "left") .scrollIntoView(driver,
			 * "//span[@ref='eCellValue' and contains(.,'Ella Kade')]", "down");
			 * driver.get("http://localhost:9090/login?from=%2F");
			 */
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// driver.close();
		}
	}

}
