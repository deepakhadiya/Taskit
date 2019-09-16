package com.varlet.automation.util;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {
	
	public static String getPropertyValue(String path, String key)
	{
		Properties p=new Properties();
		try
		{
		p.load(new FileInputStream(path));
		}
		catch(Exception e)
		{
			
		}
		String value=p.getProperty(key);
		return value;
	}
	
	public static String getCellValue(String path,String Sheet,int row,int cell)
	{
		String value="";
		try
		{
		value=(WorkbookFactory.create(new FileInputStream(path))).getSheet(Sheet).getRow(row).getCell(cell).toString();
		}
		catch(Exception e)
		{
		
		}
		return value;
	}
	
	public static int getRowCount(String path,String sheet)
	{
		int value=0;
		try
		{
			value=WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
		
		}
		return value;
	}

}
