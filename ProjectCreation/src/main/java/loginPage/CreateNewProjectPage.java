package loginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;

public class CreateNewProjectPage extends TestBase
{

	public CreateNewProjectPage()
	{
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using = "//input[@id=\"divCreateProject\"]")
	WebElement createnewprojbtn;
	public CreateNewProjectPage createNewProjbtn()
	{
		createnewprojbtn.click();
		return this;
	}
	
	@FindBy(how=How.ID, using = "ctl00_ContentPlaceHolder1_txtProjectname")
	WebElement projtitle;
	public CreateNewProjectPage projectTitle(String data)
	{	 
		projtitle.sendKeys(data);
		return this;
	}
	
	public CreateNewProjectPage multipleprojects(int num)
	{
		    int noofproj=num;
			
			for(int i=1; i<noofproj;i++) 
			{
			    System.out.println("Project" + i); 
			}
			return this;
			
	}
	
	@FindBy(how=How.XPATH, using = "//input[@id=\"ctl00_ContentPlaceHolder1_chkBuilderV2\"]")
	WebElement upgradebuilder;
	public void upgradebuilder(String upgrade)
	{		
		if(upgrade.equalsIgnoreCase("Yes"))
		{
			System.out.println("Cluster 2 selected");
		}
		else if(upgrade.equalsIgnoreCase("No"))
		{
		  upgradebuilder.click();
		}
		
	}  	
	
	@FindBy(how=How.XPATH, using="//div[@id=\"ctl00_ContentPlaceHolder1_divServerType\"]/div/div/div/a/div")
	WebElement clusterdropdown;
	public void servertype(String ele)
	{
		if(ele.equalsIgnoreCase("One"))
		{
		clusterdropdown.click();
		Select clusteroregon = new Select(clusterdropdown);
		clusteroregon.deselectByValue("Oregon (us-west-2a)");
		}
		
		if(ele.equalsIgnoreCase("C2"))
	    {
	    clusterdropdown.click();	 
		Select clustervirginia = new Select(clusterdropdown);
		clustervirginia.deselectByValue("N. Virginia (us-east-1a)");
	    }
		
	}
	
	@FindBy(how=How.ID, using = "ctl00$ContentPlaceHolder1$chkECWIDEcommerce")
	WebElement ecomm;
	public void ecommchkbox(String ecomm)
	{
		if(ecomm.equalsIgnoreCase("Yes"))
		{
			upgradebuilder.click();
			System.out.println("Ecomm checkbox is selected");
		}
		else if(ecomm.equalsIgnoreCase("No"))
		{
			System.out.println("Ecomm checkbox is not selected");
		}
	}
	
	@FindBy(how=How.ID, using = "ctl00$ContentPlaceHolder1$chkBigBrands")
	WebElement bigbrands;
	public void bigbrandschkbox(String bigbrand)
	{
		if(bigbrand.equalsIgnoreCase("Yes"))
		{
			upgradebuilder.click();
			System.out.println("BigBrand checkbox is selected");
		}
		else if(bigbrand.equalsIgnoreCase("No"))
		{
			System.out.println("BigBrand checkbox is not selected");
		}
	}
	
	@FindBy(how=How.ID, using="ctl00$ContentPlaceHolder1$btnBundleChange")
	WebElement bundle;
	public void changebundlebtn()
	{
		
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"ctl00_ContentPlaceHolder1_divBundles\"]/div[1]/div/div/a/div")
	WebElement bundledropdown;
		
	@FindBy(how=How.XPATH, using = "//*[@id=\"ctl00_ContentPlaceHolder1_divBundles\"]/div[1]/div/div/a/div/a")
	WebElement bundledropdownarrow;
	public void bundletypedropdown(String bundle)
	{
	bundledropdown.click();	
	bundledropdownarrow.click();
	
	if(bundle.equalsIgnoreCase("default"))
	{
	Select defaultval = new Select(bundledropdownarrow);
	defaultval.selectByValue("Default");
	}
	  else if(bundle.equalsIgnoreCase("Ecommerce")) 
	  {
	   Select ecommerce = new Select(bundledropdownarrow);
	   ecommerce.selectByValue("E-Commerce");
	  }
	   else if(bundle.equalsIgnoreCase("Idx")) 
	   {
	    Select idxbrokerage = new Select(bundledropdownarrow);
	    idxbrokerage.selectByValue("IDX Brokerage");
	   }
	    else if(bundle.equalsIgnoreCase("Legacy")) 
	    {
	     Select Legacy = new Select(bundledropdownarrow);
	     Legacy.selectByValue("Default");
	    }
	    else if(bundle.equalsIgnoreCase("No"))
	    {
	     System.out.println("");	
	    }	    
	}
	
	@FindBy(how=How.NAME, using="ctl00$ContentPlaceHolder1$divSubmit")
	WebElement submit;
	public void submitbtn()
	{
		submit.click();
	}
	
	@FindBy(how=How.NAME, using="ctl00$ContentPlaceHolder1$btnEditPassCancel")
	WebElement cancel;
	public void cancelbutton()
	{
		cancel.click();
	}
	
	
}
