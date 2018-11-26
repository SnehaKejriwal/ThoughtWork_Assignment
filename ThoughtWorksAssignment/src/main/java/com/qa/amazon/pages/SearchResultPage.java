package com.qa.amazon.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.base.TestBase;

public class SearchResultPage extends TestBase {
	LoginPage loginPage = new LoginPage();
	
	@FindBy(xpath="//li[@id='result_2']//descendant::h2[@data-attribute='Borosil Vision Glass Set, 350ml, Set of 6, Transparent']")
	WebElement borosilVisionGlass;
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//a[@id='hlb-ptc-btn-native' and contains(text(),'Proceed to checkout')]")
	WebElement checkOutBtn;
	
	@FindBy(xpath="//a[contains(text(), 'Deliver to this address')]")
	WebElement deliveryAddressBtn;
	
	@FindBy(xpath="//form[@id='shippingOptionFormId']//div[@class='a-row a-spacing-medium']//descendant::span//input[@class='a-button-text' and @type='submit' and @value='Continue']")
	WebElement shippingOptionContinueBtn;
	
	@FindBy(xpath="//form[@id='changeQuantityFormId']//descendant::input[@type='submit' and @value='Continue']")
	WebElement chngeQuantityContinueBtn;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public PaymentPage addSearchItemToCart() {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,500)");
		clickOn(driver, borosilVisionGlass, 10);
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it= handler.iterator();
		String parentWindowId = it.next();
		System.out.println("parent window id #####"+parentWindowId);
		String childWindowId = it.next();
		System.out.println("child window id ####"+childWindowId);
		driver.switchTo().window(childWindowId);
		clickOn(driver,addToCartBtn , 15);
		clickOn(driver, checkOutBtn, 10);
		//loginPage.login(prop.getProperty("phonenumber"), prop.getProperty("password"));
		loginPage.loginCredential();
		clickOn(driver, deliveryAddressBtn, 10);
		clickOn(driver, shippingOptionContinueBtn, 10);
		return new PaymentPage();
		
	}

	

}
