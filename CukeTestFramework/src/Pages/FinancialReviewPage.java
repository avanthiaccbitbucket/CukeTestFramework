package Pages;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.Services;
import Framework.Waits;

public class FinancialReviewPage {
	// Step 1: Web Elements for the Web UI elements

	WebDriver driver;
	Waits WaitService = new Waits();
	Services DriverService = new Services();

	@FindBy(xpath = "//div[@class='Y7Y5d _1OU0K']")
	WebElement SubcriptionPrompt;

	@FindBy(xpath = "//div[@data-testid='SubscriptionPrompt-true']")
	WebElement SubcriptionPromptVisible;

	@FindBy(xpath = "//div[@data-testid='SubscriptionPrompt-false']")
	WebElement SubcriptionPromptNotVisible;

	// Step 2: Constructor to initialize Web Elements using page factory

	public FinancialReviewPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	// Step 3: Define User action Methods for this page

	public void NavigateToSubscriptionPage(String pageUrl) {
		DriverService.NavigateToPage(driver, pageUrl);
		System.out.println("User On the SubcriptionPage");
	}

	public boolean CheckSubscriptionPromptVisible() throws InterruptedException {
		WaitService.WaitForElementClickable(driver, SubcriptionPromptVisible);		
		boolean isEnabled = SubcriptionPromptVisible.isEnabled();
		return isEnabled;

	}

	public boolean CheckSubscriptionPromptNotVisible() throws InterruptedException {
		boolean isDisabled = SubcriptionPromptNotVisible.isEnabled();
		System.out.println(SubcriptionPrompt.getAttribute("data-testid").toString());
		return isDisabled;

	}

	public void TakeScreenShot(String visibleType) {
		try {
			WaitService.WaitForElementVisible(driver, SubcriptionPromptVisible);
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(".\\screenshots\\screenshot_" + visibleType + ".png"));
		} catch (Exception e) {
			e.getMessage();
		}

	}

}
