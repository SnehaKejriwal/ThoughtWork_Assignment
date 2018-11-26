package com.qa.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//a[@id='nav-link-yourAccount']//span[@class='nav-line-2']")
	WebElement mouseHoverElement;
	
	@FindBy(xpath="//div[@id='nav-flyout-ya-signin']//span[contains(text(),'Sign in')]")
	WebElement signInBtn;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBar;
	
	@FindBy(xpath="//input[@type='submit' and @value='Go']")
	WebElement searchBtn;
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickSignIn(){
		try {
			Actions builder = new Actions(driver);
			WebElement menuElement = mouseHoverElement;
			builder.moveToElement(menuElement).build().perform();
			clickOn(driver, signInBtn, 15);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new LoginPage();
	}
	
	public SearchResultPage searchBorosilVisionGlassSet() {
		searchBar.sendKeys(prop.getProperty("searchContent"));
		searchBtn.click();
		return new SearchResultPage();
		
	}

}
