package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;



public class HomePage extends TestBase
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
	
	@FindBy(xpath ="//a[contains(text(),'New Contact')]")
	WebElement newContactBtn;
	
	//initialization
public HomePage()
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

public ContactsPage clickNewContactBtn()
{	
	Actions action = new Actions(driver);
	action.moveToElement(contactBtn).build().perform();
	newContactBtn.click();
	return new ContactsPage();
}





	
}


