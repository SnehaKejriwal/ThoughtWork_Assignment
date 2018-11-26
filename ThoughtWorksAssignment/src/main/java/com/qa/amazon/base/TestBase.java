package com.qa.amazon.base;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.StaleElementReferenceException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.events.EventFiringWebDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.amazon.util.TestUtil;
import com.qa.amazon.util.WebEventListener;


	public class TestBase {
		public static WebDriver driver;
		public static Properties prop;
		public  static EventFiringWebDriver e_driver;
		public static WebEventListener eventListener;
		
		public TestBase(){
			try {
			    prop = new Properties();
			    FileInputStream ip;
				ip = new FileInputStream("E:\\Eureka_AutoDemo_workspace\\AmazonAutomationTest\\src\\main\\java\\com\\amazon\\qa\\config\\config.properties");
				prop.load(ip);
				}catch (FileNotFoundException e) {
					e.printStackTrace();
				}catch (IOException e) {
				e.printStackTrace();
			}		
		}
		
		public static void initialization(){
			String browserName= prop.getProperty("browser");
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
				driver= new ChromeDriver();
			}else if(browserName.equals("FF")){
				System.setProperty("webdriver.gecko.driver", "E:\\chromedriver_win32\\geckodriver.exe");
				driver= new FirefoxDriver();
			}
			
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
				driver.get(prop.getProperty("url"));	
				
		
		}
		
		public static void clickOn(WebDriver driver,WebElement locator,int timeout){
			new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
			locator.click();
			}
		

}
