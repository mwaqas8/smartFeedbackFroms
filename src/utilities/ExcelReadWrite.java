package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import constantVariables.ConstantVariable;
import constantVariables.Constant_Variables;

public class ExcelReadWrite 
{
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static XSSFCell cell2;
	
	public static void setExcel(String pathName)
	{
		try
		{
			File path = new File(pathName);
			FileInputStream fs = new FileInputStream(path);
			workbook = new XSSFWorkbook(fs);
			System.out.println("excel file path found");
			
		}
		catch(Exception e)
		{
			System.out.println("excel file path NOT found");
		}
	}
	
	public static String getExcelValue(String sheetName , int row, int col )
	{
		try
		{
			sheet = workbook.getSheet(sheetName);
			cell = sheet.getRow(row).getCell(col);
			
			if(cell.getCellType() == cell.CELL_TYPE_NUMERIC)
			{
				String str_cellVal = NumberToTextConverter.toText(cell.getNumericCellValue());
				return str_cellVal;
			}
			else
			{
				return cell.getStringCellValue();
			}
		}
		catch(Exception e)
		{
			System.out.println("getExcel value method not working");
		}
		return "";
	}

	public static void setExcelValue(String sheetname, int rowNum, int colNum, String result) throws Exception
	{
		try
		{
			sheet = workbook.getSheet(sheetname);
			//row = sheet.getRow(rowNum);
			cell = sheet.getRow(rowNum).getCell(colNum);
			if(cell == null)
			{
				cell = sheet.getRow(rowNum).createCell(colNum);
			}
			cell.setCellValue(result);
		
			FileOutputStream fos = new FileOutputStream(Constant_Variables.excelFilePath);
			workbook.write(fos);
			fos.close();
			workbook = new XSSFWorkbook(new FileInputStream(Constant_Variables.excelFilePath));
		}
		catch(Exception e) 
		{
			System.out.println("SetExcelValue method not working "+e);
		}
	}
}
