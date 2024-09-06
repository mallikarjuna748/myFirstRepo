package Day_026_TakeScreenShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import java.text.SimpleDateFormat;
import java.util.Date;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.annotations.Test;



public class Test5 {
	
	static WebDriver driver;


	
	
	@Test
	public void AddNationalitiess() throws Exception
	{
		Test5 t1= new Test5();
		
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().window().maximize() ;	
	// File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	// FileUtils.copyFile(scrFile, new File("C:\\ScreenShot1.jpg"));
	
	 driver.get("https://opensource-demo.orangehrmlive.com/");
	 t1.TakeScreenshot(driver);
	 
	
	 
	 	findElement(By.id("txtUsername")).sendKeys("Admin");
		 t1.TakeScreenshot(driver);
		 
	   findElement(By.id("txtPassword")).sendKeys("admin123");
		 t1.TakeScreenshot(driver);
		 
	   findElement(By.id("btnLogin")).click();
		 t1.TakeScreenshot(driver);
	  

		
	
	
	
	}
	
	
	public void TakeScreenshot(WebDriver driver) throws IOException
	{
		
		 SimpleDateFormat sdfDate = new SimpleDateFormat("dd_MMM_yyyy h_mm_ss_SSS a"); 
		 Date now = new Date();
		 String strDate = sdfDate.format(now);
		 
		 System.out.println("strDate:"+strDate);
		 //10_May_2021 8_55_09_280 AM
	
		  String fileWithPath= "C:\\TC029_Login" +"\\"+strDate+".png";
		
		  TakesScreenshot scrShot4=null;
		  
		  scrShot4 =((TakesScreenshot)driver);
		  File SrcFile4=scrShot4.getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(SrcFile4, new File(fileWithPath));
	}
	
	
	
	
	
	 public  static WebElement findElement(By by) throws Exception 
		{
					
			 WebElement elem = driver.findElement(by);    	    
			
			 
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			
			return elem;
		}
	 
	
	
	
	
	
	
	
	
	
	
	

}
