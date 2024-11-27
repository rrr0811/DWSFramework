package org.automation.generic_utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class MyDataProviderClass implements FrameworkConstants{

	@DataProvider(name = "register data provider")
	public String[][] dataProviderMethod(){
		File f = new File(EXCEL_PATH);
		FileInputStream fis = null;
		Workbook wb = null;
		try {
			fis = new FileInputStream(f);
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			
		}
		Sheet s = wb.getSheet("Sheet1");
		int rowCount = s.getPhysicalNumberOfRows();
		int cellCount = s.getRow(0).getPhysicalNumberOfCells();
		String[][] arr = new String[rowCount-1][cellCount];
		
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				arr[i-1][j]=s.getRow(i).getCell(j).toString();
				
			}
		}
		return arr;
	}
	
}
