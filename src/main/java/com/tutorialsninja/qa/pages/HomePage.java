package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement RegisterOption;
	
	@FindBy(name="search")
	private WebElement searchbox;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchboxbutton;
	
	
	
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void clickonMyaccount() {
		myAccountDropMenu.click();
	}
	
	public LoginPage clickLogin() {
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage clickRegisterLink() {
		RegisterOption.click();
		return new RegisterPage(driver);
	}
	
	public void clickOnSearchBox(String text ) {
		searchbox.sendKeys(text);
	}
	
	public SearchResultsPage clickOnSearchBoxButton() {
		searchboxbutton.click();
		return new SearchResultsPage(driver);
	}
	
	
}
