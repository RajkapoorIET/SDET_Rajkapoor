package com.DataProvidersUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XcelData {
	
	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFCellStyle cellStyle;
	String path;
	
	public XcelData(String path) {
		// TODO Auto-generated constructor stub
		path =this.path;
	}
	public int getRowCount(String sheetName) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fis.close();
				
		return rowcount;
	}
	public int getCellCount(String sheetName, int rownum) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		int cellcount = sheet.getRow(rownum).getLastCellNum();
		workbook.close();
		fis.close();
				
		return cellcount;
	}

	public String getCellData(String sheetName,int rownum, int column) throws IOException {
		fis= new FileInputStream(path);
		workbook= new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		cell = sheet.getRow(rownum).getCell(column);
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);
		}
		catch(Exception e) {
			data="";
		}
		workbook.close();
		fis.close();
		
		return data;
	}
	
	public void setCellData(String sheetName,int rownum, int column, String data) throws IOException {
		File f = new File(path);
		if(f.exists()) {
			workbook =  new XSSFWorkbook();
			fos = new FileOutputStream(path);
			workbook.write(fos);
		}
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		
		if(workbook.getSheetIndex(sheetName)==-1) {
			workbook.createSheet(sheetName);
			
		}
		sheet =workbook.getSheet(sheetName);
		if(sheet.getRow(rownum)==null) {
			sheet.createRow(rownum);
		}
		row = sheet.getRow(rownum);
		cell= row.createCell(column);
		cell.setCellValue(data);
		fos = new FileOutputStream(path);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}
	
	
	public void fillGreenColor(String sheetName,int rownum, int column) throws IOException {
		fis = new FileInputStream(path);
		workbook =  new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		cell = sheet.getRow(rownum).getCell(column);
		cellStyle =  workbook.createCellStyle();
		cellStyle.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(cellStyle);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}

    public void fillRedColor(String sheetName,int rownum, int column) throws IOException {
    	fis = new FileInputStream(path);
    	workbook = new XSSFWorkbook(fis);
    	sheet = workbook.getSheet(sheetName);
    	cell = sheet.getRow(rownum).getCell(column);
    	cellStyle = workbook.createCellStyle();
    	cellStyle.setFillBackgroundColor(IndexedColors.RED.getIndex());
    	cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    	cell.setCellStyle(cellStyle);
    	workbook.write(fos);
    	workbook.close();
    	fis.close();
    	fos.close();
    	
    }
	
	
}
