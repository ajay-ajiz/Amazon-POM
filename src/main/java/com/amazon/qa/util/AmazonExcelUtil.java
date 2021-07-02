package com.amazon.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.amazon.qa.base.TestBase;

public class AmazonExcelUtil extends TestBase {
	public AmazonExcelUtil() throws Exception {
		super();
	}

	public static Map<String,String> getMap() throws IOException
	{
		HashMap<String,String> data = new HashMap<String,String>();
		FileInputStream fileInput = new FileInputStream("C:\\Users\\INFOSYS\\eclipse-workspace\\workspace\\Amazon\\src\\main\\java\\com\\amazon\\qa\\testdata\\Amazon_TestData.xlsx");

		Workbook wb = new XSSFWorkbook(fileInput);
		Sheet sheet = wb.getSheet("Sheet1");
		int n=sheet.getLastRowNum();
		for(int i=0;i<=n;i++)
		{

			data.put(sheet.getRow(0).getCell(i).toString(),sheet.getRow(1).getCell(i).toString());
		}
	
		return data;
	}

}
