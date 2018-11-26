package com.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//input[@id='ap_email']")
	WebElement emailId;
	
	@FindBy(xpath="//span[@id='continue']")
	WebElement continueBtn;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement passwrd;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement loginBtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//way 1 to login via config file 
	public HomePage login(String email,String pswrd) {
		emailId.sendKeys(email);
		clickOn(driver, continueBtn, 10);
		passwrd.sendKeys(pswrd);
		loginBtn.click();
		return new HomePage();
		
	}
	
	//Way 2 login # hard code the login credentials
	public HomePage loginCredential() {
		driver.findElement(By.id("ap_email")).sendKeys("8880112001");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("nothing");
		driver.findElement(By.id("signInSubmit")).click();
		return new HomePage();
	}

}
