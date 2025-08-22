package pages;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class BaseFile {
//	WebDriver driver;
//	public WebDriverWait wt;
//	
//	   public BaseFile(WebDriver driver) {
//	        this.driver = driver;
//	        this.wt = new WebDriverWait(driver, Duration.ofSeconds(20)); // Set appropriate timeout
//	        PageFactory.initElements(driver, this);
//	    }
//}
//package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseFile {

    protected WebDriver driver;
    protected WebDriverWait wt;

    // Constructor
    public BaseFile(WebDriver driver) {
        this.driver = driver;
        this.wt = new WebDriverWait(driver, Duration.ofSeconds(10)); // default wait
    }

    // Wait until the element is visible
    public WebElement waitForVisibility(By locator) {
        return wt.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Click method
    public void click(By locator) {
        waitForVisibility(locator).click();
    }

    // Type into input field
    public void typeText(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    // Get text from an element
    public String getText(By locator) {
        return waitForVisibility(locator).getText();
    }

    // Check if element is displayed
    public boolean isElementDisplayed(By locator) {
        try {
            return waitForVisibility(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Wait until element is clickable
    public WebElement waitForClickability(By locator) {
        return wt.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
