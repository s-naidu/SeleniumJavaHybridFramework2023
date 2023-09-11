package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchResultsPage;

public class SearchTest extends Base {
	HomePage homepage;
	SearchResultsPage srp;
	public SearchTest() {
		super();
	}

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = initializeBrowserAndOpenUrlApplication(prop.getProperty("browser"));
		homepage= new HomePage(driver);

	}

	@Test
	public void verifySearchWithValidProduct() {
		//HomePage homepage = new HomePage(driver);
		homepage.clickOnSearchBox(dataprop.getProperty("searchdata"));
		srp=homepage.clickOnSearchBoxButton();
		//SearchResultsPage srp = new SearchResultsPage(driver);
		Assert.assertTrue(srp.Searchresults(), "product is nt showing");
	}

	@Test
	public void verifySearchWithInValidProduct() {
		//HomePage homepage = new HomePage(driver);
		homepage.clickOnSearchBox(dataprop.getProperty("invalidsearhdata"));
		srp=homepage.clickOnSearchBoxButton();
		//SearchResultsPage srp = new SearchResultsPage(driver);

		String ActualNoProductSearchMessage = srp.VerifynoSearchResultsData();

		Assert.assertEquals(ActualNoProductSearchMessage, dataprop.getProperty("noProductListingMessage"));

	}

	@Test
	public void verifySearchWithoutProduct() {

		//HomePage homepage = new HomePage(driver);
		srp=homepage.clickOnSearchBoxButton();
		//SearchResultsPage srp = new SearchResultsPage(driver);

		String ActualNoProductSearchMessage = srp.VerifynoSearchResultsData();

		Assert.assertEquals(ActualNoProductSearchMessage, dataprop.getProperty("noProductListingMessage"));

	}

}
