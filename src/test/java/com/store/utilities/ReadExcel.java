package com.store.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel 
{

	
	public static FileInputStream inputstream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet excelsheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static String getCellValue(String filename,String sheetname,int rowno,int cellno) 
	{
		
		try
		{
		inputstream=new FileInputStream(filename);
		 workbook=new XSSFWorkbook(inputstream);
		 excelsheet=workbook.getSheet(sheetname);
		 cell=workbook.getSheet(sheetname).getRow(rowno).getCell(cellno);
		 workbook.close();
		return cell.getStringCellValue();
		}
		
		catch (Exception e) 
		{
			return "";
		}
		 
		 }
	
	public static int getRowCount(String filename,String sheetname)
	{
		try
		{
			
		inputstream=new FileInputStream(filename);
		workbook=new XSSFWorkbook(inputstream);
		excelsheet=workbook.getSheet(sheetname);
		int ttlrows=excelsheet.getLastRowNum() + 1;
		workbook.close();
		return ttlrows;
		}
		catch (Exception e) 
		{
			
		}
		return 0;
		
	}
	
	public static int getColcount(String filename,String sheetname)
	{
		try
		{
			
		FileInputStream inputstream=new FileInputStream(filename);
	XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
		XSSFSheet excelsheet=workbook.getSheet(sheetname);
		int ttlcells=excelsheet.getRow(0).getLastCellNum();
		workbook.close();
		return ttlcells;
		}
		catch (Exception e) 
		{
			
		}
		return 0;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
