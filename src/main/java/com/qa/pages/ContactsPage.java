package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.util.TestUtil;

public class ContactsPage extends TestUtil
{
	//Page Factory
		@FindBy(xpath ="//select[@name='title']")
		WebElement title;
	
		@FindBy(xpath ="//input[@name='first_name']")
		WebElement firstName;
		
		@FindBy(xpath ="//input[@name='surname']")
		WebElement lastName;
		
		@FindBy(xpath ="//input[@name='client_lookup']")
		WebElement company;
		
		@FindBy(xpath ="//input[@type='submit']")
		WebElement saveContact;
		
		
		
		//initialization
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}

		//Actions

	public void createNewContact(String ttl, String fn, String ln, String cmpny)
	{
		Select select = new Select(title);
		select.selectByVisibleText(ttl);
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		company.sendKeys(cmpny);
		saveContact.click();
		
	}
		

//	public String verifyHomePageTitle()
//	{	
//		String title = driver.getTitle();
//		System.out.println(title);
//		return title;	
//	}
//
//
//	public ContactsPage verifyContactBtn()
//	{	
//		contactBtn.click();
//		return new ContactsPage();
//		
//	}




		
	}

