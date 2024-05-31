package com.jdbcConnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HashMapToXcel {
 public static Scanner sc;
	@BeforeClass
	public void intializeValues() {
		 sc= new Scanner(System.in);
	}
	
	@Test(priority = 0)
	public void hashMapToExcelSheet() throws IOException {
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("sheet1");
		HashMap<String, String> hm = new HashMap<String,String>();
		hm.put("1", "abc");
		hm.put("2", "abce");
		hm.put("3", "abcw");
		hm.put("4", "abcq");
		hm.put("5", "BSDNSabcq");
		int rowno=0;
		for(@SuppressWarnings("rawtypes") HashMap.Entry entry:hm.entrySet()) {
			XSSFRow row = sheet.createRow(rowno++);
			row.createCell(0).setCellValue((String)entry.getKey());
			row.createCell(1).setCellValue((String)entry.getValue());
		}
		FileOutputStream fos = new FileOutputStream("excelwork.xlsx");
		workbook.write(fos);
		
		System.out.println("Data copied to excel file");
	}
	@Test(priority = 1)
	public void excelToHashMap() throws IOException {
		FileInputStream fos = new FileInputStream("excelwork.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fos);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		HashMap<String, String> hm =  new HashMap<>();
		for(int r=0;r<=sheet.getLastRowNum();r++) {
			String key = sheet.getRow(r).getCell(0).getStringCellValue();
			String value = sheet.getRow(r).getCell(1).getStringCellValue();
			hm.put(key, value);
		}
		Iterator<Entry<String,String>> newiterator = hm.entrySet().iterator();
		while(newiterator.hasNext()) {
			Map.Entry<String, String> newMap = (Map.Entry<String, String>)
					newiterator.next();
			System.out.println(newMap.getKey()+ " | "+newMap.getValue());
		}
		workbook.close();
		fos.close();
		
	}
	

}
