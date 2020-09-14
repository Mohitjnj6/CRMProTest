package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.util.TestUtil;
import com.qa.util.WebEventListener;

public class TestBase 
{
	public static WebDriver driver; 
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase()
	{
		try 
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Samsung\\eclipse-workspace\\CRMproTest\\src\\"
					+ "main\\java\\com\\qa\\config\\config.properties");
			prop.load(ip);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public static void initialization()
	{
	 	 String browserName = prop.getProperty("browser");
	 	 
	 	 if (browserName.equals("chrome"))
	 	 {
	 		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samsung\\Downloads\\chromedriver.exe");
	 		  driver = new ChromeDriver();
	 	 } 
	 	 
	 	e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
	 	 
	 	 
	 		 driver.manage().window().maximize();
	 		 driver.manage().deleteAllCookies();
	 		 
	 		 driver.manage().timeouts().implicitlyWait(TestUtil.implicitly_Wait, TimeUnit.SECONDS);
	 		 driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoad_Timeout, TimeUnit.SECONDS);
	 		 
	 		 driver.get(prop.getProperty("url"));
	 	 	
	}
	
}

