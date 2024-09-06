package AAAA_10;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1_Login_NonStaticMethods_Paarmeters {
	
	static WebDriver driver;
	
	//Step2
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	String UserName="Admin",Password="admin123";
	String SkillName="Oracle1",SkillDescr="Oracle descr1";
	
	
  @Test
  public void LoginTest() throws Exception{
	  

	  
	  Test1_Login_NonStaticMethods_Paarmeters.OpenChromeBrowser();
	  Test1_Login_NonStaticMethods_Paarmeters.OpenOrangeHRM(TestURL);
	  Test1_Login_NonStaticMethods_Paarmeters.Login(UserName,Password);
	  Test1_Login_NonStaticMethods_Paarmeters.Add_Skills(SkillName,SkillDescr);
	  Test1_Login_NonStaticMethods_Paarmeters.CloseBrowser();

	  
		  
  }
  
  

  public static  WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}

  
  
  public static void OpenChromeBrowser() throws Exception{
  
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  
  public static void OpenOrangeHRM(String TestURL) throws Exception{
	  

		//driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.get(TestURL);
		
  }
  
  public static void Login(String UserName,String Password) throws Exception{
	  
		findElement(By.id("txtUsername")).sendKeys(UserName);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
		
  }
  
  
  public static void Add_Skills(String SkillName,String SkillDescr) throws Exception{
	  
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Qualifications")).click();
		findElement(By.id("menu_admin_viewSkills")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("skill_name")).sendKeys(SkillName);
		findElement(By.id("skill_description")).sendKeys(SkillDescr);
		findElement(By.id("btnSave")).click();
		
  }
  
  public static void CloseBrowser() throws Exception{
	  
		driver.quit();
  }
  
  
  
}
