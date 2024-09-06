package DAY0001;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01_Add_Skills_Static {
	
	static WebDriver driver ;
	
	//Step2
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	String UserName="Admin",Password="admin123";
	String SkillName="Oracle16", SkillDescr="Oracle16 descr";
	
  @Test
  public void Add_Skills() throws Exception {
	  
	  TC01_Add_Skills_Static.OpenChromeBrowser();
	  TC01_Add_Skills_Static.OpenOrangeHRM(TestURL);
	  TC01_Add_Skills_Static.Login(UserName,Password);
	  TC01_Add_Skills_Static.AddSkills(SkillName,SkillDescr);
	
  }
  
  
  
  public static void OpenChromeBrowser() throws Exception
  {
	  	//Launch Browser
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  
  public static void OpenOrangeHRM(String TestURL) throws Exception
  {
	  
		//Open Orange HRM
		driver.get(TestURL);
  }
  
  public static void Login(String Username,String Password) throws Exception
  {
	  
		//Login
		findElement(By.id("txtUsername")).sendKeys(Username);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
  }
  
  public static void AddSkills(String SkillName,String SkillDescr) throws Exception
  {

		//AddSKills
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Qualifications")).click();
		findElement(By.id("menu_admin_viewSkills")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("skill_name")).sendKeys(SkillName);
		findElement(By.id("skill_description")).sendKeys(SkillDescr);
		findElement(By.id("btnSave")).click();
	  
  }
  
  
  
  
  
  
  public static WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
  
  
}
