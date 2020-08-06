package com.qa.util;


import java.util.ArrayList;

import com.qa.base.TestBase;



public class TestUtil extends TestBase
{
	public static long implicitly_Wait=20;
	public static long pageLoad_Timeout= 20;
	
	public static void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
		
	}
	
	static Xls_Reader reader;
	static String sheetname = "Sheet1";
	
	public static ArrayList<Object[]> getDataFromExcel()
	{
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try 
		{
			reader = new Xls_Reader("C:\\Users\\Samsung\\eclipse-workspace\\CRMproTest\\src\\main\\java\\com\\qa\\testdata\\CrmPro.xlsx");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		for(int rownmbr=2; rownmbr <= reader.getRowCount(sheetname); rownmbr++)
		{
			String title = reader.getCellData(sheetname, 0, rownmbr);

			String firstName = reader.getCellData(sheetname, 1, rownmbr);

			String lastNAme = reader.getCellData(sheetname, 2, rownmbr);
			
			String company = reader.getCellData(sheetname, 3, rownmbr);
			
			Object[] obj = {title,firstName,lastNAme,company};
			myData.add(obj);

		}
		return myData;
		
	}

	
}
