package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {
	RegisterPage regpage;
	AccountSuccessPage acpage;

	public RegisterTest() {
		super();
	}

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = initializeBrowserAndOpenUrlApplication(prop.getProperty("browser"));
		HomePage hp = new HomePage(driver);
		hp.clickonMyaccount();
		regpage=hp.clickRegisterLink();
	}

	@Test(priority = 1)
	public void verifyRegisterAnAccountWithMandatoryFields() {

	
		regpage.enterfirstname(dataprop.getProperty("firstname"));
		regpage.enterlastname(dataprop.getProperty("lastname"));

		regpage.enteremailField(Utilities.generateEmailWithTimeStamp());
		regpage.entertelephoneField(dataprop.getProperty("telephone"));
		regpage.enterpasswordField(dataprop.getProperty("password"));
		regpage.enterconfirmpasswordField(dataprop.getProperty("confirmpassword"));
		// regpage.clicknewslettercheckbox();
		regpage.selectprivacypolicyField();
        acpage=regpage.clickcontinuebutton();


		String AccountSuccessMessage = acpage.retriveAccountCreationSuccessMessage();
		Assert.assertEquals(AccountSuccessMessage, dataprop.getProperty("accountcreationsuccessmessage"),
				"Account is not displayed");

	}

	@Test(priority = 2)
	public void verifyRegisteringAccountByProvidingAllFields() {

		regpage.enterfirstname(dataprop.getProperty("firstname"));
		regpage.enterlastname(dataprop.getProperty("lastname"));

		regpage.enteremailField(Utilities.generateEmailWithTimeStamp());
		regpage.entertelephoneField(dataprop.getProperty("telephone"));
		regpage.enterpasswordField(dataprop.getProperty("password"));
		regpage.enterconfirmpasswordField(dataprop.getProperty("confirmpassword"));
		regpage.clicknewslettercheckbox();
		regpage.selectprivacypolicyField();
		acpage=regpage.clickcontinuebutton();

		String AccountSuccessMessage = acpage.retriveAccountCreationSuccessMessage();
		Assert.assertEquals(AccountSuccessMessage, dataprop.getProperty("accountcreationsuccessmessage"),
				"Account is not displayed");

	}

	@Test(priority = 3)
	public void verifyRegisteringAccountByProvidingExistingEmailid() {

		
		regpage.enterfirstname(dataprop.getProperty("firstname"));
		regpage.enterlastname(dataprop.getProperty("lastname"));
		regpage.enteremailField(dataprop.getProperty("existingemail"));
		regpage.entertelephoneField(dataprop.getProperty("telephone"));
		regpage.enterpasswordField(dataprop.getProperty("password"));
		regpage.enterconfirmpasswordField(dataprop.getProperty("confirmpassword"));
		regpage.clicknewslettercheckbox();
		regpage.selectprivacypolicyField();
		regpage.clickcontinuebutton();

		String AccountWarningMessage = regpage.retriveExistingEmailWarningmessage();
		Assert.assertEquals(AccountWarningMessage, dataprop.getProperty("existingEmailWarning"),
				"Account is not created");


	} //

	@Test(priority = 4)
	public void verifyWarningMessagesForMandatoryFieldsWhenClickingContinueButton() {

	
		regpage.clickcontinuebutton();

		String ActualPrivacyPolicyMessage = regpage.retrivePrivacyPolicyWarningMessage();
		Assert.assertEquals(ActualPrivacyPolicyMessage, dataprop.getProperty("privicyPolicyWarning"),
				"Privacy policy message warning is not displayed");


		String ActualFirstNameWarningMessage = regpage.retriveFirstNameWarningMessage();
		Assert.assertEquals(ActualFirstNameWarningMessage, dataprop.getProperty("firstNameWarning"),
				"First name message warning is not displayed");


		String ActualLastNameWarningMessage = regpage.retriveLasstNameWarningMessage();
		Assert.assertEquals(ActualLastNameWarningMessage, dataprop.getProperty("lastNameWarning"),
				"Last name message warning is not displayed");


		String ActualEmailWarningMessage = regpage.retriveEmailWarningMessage();
		Assert.assertEquals(ActualEmailWarningMessage, dataprop.getProperty("emailWarning"),
				"Email message warning is not displayed");


		String ActualTelephoneWarningMessage = regpage.retriveTelephoneWarningMessage();
		Assert.assertEquals(ActualTelephoneWarningMessage, dataprop.getProperty("telePhoneWarning"),
				"Telephone message warning is not displayed");


		String ActualpasswordWarningMessage = regpage.retrivePasswordWarningMessage();
		Assert.assertEquals(ActualpasswordWarningMessage, dataprop.getProperty("passwordWarning"),
				"Password message warning is not displayed");


	}

}
