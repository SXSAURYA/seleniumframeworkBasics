package setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

public class DriverManager {
	
	public WebDriver setUp(String browserType) {
		//switch case
		WebDriver driver = null;
		String userDir = System.getProperty("user.dir");
		//What are the latest update in current Selenium version ?
		switch (browserType.toLowerCase()) {
		case "chrome":
			//why we need drivers in selenium ?
			//What is WebDriver class /Interface?
			//Add Condition for mac chrome/window chrome ?
			//Mac change 
			ChromeOptions chromeOptions =  new ChromeOptions();
			//chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			chromeOptions.setAcceptInsecureCerts(true);
			chromeOptions.addArguments("--disable-infobars");
			chromeOptions.addArguments("--allow-insecure-localhost");
			chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			System.setProperty("webdriver.chrome.driver", userDir+"/browserDriver/chromedriver.exe");
			driver = new ChromeDriver(chromeOptions);
			break;
		case "chrome headless":
			//why we need drivers in selenium ?
			//What is WebDriver class /Interface?
			//Add Condition for mac chrome/window chrome ?
			//Mac change 
			ChromeOptions chromeOptionsHeadless =  new ChromeOptions();
			//chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			chromeOptionsHeadless.setAcceptInsecureCerts(true);
			chromeOptionsHeadless.addArguments("--headless");
			chromeOptionsHeadless.addArguments("--verbose");
			chromeOptionsHeadless.addArguments("--disable-infobars");
			chromeOptionsHeadless.addArguments("--allow-insecure-localhost");
//			chromeOptionsHeadless.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			System.setProperty("webdriver.chrome.driver", userDir+"/browserDriver/chromedriver.exe");
			driver = new ChromeDriver(chromeOptionsHeadless);
			break;
		case "ie":
			//Add Conditioin depends on Arch  ?
			System.setProperty("webdriver.ie.driver", userDir+"/browserDriver/IEDriverServer.exe");
			InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
			//internetExplorerOptions.setA
			internetExplorerOptions.ignoreZoomSettings();
			internetExplorerOptions.introduceFlakinessByIgnoringSecurityDomains();
			driver = new InternetExplorerDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", userDir+"/browserDriver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			break;
		}
		Options opt = driver.manage();
		Window window = opt.window();
		Timeouts time= opt.timeouts();
		window.maximize();
		//This will depends on Company 
		time.implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	
	public void tearDown(WebDriver driver) {
		try {
			if(driver!=null)
				driver.quit();
		} catch (Exception e) {
			System.out.println("#############Error ocuured while quiting the driver due to#######"+e.getMessage());
		}
		
	}

}
