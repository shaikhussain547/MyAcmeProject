package qa.acme.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import qa.acme.pages.LoginPage;
import qa.acme.constants.AppConstants;
import qa.acme.factory.DriverFactory;


public class BaseTest {
	
	protected WebDriver driver;
	protected Properties prop;
	DriverFactory df;
	protected LoginPage loginPage;
	
	
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		System.out.println(prop.getProperty("Env"));
		System.out.println(AppConstants.urlInfo(prop.getProperty("Env")));
		driver.navigate().to(AppConstants.urlInfo(prop.getProperty("Env")));
		loginPage = new LoginPage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
}
