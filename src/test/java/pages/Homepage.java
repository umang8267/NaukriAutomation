package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Homepage extends BaseFile{
	public Homepage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "//a[normalize-space()='View profile']")
	public WebElement viewProfile;
//	String url = driver.getCurrentUrl();
	public void ClickingProfileBtn() {
		waitForVisibility(viewProfile);
//		wt.until(ExpectedConditions.visibilityOfAllElements(viewProfile));
		viewProfile.click();
	} 
}
