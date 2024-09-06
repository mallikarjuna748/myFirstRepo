package BBB;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

public class TC01_Login_Excel {
	
	
	static WebDriver driver;
	
	//Step2 - Global Variable
	//String TestURL="https://opensource-demo.orangehrmlive.com/";
	//String UserName="Admin",Password="admin123";
	//String NationalityText="Indian768";
	
	@DataProvider(name = "TC01_Add_Nationality")
	public static Object[][] Authentication1() throws Exception {
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//TC01_Nationality3.xlsx", "Sheet1");
		System.out.println(testObjArray.length);
		return (testObjArray);
	}
	
	
  @Test(dataProvider="TC01_Add_Nationality")
  public void Login_Test(String Browser,String TestURL,String UserName,String Password,String NationalityText) throws Exception{
	  
	  TC01_Login_Excel T1=new TC01_Login_Excel();
	  
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
		
	  
	 // T1.OpenChromeBrowser();
	//  T1.FirefoxBrowser();
	  T1.OpenOrangeHRM(TestURL);     //step3
	  T1.Login(UserName,Password);   //step3
	  T1.AddNationalities(NationalityText);  //step3
	  T1.CloseBrowser();	

  }
  
  

 public void OpenOrangeHRM(String TestURL) throws Exception{
	  
		driver.get(TestURL);
  }
  
 public void Login(String UserName,String Password) throws Exception{
	  
		
		findElement(By.id("txtUsername")).sendKeys(UserName);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
		
 }
 
 public void AddNationalities(String NationalityText) throws Exception{
	  
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys(NationalityText);
		findElement(By.id("btnSave")).click();
	 
 }
 
 public void CloseBrowser() throws Exception{
	  
	 driver.quit();
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
 
  
  
  
  
}
