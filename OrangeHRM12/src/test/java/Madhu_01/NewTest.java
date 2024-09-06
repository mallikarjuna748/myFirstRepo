package Madhu_01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import EEE_Customer.Test2_Skills;

public class NewTest {
	WebDriver Driver;
  @Test
  public void AddSkillsTest() throws Exception {
	  NewTest Z= new NewTest();
	  Z.OpenChromeBrowser();
	  Z.OpenOrangeHRM();
	  Z.Login();

  }
	   
  public void OpenChromeBrowser() throws Exception {
	  
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		Driver =new ChromeDriver();
		Driver.manage().window().maximize() ;
  }
  
  public void OpenOrangeHRM() throws Exception {
	  Driver.get("https://opensource-demo.orangehrmlive.com/");
  }
  
  public void Login() throws Exception {
	  findElement(By.id("txtUsername")).sendKeys("Admin");
	  findElement(By.id("txtPassword")).sendKeys("admin123");
	  findElement(By.id("btnLogin")).click();
      findElement(By.id("menu_admin_viewAdminModule")).click();
      findElement(By.id("menu_admin_Job")).click();
      findElement(By.id("menu_admin_viewPayGrades")).click();
      findElement(By.id("btnAdd")).click();
      findElement(By.id("payGrade_name")).sendKeys("Admin11");
      findElement(By.id("btnSave")).click();

  }
  public   WebElement findElement(By by) throws Exception 
	{

		WebElement elem = Driver.findElement(by);  
		
		if (Driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)Driver).executeScript("arguments[0].style.border='3px solid blue'", elem);
	 
		}
		return elem;
  }
}
