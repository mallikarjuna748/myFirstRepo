package Day_007_TestNG_DataProvider_Lab3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;



public class TC02_Add_Locations {
	
	
	static WebDriver driver;
	
	@DataProvider(name = "TC01_Add_Nationality")
	public static Object[][] Authentication1() throws Exception {
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C:\\HTML Report\\HTML Report\\OrangeHRM6\\TC01_Locations.xlsx","Sheet4");
		System.out.println(testObjArray.length);
		return (testObjArray);
	}
 

	@Test(dataProvider="TC01_Add_Nationality")
	public void Login_Test(String Browser,String TestURL,String UserName,String Password,String Name,String Country) throws Exception
	{
		
					if(Browser.equalsIgnoreCase("Chrome"))
					{
						 driver=TestBrowser.OpenChromeBrowser();
						
						//driver=driver1;
					 	
				    }

					if(Browser.equalsIgnoreCase("FireFox"))
					{
							driver = TestBrowser.FirefoxBrowser();
							//driver=driver2;
							Thread.sleep(10000);
					}
					
					
					if(Browser.equalsIgnoreCase("IE"))
					{
							driver = TestBrowser.OpenIEBrowser();
							Thread.sleep(10000);
					}
					
					
					if(Browser.equalsIgnoreCase("RemoteWebDriver1_Chrom"))
					{
							driver = TestBrowser.RemoteWebDriver();
							Thread.sleep(10000);
					}
					
					
					
					
					
					
					TC02_Add_Locations TN= new TC02_Add_Locations();
					
					TN.OpenOrangeHRM(TestURL);
					TN.Login(UserName,Password);
					TN.AddLocations(Name,Country);
					driver.quit();
	}
	
	
	
	public  void Login(String UserName,String Password) throws Exception
	{
		findElement(By.name("txtUsername")).sendKeys(UserName);
		findElement(By.name("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();

	}
	
	
	public  WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		
		 
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}
 
	
	
	
	
	
	public  void OpenOrangeHRM(String Testurl) throws Exception
	{
		
		driver.get(Testurl);
	}
	
	
	
	
	public    void AddLocations(String Name,String Country) throws Exception
	{
		
	
		
		Thread.sleep(5000);
		
		
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Organization")).click();
		findElement(By.id("menu_admin_viewLocations")).click();
		findElement(By.id("btnAdd")).click();
		
	
		findElement(By.id("location_name")).sendKeys(Name);
		
		
		Select dropdown1 = new Select(driver.findElement(By.id("location_country")));
		dropdown1.selectByVisibleText(Country);
		
		findElement(By.id("btnSave")).click();
		
	}
	


}
