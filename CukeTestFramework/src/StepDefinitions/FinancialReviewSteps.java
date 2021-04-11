package StepDefinitions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.DriverManager;
import Framework.DriverType;
import Framework.Services;
import Pages.FinancialReviewPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FinancialReviewSteps 
{
	    // Declaring the Selenium Web Driver 
		 private WebDriver driver; 
		 DriverManager WebDriverManager = new DriverManager();		
		 Services DriverService = new Services();
		 private FinancialReviewPage finReviewPage;		 
		
		
		 @Before()
		 public void BeforeTest()
	     {
		   System.out.println("********Starting Driver************"); 		   	
		   driver = WebDriverManager.GetDriver(DriverType.Chrome);
	     }
			
	     @After()
	     public void AfterTest()
	     {
		   System.out.println("*************Closing Driver*********");
		   WebDriverManager.CloseDriver();				
		 }
			
		  @Given("^As FinancialReview User , I'm on the '(.+)' subscription Page$")
		    public void as_financialreview_user_im_on_the_subscription_page(String pageurl) throws Throwable {
			    
			    finReviewPage = new FinancialReviewPage(driver);
				finReviewPage.NavigateToSubscriptionPage(pageurl);				
		    }
		  @When("^I Scroll to bottom of window$")
		    public void i_scroll_to_bottom_of_window() throws Throwable {
			  
			  DriverService.ScrollWindowDown(driver);
		        
		    }

		    @When("^I wait for '10' seconds$")
		    public void i_wait_for_10_seconds() throws Throwable {
		        Thread.sleep(10000);
		    }

		    @Then("^I should see subscriptionPrompt appears on the subscription Page$")
		    public void i_should_see_subscriptionprompt_appears_on_the_subscription_page() throws Throwable {
		        boolean IsEnablePopUp =finReviewPage.CheckSubscriptionPromptVisible();
		    	assertTrue(IsEnablePopUp);
		    	finReviewPage.TakeScreenShot("visible");
		    }

		    @Then("^I should see subscriptionPrompt disappears on the subscription Page$")
		    public void i_should_see_subscriptionprompt_disappears_on_the_subscription_page() throws Throwable {
		    	
		    	
		    	boolean IsDisablePopUp =finReviewPage.CheckSubscriptionPromptNotVisible();
		    	assertTrue(IsDisablePopUp);
		    	finReviewPage.TakeScreenShot("notvisible");
		    }

}
