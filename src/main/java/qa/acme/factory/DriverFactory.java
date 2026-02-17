package qa.acme.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

import qa.acme.constants.AppConstants;
import qa.acme.constants.AppError;
import qa.acme.exceptions.BrowserException;
import qa.acme.exceptions.FrameworkException;

public class DriverFactory {
	
	WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
	
	public static String highlight;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	/**
	 * This is used to init the driver on the basis on given browser name.
	 * 
	 * @param browserName
	 */
	
	public WebDriver initDriver(Properties prop) {
		String browserName = prop.getProperty("Browser");
		System.out.println("Browser name is : " + browserName);
		
		highlight = prop.getProperty("highlight");
		
		optionsManager = new OptionsManager(prop);

		switch (browserName.toLowerCase().trim()) {
		case "chrome":			
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			break;
		case "firefox":
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			break;
		case "edge":
			tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
			break;
		case "safari":
			tlDriver.set(new SafariDriver());
			break;

		default:
			System.out.println("plz pass the right browser name..." + browserName);
			throw new BrowserException(AppError.BROWSER_NOT_FOUND);
			
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
//		getDriver().get(prop.getProperty("url"));// loginPage

		return getDriver();

	}
	
	/**
	 * get the local thread copy of the driver
	 * @return
	 */
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	/**
	 * This is used to init the properties from the .properties file
	 * 
	 * @return this returns properties (prop)
	 */
	public Properties initProp() {
		prop = new Properties();
		FileInputStream ip = null;
		// mvn clean install -Denv="qa"
		// mvn clean install

		try {
			ip = new FileInputStream(AppConstants.CONFIG_FILE_PATH);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	/**
	 * Take Screenshot
	 */
	
	public static String getScreenshot(String methodName) {
		
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);//temp location
		String path = System.getProperty("user.dir")+"/screenshots/"+methodName+"_"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		
		try {
			FileHandler.copy(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
	}

	
	
}
