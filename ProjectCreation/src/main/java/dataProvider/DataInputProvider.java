package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataInputProvider
{
	public static int rowCount;
	
	public static Object[][] datasheet() throws Exception {
		Object[][] data = null;

		try{
			FileInputStream fis = new FileInputStream(new File("D:\\Selenium Workspace\\ProjectCreation\\DataInputprovider\\Datafetch.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			//workbook.setMissingCellPolicy(MissingCellPolicy.CREATE_NULL_AS_BLANK);
			XSSFSheet sheet = workbook.getSheetAt(0);
			rowCount = sheet.getLastRowNum();
			int columnCount = sheet.getRow(0).getLastCellNum();
			data = new String[rowCount][columnCount];

			
			
			for (int i = 2; i < rowCount; i++) {
				try {
					XSSFRow row = sheet.getRow(i);
					for (int j = 0; j < columnCount; j++) {
						try {
							String cellValue = "";
							try {
								cellValue = row.getCell(j).getStringCellValue().toString();
							} catch (NullPointerException e) {

							}
							data[i][j] = cellValue;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			fis.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;

			  }
	}



