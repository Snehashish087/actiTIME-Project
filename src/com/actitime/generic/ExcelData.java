package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData 
{
	public static String Data(String pathname,String sheet,int rn, int cn)
	{

			
		try
		{
			FileInputStream fis=new FileInputStream(new File(pathname));
			String data=WorkbookFactory.create(fis).getSheet(sheet).getRow(rn).getCell(cn).toString();
			return data;
		}
		catch(Exception e)
		{
			return "";
		}
		
	}
	public static int getRowCount(String pathname,String sheet)
	{
		try
		{
			FileInputStream fis=new FileInputStream(new File(pathname));
			int rn=WorkbookFactory.create(fis).getSheet(sheet).getLastRowNum();
			return rn;
		}
		catch(Exception e)
		{
			return 0;
		}
		
	}
	
	public static short getCellCount(String pathname,String sheet,int rn)
	{
		try
		{
			FileInputStream fis=new FileInputStream(new File(pathname));
			short cn=WorkbookFactory.create(fis).getSheet(sheet).getRow(rn).getLastCellNum();
			return cn;
		}
		catch(Exception e)
		{
			return 0;
		}
		
	}
	
	public static void setCellData(String pathname,String Sheet,int rownum, int cellnum, String Result,  int RowNum, int ColNum) 
	{
		 
			try
			{
				FileOutputStream fos=new FileOutputStream(new File(pathname));
				Workbook wb=WorkbookFactory.create(new File(pathname));
				Sheet sh=wb.getSheet(Sheet);
				Row rn=sh.getRow(rownum);
				Cell cl=rn.getCell(cellnum);
				
				
			}
			catch (Exception e)
			{
				e.getMessage();
			}
				

	}



}
