package com.DataProvidersUtilities;
import java.io.IOException;

import org.testng.annotations.*;
public class DataProviders {
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException{
		String path= System.getProperty("user.dir")+"//testData//Userdata.xlsx";
		XcelData xl = new XcelData(path);
		int rownum= xl.getRowCount("sheet1");
		int cellnum = xl.getCellCount("sheet1", 1);
		String ApiData[][] = new String[rownum][cellnum];
		for(int i=0;i<=rownum;i++) {
			for(int j=0;j<=cellnum;j++) {
				ApiData[i][j]= xl.getCellData("sheet1", i, j);
			}
		}
		
		return ApiData;
		
				
	}
	
	@DataProvider(name="UserName")
	public String[] getUserName() throws IOException{
		String path= System.getProperty("user.dir")+"//testData//Userdata.xlsx";
		XcelData xl = new XcelData(path);
		int rownum = xl.getRowCount("sheet1");
		String apiData[] = new String[rownum];
		for(int i=0;i<=rownum;i++) {
			apiData[i]= xl.getCellData(path, i, 1);
		}
		return apiData;
	}

}
