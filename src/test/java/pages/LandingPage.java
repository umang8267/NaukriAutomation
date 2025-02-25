package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends BaseFile{

	public LandingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement clickLogin;

	@FindBy(xpath = "//input[@placeholder='Enter your active Email ID / Username']")
	WebElement enterYourActiveEmailID;
	@FindBy(xpath = "//input[@placeholder='Enter your password']")
	private WebElement enterYourPassword;
	@FindBy(xpath = "//button[contains(@type,'submit')]")
	WebElement UserLogin;
	@FindBy(xpath = "//a[normalize-space()='View profile']")
	 WebElement viewProfile;
	
	public void clickingLogin() {
		clickLogin.click();
	}
	public void userLoginWithEmail(String Email,String pass) {
		enterYourActiveEmailID.sendKeys(Email);
		enterYourPassword.sendKeys(pass);
		UserLogin.submit();
		wt.until(ExpectedConditions.visibilityOf(viewProfile));

	}
}
