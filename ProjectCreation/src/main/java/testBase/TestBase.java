package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase
{
		
	public WebDriver driver;
	public Properties prop;
	public static String datasheetname;
	
	public TestBase()
	{
	try 
	{
		FileInputStream ip = new FileInputStream("D:\\Selenium Workspace\\ProjectCreation\\src\\main\\java\\config\\config.properties");
		prop = new Properties();
		prop.load(ip);
	} catch (FileNotFoundException e) 
	{
		System.out.println("File not found exception");
	} catch (IOException e) 
	{
		e.printStackTrace();
	}
}
	
	public void initialization(String browser)
    {
    	
    	if(browser.equalsIgnoreCase("Chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Workspace\\ProjectCreation\\drivers\\chromedriver.exe");
    		driver = new ChromeDriver();
    	} else if(browser.equalsIgnoreCase("Firefox"))
    	{
    		System.setProperty("webdriver.gecko.driver", "D:\\Selenium Workspace\\ProjectCreation\\drivers\\geckodriver_64bit.exe");
    		driver = new FirefoxDriver();
    	} 
    	
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    }
	
	public void environment(String env)
	{
		if(env.equalsIgnoreCase("QA"))
		{
    	driver.get("https://pro.qa.cmlmediasoft.com/authentication/Login.aspx");
		}
		if(env.equalsIgnoreCase("Dev"))
		{
    	driver.get("https://pro.dev.cmlmediasoft.com/authentication/Login.aspx");
		}
		if(env.equalsIgnoreCase("Staging"))
		{
    	driver.get("https://prostaging.mopro.com/authentication/Login.aspx");
		}
		if(env.equalsIgnoreCase("Production"))
		{
    	driver.get("https://pro.mopro.com/authentication/Login.aspx");
		}
		 
     }       
}

NEW BASE CLASS Added data
