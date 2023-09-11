package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	@FindBy(id = "input-firstname")
	private WebElement firstnameField;

	@FindBy(id = "input-lastname")
	private WebElement lastnameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement confirmpasswordField;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement privacypolicyField;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continuebutton;

	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement newslettercheckbox;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement existingemailWarning;

	// mandatory fileds validation elements

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement PrivacyPolicyWarningMessage;

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement FirstNameWarningMessage;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement LastNameWarningMessage;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement EmailWarningMessage;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement TelephoneWarningMessage;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarningMessage;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterfirstname(String firstname) {
		firstnameField.sendKeys(firstname);
	}

	public void enterlastname(String lasttname) {
		lastnameField.sendKeys(lasttname);
	}

	public void enteremailField(String email) {
		emailField.sendKeys(email);
	}

	public void entertelephoneField(String telephone) {
		telephoneField.sendKeys(telephone);
	}

	public void enterpasswordField(String password) {
		passwordField.sendKeys(password);
	}

	public void enterconfirmpasswordField(String confirmpassword) {
		confirmpasswordField.sendKeys(confirmpassword);
	}

	public AccountSuccessPage clickcontinuebutton() {
		continuebutton.click();
		return new AccountSuccessPage(driver);
	}

	public void clicknewslettercheckbox() {
		newslettercheckbox.click();
	}

	public void selectprivacypolicyField() {
		privacypolicyField.click();
	}

	// Warning messages fields action class
	public String retriveExistingEmailWarningmessage() {
		String warningtext = existingemailWarning.getText();
		return warningtext;
	}

	public String retrivePrivacyPolicyWarningMessage() {
		String warningtext = PrivacyPolicyWarningMessage.getText();
		return warningtext;
	}

	public String retriveFirstNameWarningMessage() {
		String warningtext = FirstNameWarningMessage.getText();
		return warningtext;
	}

	public String retriveLasstNameWarningMessage() {
		String warningtext = LastNameWarningMessage.getText();
		return warningtext;
	}

	public String retriveEmailWarningMessage() {
		String warningtext = EmailWarningMessage.getText();
		return warningtext;
	}

	public String retriveTelephoneWarningMessage() {
		String warningtext = TelephoneWarningMessage.getText();
		return warningtext;
	}

	public String retrivePasswordWarningMessage() {
		String warningtext = passwordWarningMessage.getText();
		return warningtext;
	}

}
