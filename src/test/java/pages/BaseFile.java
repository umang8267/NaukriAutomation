package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseFile {
	WebDriver driver;
	public WebDriverWait wt;
	
	   public BaseFile(WebDriver driver) {
	        this.driver = driver;
	        this.wt = new WebDriverWait(driver, Duration.ofSeconds(20)); // Set appropriate timeout
	        PageFactory.initElements(driver, this);
	    }
}
