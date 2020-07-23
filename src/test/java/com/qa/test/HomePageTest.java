package com.qa.test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class HomePageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage= new LoginPage();
		homePage = loginPage.verifyLoginBtn(prop.getProperty("username"), prop.getProperty("password"));
		 
	}
	
	
	@Test
	public void verifyHomePageTitleTest()
	{
		String title = homePage.verifyHomePageTitle();
		
		Assert.assertEquals(title,"CRMPRO");
	}
	
	
	@Test
	public void verifyUserTest()
	{	
		TestUtil.switchToFrame();
		boolean title = homePage.verifyUser();
		Assert.assertTrue(title);
	}
	
	@Test
	public void verifyContactBtnTest()
	{	
		TestUtil.switchToFrame();
		contactsPage = homePage.verifyContactBtn();
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{	
		Thread.sleep(1000);
		driver.quit();
		
	}
	
	
	
}
