package com.qa.test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
	}
	
	
	@Test
	public void loginPageTitleTest()
	{
		String title = loginPage.loginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	
	@Test
	public void verifySignUpBtnTest()
	{
		String title = loginPage.verifySignUpBtn();
		System.out.println(title);
		Assert.assertEquals(title,"Cogmento CRM");
	}
	
	@Test
	public void verifyLoginBtnTest()
	{
		homePage = loginPage.verifyLoginBtn(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{	
		Thread.sleep(5000);
		driver.quit();
		
	}
	
	
	
}
