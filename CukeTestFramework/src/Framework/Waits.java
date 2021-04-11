package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits 
{
	WebDriver driver;
	
	public void WaitForElementVisible(WebDriver driver, WebElement element)
	{		
		WebDriverWait wait = new WebDriverWait(driver, 10);	    
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void WaitForElementClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);	    
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}   	
	

}
