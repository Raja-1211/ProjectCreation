package loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class LoginPage extends TestBase
{
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(how=How.XPATH, using = "//input[@id='txtUsername']")
	WebElement username;
	
	public LoginPage username()
	{
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("raja.kulandairaju");
		username.sendKeys("raja.kulandairaju");
		return this;
	}
	
	@FindBy(how=How.XPATH, using= "//span[@id='spnPassword']")
	WebElement password;
	public LoginPage password()
	{
		password.click();
		password.sendKeys(prop.getProperty("Password"));
		return this;
	}
	
	@FindBy(how=How.NAME, using = "Button1")
	WebElement loginbtn;
	public CreateNewProjectPage loginbtn()
	{
		new login page method in branch
		loginbtn.click();
		return new CreateNewProjectPage();
	}
}

