package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase
{
	
	//Page Factory
	@FindBy(name ="username")
	WebElement username;
	
	@FindBy(name ="password")
	WebElement password;
	
	@FindBy(xpath ="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath ="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	//initialization
public LoginPage()
{
	PageFactory.initElements(driver, this);
}

	//Actions

public String loginPageTitle()
{
	String title = driver.getTitle();
	return title;
}
	

public String verifySignUpBtn()
{	
	signUpBtn.click();
	String title = driver.getTitle();
	return title;
}

public HomePage verifyLoginBtn(String un, String pwd)
{	
	username.sendKeys(un);
	password.sendKeys(pwd);
	loginBtn.click();
	return new HomePage();
	
}
	
}
