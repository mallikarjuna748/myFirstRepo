package  Day_010_Custimize_EmailableReport_Lab1;
import CommonUtil.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

import Day_010_Custimize_EmailableReport_Lab1.Reporter1; //step1

public class TC01_Test
{
	
	static WebDriver driver;
	Reporter1 R1;  //step2
	
	@Test
	public void TC01_Report_Test() throws Exception {
		
		driver = TestBrowser.OpenChromeBrowser();
		
		//String str= "TC01_Login";  //step3 
		R1= new Reporter1(driver,"TC01_Login1");	//step3
		
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		
		driver.get(TestURL);
		R1.TakeScreenShotAuto(driver,"Opened Orange HRM","Pass"); //step4
		 
	   
		findElement(By.id("txtUsername")).sendKeys("admin123");
		R1.TakeScreenShotAuto(driver,"Username Entered","Pass");
			

		findElement(By.id("txtPassword")).sendKeys("admin123");	
		R1.TakeScreenShotAuto(driver,"Password Entered","Pass");
		
		
		findElement(By.name("Submit"));
		R1.TakeScreenShotAuto(driver,"Clicked on Signin","Fail");
		findElement(By.name("Submit")).click();
		
		
		R1.TakeScreenShotAuto(driver,"Navigated to HomePage","Pass");
	
		
		
		driver.close();
	
	}
	
	
	

	
	// Draws a red border around the found element. Does not set it back anyhow.
	public  WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		// draw a border around the found element
		 
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}
			
		
	
	
	
	
	
	
	
	
	
	
	
	

}












