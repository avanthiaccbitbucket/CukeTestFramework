package Framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager 
{
	WebDriver driver;
	
	public WebDriver GetDriver(DriverType Type)
	{
		if(driver == null)
		{
			driver = CreateDriver(Type);
		}		
		
		return driver;
	}
	
	public WebDriver CreateDriver(DriverType Type)
	{  	
		switch(Type)
		{		
			case Chrome:
			    // Implement Code for ChromeDriver
				System.setProperty("webdriver.chrome.driver", "C:\\CukeTestFramework\\Tools\\chromedriver.exe");
				driver = new ChromeDriver();   
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    driver.manage().window().maximize();
			    break;
			  
			case IE:
				  // Implement Code for IE Driver
				driver = new InternetExplorerDriver();   
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				break;
				  
			case Firefox:
				  // Implement Code for FireFox
				driver = new FirefoxDriver();   
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    driver.manage().window().maximize();
				break;	
				
			case Safari:
				  // Implement Code for FireFox
				driver = new SafariDriver();   
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    driver.manage().window().maximize();
				break;			
		
		
		}
		
		return driver;
	}
	
	public void CloseDriver()
	{
		driver.close();
		driver.quit();
	}

}
