package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base {
	LoginPage lp;

	public LoginTest() {
		super();
	}

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = initializeBrowserAndOpenUrlApplication(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.clickonMyaccount();
		lp = homepage.clickLogin();

	}

	@Test(dataProvider="supplyTestData")
	public void verifyLoginWithValidCredentials(String email, String password) {

	
		lp.enterEmailAddress(email);
		lp.enterPassword(password);
		AccountPage accopage=lp.clickLoginButton();
		accopage.getDisplayedStatusOfEditYourAccountInformation();
		Assert.assertTrue(accopage.getDisplayedStatusOfEditYourAccountInformation());

	}

	@DataProvider
	public Object[][] supplyTestData() {
		Object[][] data= Utilities.getTestDataFromExcel("Login");
		return data;
	}

	@Test
	public void verifyLoginWithInValidCredentials() {

		lp.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		lp.enterPassword(dataprop.getProperty("invalidpassword"));
		lp.clickLoginButton();

		String actualWarningmesasge = lp.retriveEmailPasswordNotMatchingwarningmessage();
		String expectedWArningmessage = dataprop.getProperty("emailPasswordNoMatching");
		Assert.assertTrue(actualWarningmesasge.contains(expectedWArningmessage),
				"Expected Warning message is not displayed");

	}

	@Test
	public void verifyLoginWithInValidEmailAndValidPassword() {

		lp.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		lp.enterPassword(prop.getProperty("validPassword"));
		lp.clickLoginButton();

		String actualWarningmesasge = lp.retriveEmailPasswordNotMatchingwarningmessage();
		String expectedWArningmessage = dataprop.getProperty("emailPasswordNoMatching");
		Assert.assertTrue(actualWarningmesasge.contains(expectedWArningmessage),
				"Expected Warning message is not displayed");

	}

	@Test
	public void verifyLoginWithValidEmailAndInValidPassword() {

		lp.enterEmailAddress(prop.getProperty("validEmail"));
		lp.enterPassword(dataprop.getProperty("invalidpassword"));
		lp.clickLoginButton();

		String actualWarningmesasge = lp.retriveEmailPasswordNotMatchingwarningmessage();
		String expectedWArningmessage = dataprop.getProperty("emailPasswordNoMatching");
		Assert.assertTrue(actualWarningmesasge.contains(expectedWArningmessage),
				"Expected Warning message is not displayed");

	}

	@Test
	public void verifyLoginWithoutPrividingCredentials() {

		lp.clickLoginButton();

		String actualWarningmesasge = lp.retriveEmailPasswordNotMatchingwarningmessage();
		String expectedWArningmessage = dataprop.getProperty("emailPasswordNoMatching");
		Assert.assertTrue(actualWarningmesasge.contains(expectedWArningmessage),
				"Expected Warning message is not displayed");

	}

}
