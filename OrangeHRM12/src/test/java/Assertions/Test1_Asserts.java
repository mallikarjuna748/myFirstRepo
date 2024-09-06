package Assertions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Test1_Asserts {
	
	static WebDriver driver;
	
	
	
	@Test (priority = 1)
	public void OpenBrowser() throws Exception {
		
		
			//Reporter.log("This test verifies the current selenium compatibility with TestNG by launching the chrome driver");
	        //Reporter.log("Launching Google Chrome Driver version 81 for this test"); 
	        
			driver = TestBrowser.OpenChromeBrowser();
		
			driver.get("https://opensource-demo.orangehrmlive.com/");
	        
	        Reporter.log("The website used was DemoQA for this test", true);
	        String expectedTitle = "OrangeHRM";
	        String ActualTitle = driver.getTitle();
	        Assert.assertEquals(ActualTitle, expectedTitle);
	        
	        
	        
  }
}
