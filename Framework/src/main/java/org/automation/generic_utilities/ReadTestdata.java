package org.automation.generic_utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Harsha G R
 * 
 * This class contains methods to fetch datas from the files
 * 
 */

public class ReadTestdata implements FrameworkConstants{
	
	/**
	 *  This method is used to fetch the data from properties file
	 * @param key  [String]
	 * @return value [String]
	 */
	public String readDataFromProperties(String key) {
		File f = new File(PROPERTY_FILE_PATH);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
		}
		catch(FileNotFoundException e){
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} 
		catch (IOException e) {
		}
		return prop.getProperty(key);
	}
	
	/**
	 * this method is used to fetch the data from excel
	 * @param sheet [String]--> provide sheet name
	 * @param row [int] --> provide row index
	 * @param cell [int] --> provide cell index
	 * @return data [String]
	 */
	public String readDataFromExcel(String sheet, int row, int cell)
	{
		File f = new File(EXCEL_PATH);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
		} 
		catch (FileNotFoundException e) 
		{	
		}
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(fis);
		} 
		catch (Exception e) 
		{		
		}
		String data=workbook.getSheet(sheet).getRow(row).getCell(cell).toString();
		return data;
	}
	
	public int getRowCount(String sheet) {
		File f = new File(EXCEL_PATH);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
		} 
		catch (FileNotFoundException e) 
		{	
		}
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(fis);
		} 
		catch (Exception e) 
		{		
		}
		int rowCount = workbook.getSheet(sheet).getPhysicalNumberOfRows();
		return rowCount;
	}
	
	public int cellCount(String sheet, int rowNum) {
		File f = new File(EXCEL_PATH);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
		} 
		catch (FileNotFoundException e) 
		{	
		}
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(fis);
		} 
		catch (Exception e) 
		{		
		}
		int cellCount = workbook.getSheet(sheet).getRow(rowNum).getPhysicalNumberOfCells();
		return cellCount;
	}
}
