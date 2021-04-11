package Framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Services 
{
	WebDriver driver;
	Waits WaitService = new Waits();	
		
	public void ScrollWindowDown(WebDriver driver) throws InterruptedException
    {   	
    	JavascriptExecutor js = (JavascriptExecutor) driver;    	   	
    	js.executeScript("window.scrollBy(0,1000)");    	
    }
	
	public void NavigateToPage(WebDriver driver,String Url)
	{
		driver.get(Url);		
	}

}
