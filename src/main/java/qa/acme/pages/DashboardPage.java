package qa.acme.pages;

import org.openqa.selenium.WebDriver;

import qa.acme.utils.ElementUtil;

public class DashboardPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	// page const...
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);	
	}
	
	
	
	
		
		
}
