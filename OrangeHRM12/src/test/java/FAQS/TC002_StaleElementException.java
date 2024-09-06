package FAQS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class TC002_StaleElementException {
	
	
	WebDriver driver;
	String str= "//*[@id='btAdd']";
	String str1="//*[@id='tb1']";
	//https://www.seleniumhq.org/exceptions/stale_element_reference.jsp

	@Test
	public void Open_Mercury() throws Exception {
		
		//OpenChromeVrowser
		driver = TestBrowser.OpenChromeBrowser();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//OpenUrl
		driver.get("https://www.encodedna.com/2013/07/dynamically-add-remove-form-elements-using-jquery-demo.htm");

		
		
		
		findElement(By.xpath(str)).click();
		findElement(By.xpath(str1));
		
		WebElement elemenet1 = findElement(By.xpath(str1));
		//String str=elemenet1.getText();

		
		
		findElement(By.xpath("//*[@id='btRemove']")).click();
		
		String str=elemenet1.getText();
		System.out.println("Str Text :"+str );
		//String str=elemenet1.getText();
		//System.out.println("Str Text :"+str );
		
		
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
