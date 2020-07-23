package com.qa.util;


import com.qa.base.TestBase;

public class TestUtil extends TestBase
{
	public static long implicitly_Wait=20;
	public static long pageLoad_Timeout= 20;
	
	public static void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
		
	}
	
}
