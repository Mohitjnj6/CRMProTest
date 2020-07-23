package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestUtil;

public class ContactsPage extends TestUtil
{
	//Page Factory
		@FindBy(xpath ="//td[contains(text(),'User: Demo User')]")
		WebElement user;
		
		@FindBy(xpath ="//a[contains(text(),'Contacts')]")
		WebElement contactBtn;
		
		@FindBy(xpath ="//a[contains(text(),'Deals')]")
		WebElement dealsBtn;
		
		@FindBy(xpath ="//a[contains(text(),'Tasks')]")
		WebElement signUpBtn;
		
		//initialization
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}

		//Actions

	public boolean verifyUser()
	{
		
		return user.isDisplayed();
	}
		

	public String verifyHomePageTitle()
	{	
		String title = driver.getTitle();
		System.out.println(title);
		return title;	
	}


	public ContactsPage verifyContactBtn()
	{	
		contactBtn.click();
		return new ContactsPage();
		
	}




		
	}

