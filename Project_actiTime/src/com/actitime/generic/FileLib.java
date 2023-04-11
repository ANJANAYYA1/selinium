package com.actitime.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {

	public String getpropertyData(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./data/CommonData.property");
		Properties p=new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return(data);
	}
	
	public String getExcelData(String sheetname,int row,int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream("./data/TestScript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	
	public void setExcelData(String sheetname,int row,int cell,String data) throws IOException
	{
		FileInputStream fis=new FileInputStream("./data/TestScript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(row).getCell(cell).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./data/TestScript.xlsx");
		wb.write(fos);
		wb.close();
	}
}
