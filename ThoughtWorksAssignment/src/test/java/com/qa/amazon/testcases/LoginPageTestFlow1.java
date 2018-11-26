package com.qa.amazon.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.amazon.base.TestBase;
import com.qa.amazon.pages.HomePage;
//import com.qa.amazon.pages.LoginPage;
import com.qa.amazon.pages.PaymentPage;
import com.qa.amazon.pages.SearchResultPage;

public class LoginPageTestFlow1 extends TestBase {
	HomePage homePage;
	SearchResultPage searchResultPage;
	PaymentPage paymentPage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		searchResultPage = new SearchResultPage();
		searchResultPage = homePage.searchBorosilVisionGlassSet();
	}
	
	@Test(priority=1)
	public void searchResultPageTestFlow1() {
		paymentPage = searchResultPage.addSearchItemToCart();
	}

}
