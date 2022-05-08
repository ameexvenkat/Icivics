package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataUtility{
	
	 FileInputStream fis = null;
	 FileOutputStream fos = null;
	 XSSFWorkbook workbook = null;
	 XSSFSheet sheet = null;
	 XSSFRow row = null;
	 XSSFCell cell = null;
	 String xlFilePath;
	 
	 public ExcelDataUtility(String xlFilePath) throws Exception{
		//Log4j Configuration XML file 	
		DOMConfigurator.configure("log4j.xml"); 
		
	    this.xlFilePath = xlFilePath;
        fis = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(fis);
        fis.close();		   
	}
	 
	/**
	 * This method is used to write data into the given excel sheet
	 * @param sheetName - give the sheet name of the excel, where we have to write data
	 * @param colNumber - give column number of the particular data, which we need to write
	 * @param rowNumber - give column number of the particular data, which we need to write
	 * @param value - give the data to write into the excel sheet
	 * @author Venkataraghavan on 23/10/2017:19:55:00PM
	 * @return boolean value
	 * @throws Exception
	 */
	public boolean setCellData(String sheetName, int colNumber, int rowNumber, String value){
		try{			
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNumber);
			if (row == null)
				row = sheet.createRow(rowNumber);
			cell = row.getCell(colNumber);
			if (cell == null)
				cell = row.createCell(colNumber);
			cell.setCellValue(value);			
			fos = new FileOutputStream(xlFilePath);
			workbook.write(fos);
			fos.close();
		}catch (Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;		
	}
	
	/**
	 * This method is used to read data from the given excel sheet
	 * @param sheetName - give the sheet name of the excel, where we have to read data
	 * @param colNumber - give column number of the particular data, which we need to read
	 * @param rowNumber - give row number of the particular date, which we need to read
	 * @author Venkataraghavan on 23/10/2017:19:55:00PM
	 * @return String value
	 * @throws Exception
	 */
	public String getCellData(String sheetName, int colNumber, int rowNumber){		
		String data = null;
		try{
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNumber);
			cell = row.getCell(colNumber);
			data = cell.getStringCellValue();
			return data;						
		}catch (Exception e){
			e.printStackTrace();
			return "row "+rowNumber+" or column "+colNumber +" does not exist  in Excel";
		}				
	}	
	
	public int getTotalRowNumber(String sheetName){
		int rowNum = 0;
		sheet = workbook.getSheet(sheetName);
		rowNum = sheet.getLastRowNum();
		return rowNum;		
	}

}
