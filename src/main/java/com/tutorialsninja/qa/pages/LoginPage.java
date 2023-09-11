package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	
	@FindBy(name="email")
	private WebElement emailfield;
	
	@FindBy(name="password")
	private WebElement passwordfield;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement loginbutton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement EmailPasswordNotMatchingwarningmessage;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public void enterEmailAddress(String email) {
		emailfield.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordfield.sendKeys(password);
	}
	
	public AccountPage clickLoginButton() {
		loginbutton.click();
		return new AccountPage(driver);
	}
	
	public String retriveEmailPasswordNotMatchingwarningmessage() {
		String warningtext=EmailPasswordNotMatchingwarningmessage.getText();
		 return warningtext;
	}

}
