package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	
	WebDriver driver;
	
	public SearchResultsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement searchresults;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement NoProductSearchMessage;
	
	public boolean Searchresults() {
		boolean display=searchresults.isDisplayed();
		return display;
	}
	
	public String VerifynoSearchResultsData() {
		String noproduct =NoProductSearchMessage.getText();
		return noproduct;
	}

}
