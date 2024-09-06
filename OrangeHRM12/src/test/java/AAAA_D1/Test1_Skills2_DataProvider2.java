package AAAA_D1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

public class Test1_Skills2_DataProvider2 {
	
	
	static WebDriver driver;
	
	//String TestURL="https://opensource-demo.orangehrmlive.com/";
	//String UserName="Admin",Password="admin123";
	//String SkillName="Java19",SkillDescr="Java19 descr";
	
	
	@DataProvider(name = "SkilsData")
	public static Object[][] Authentication1TC01_Add_Nationality() throws Exception {
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//TC01Skills1.xlsx", "Sheet4");
		System.out.println(testObjArray.length);
		return (testObjArray);
	}
	
	
  @Test(dataProvider="SkilsData")//Step2
  public void SkillsTest(String Browser,String TestURL,String UserName,String Password,String SkillName,String SkillDescr ) throws Exception {
	  
	  Test1_Skills2_DataProvider2 T1= new Test1_Skills2_DataProvider2();
	  
	 // T1.OpenChromeBrowser();
	  
	  if(Browser.equalsIgnoreCase("Chrome"))
		{
			driver = TestBrowser.OpenChromeBrowser();
		 	
	    }

		if(Browser.equalsIgnoreCase("FireFox"))
		{
				driver = TestBrowser.FirefoxBrowser();
				Thread.sleep(10000);
		}
		
	  T1.OpenOrangeHRM(TestURL);
	  T1.Login(UserName,Password);
	  //T1.AddSkills(SkillName,SkillDescr);
	  T1.CloseBrowser();
	  
  }
  
  
  
  public void OpenChromeBrowser() throws Exception
  {
	  
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		
  }
  
  
  
  public void OpenOrangeHRM(String TestURL1) throws Exception
  {
		driver.get(TestURL1);
  }
  
  
  public void Login(String UserName1,String Password1) throws Exception
  {
		
		findElement(By.id("txtUsername")).sendKeys(UserName1);
		findElement(By.id("txtPassword")).sendKeys(Password1);
		findElement(By.id("btnLogin")).click();
		
  }
   
  
  public void AddSkills(String SkillName,String SkillDescr) throws Exception
  {
		
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Qualifications")).click();
		findElement(By.id("menu_admin_viewSkills")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("skill_name")).sendKeys(SkillName);
		findElement(By.id("skill_description")).sendKeys(SkillDescr);
		findElement(By.id("btnSave")).click();
  }
  
  public void CloseBrowser() throws Exception
  {
		driver.quit();
  }
  
  
  
  
  
  
  
  
  public   WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		
		 
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}

  
  
}
