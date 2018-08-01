package testCases;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProvider.DataInputProvider;
import loginPage.CreateNewProjectPage;
import loginPage.LoginPage;
import testBase.TestBase;


public class TestCases extends TestBase
{
	TestBase browser = new TestBase();
	LoginPage login = new LoginPage();
	CreateNewProjectPage newproj = new CreateNewProjectPage();
	public static DataFormatter formatter = new DataFormatter();	
	
	@DataProvider(name="test1")
	public Object[][] loginData() throws Exception 
	{
		Object[][] arrayObject = DataInputProvider.datasheet();
		return arrayObject;
	} 
	
	@Test(dataProvider="test1")
	public void createnewproj(String data1,String data2, String data3, 
			String cellvalue4,String cellvalue5,String cellvalue6,String cellvalue7,String cellvalue8)
	{
		browser.initialization(data1);
		browser.environment(data2);
		login.username();
		login.password();
		login.loginbtn();
		newproj.createNewProjbtn();
		newproj.projectTitle(data3);
		newproj.servertype(cellvalue4);
		newproj.bundletypedropdown(cellvalue5);
		newproj.upgradebuilder(cellvalue6);
		newproj.ecommchkbox(cellvalue7);
		newproj.bigbrandschkbox(cellvalue8);
		//newproj.submitbtn();
	}
	
}
		
new classs
