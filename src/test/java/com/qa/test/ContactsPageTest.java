package com.qa.test;

import java.util.ArrayList;
import java.util.Iterator;

//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
//import com.qa.util.TestUtil;
import com.qa.util.TestUtil;

public class ContactsPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage= new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.verifyLoginBtn(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Iterator<Object[]> testData()
	{
		ArrayList<Object[]> data = TestUtil.getDataFromExcel();
		return data.iterator();
	}
	
	
	@Test(dataProvider= "testData")
	public void createNewContactTest(String title, String firstName,String lastNAme,String company)
	{
		TestUtil.switchToFrame();
		homePage.clickNewContactBtn();
		contactsPage.createNewContact(title, firstName, lastNAme, company);
	}
	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{	
		Thread.sleep(4000);
		driver.quit();
		
	}
	

}
