package qa.acme.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import qa.acme.base.BaseTest;
import qa.acme.constants.AppConstants;
import qa.acme.listeners.ExtentReportListener;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE);
		ExtentReportListener.test.get().log(Status.PASS, "Login page title is : "+actTitle);
	}

	@Test(priority = 2)
	public void loginPageURLTest() {
		String actURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_FRACTION_URL));
	}

	@Test(priority = 3)
	public void fogotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
//		Assert.assertFalse(loginPage.isForgotPwdLinkExist());  //Failing this test case to check retry
	}

	@Test(priority = 4)
	public void appLogoExistTest() {
		Assert.assertTrue(loginPage.isLogoExist());
	}
	
	@Test(priority = 5)
	public void doLoginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	
	
}
