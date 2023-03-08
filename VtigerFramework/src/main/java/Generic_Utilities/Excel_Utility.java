package Generic_Utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class Excel_Utility {
	/**
	 * this method is used to fetch data from excel
	 * @param sheetName
	 * @param rownum
	 * @param colnum
	 * @return
	 * @throws Throwable
	 * @author panila
	 */
	public String getExcelData(String sheetName,int rownum,int celnum) throws Throwable
	{
		FileInputStream fes = new FileInputStream("D:\\Advance selinium\\VtigerFramework\\src\\test\\resources\\EcxelFeb.xlsx");
        Workbook book = WorkbookFactory.create(fes);
      
       //either used to dataformatter or workbook
        
         Sheet sh = book.getSheet(sheetName);
       Row row = sh.getRow(rownum);
       Cell cel = row.getCell(celnum);
        String value= cel.getStringCellValue();
        return value; 
	
	
     /*  DataFormatter format = new DataFormatter();
       String data=format.formatCellValue(book.getSheet(sheetName).getRow(rownum).getCell(celnum));
        return data;*/
	}

        /**
         * fetching the data from excel by using DataFormatter
         *  @param sheetName
	 * @param rownum
	 * @param colnum
	 * @return
	 * @throws Throwable
	 * @author panila
      */
        
	public String getExcelUsingDataFormatter(String sheetName,int rownum,int celnum) throws Throwable
	{
		FileInputStream fes1 = new FileInputStream("D:\\Advance selinium\\VtigerFramework\\src\\test\\resources\\EcxelFeb.xlsx");
        Workbook book1 = WorkbookFactory.create(fes1);
       DataFormatter format = new DataFormatter();
       String data = format.formatCellValue(book1.getSheet(sheetName).getRow(rownum).getCell(celnum));
        return data; 
	}
	}


