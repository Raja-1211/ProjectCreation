package dataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import testCases.TestCases;

public class DataInputProvider2 extends TestCases
{
	 public static Object[][] datasheet() throws IOException
	 {
		 FileInputStream fis = new FileInputStream("D:\\Selenium Workspace\\ProjectCreation\\DataInputprovider\\Datafetch.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);     //get my Row which start from 0   
 
    /*int RowNum = sheet.getPhysicalNumberOfRows();// count my number of Rows
    int ColNum= sheet.getLastRowNum(); // get last ColNum 
*/    
    int RowNum = sheet.getLastRowNum();
	int ColNum = sheet.getRow(0).getLastCellNum();
     
    Object Data[][]= new Object[RowNum][ColNum]; // pass my  count data in array
     
        for(int i=2; i<RowNum; i++) //Loop work for Rows
        {  
            XSSFRow row= sheet.getRow(i);
             
            for (int j=0; j<ColNum; j++) //Loop work for colNum
            {
                if(row==null)
                    Data[i][j]= "";
                else
                {
                    XSSFCell cell= row.getCell(j);
                    if(cell==null)
                        Data[i][j]= ""; //if it get Null value it pass no data 
                    else
                    {
                        String value = formatter.formatCellValue(cell);
                        Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                    }
                }
            }
        }

    return Data;
}
}

