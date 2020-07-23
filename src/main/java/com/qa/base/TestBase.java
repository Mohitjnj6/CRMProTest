package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.util.TestUtil;

public class TestBase 
{
	public static WebDriver driver; 
	public static Properties prop;
	
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
	 	 
	 		 driver.manage().window().maximize();
	 		 driver.manage().deleteAllCookies();
	 		 
	 		 driver.manage().timeouts().implicitlyWait(TestUtil.implicitly_Wait, TimeUnit.SECONDS);
	 		 driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoad_Timeout, TimeUnit.SECONDS);
	 		 
	 		 driver.get(prop.getProperty("url"));
	 	 	
	}
	
}

