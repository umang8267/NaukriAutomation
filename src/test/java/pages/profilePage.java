package pages;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class profilePage extends BaseFile {

	// Constructor
	public profilePage(WebDriver driver) {
		super(driver);
	}

	// Web Elements
	@FindBy(xpath = "//div[@class=\"widgetHead\"]/span[contains(text(),'Profile summary')]")
	WebElement profileSummary;

	@FindBy(xpath = "//div[@class='profileSummary']//div[@class='card']//div//span[@class='edit icon'][normalize-space()='editOneTheme']")
	WebElement editOneTheme;

	@FindBy(xpath = "//a[normalize-space()='View profile']")
	WebElement viewProfile;

	@FindBy(xpath = "//input[@value='Update resume']")
	public WebElement uploadresume;
	@FindBy(xpath = "//span[@id='attachCVMsgBox']")
	public WebElement SucessfulUpload;

	// ✅ Upload Resume
	public void UpdatingProfileSummary() throws AWTException, InterruptedException {

//		JavascriptExecutor js = (JavascriptExecutor) driver;

		wt.until(ExpectedConditions.elementToBeClickable(uploadresume));
		Actions act = new Actions(driver);
		act.moveToElement(uploadresume).click().perform();

		Thread.sleep(6000);
		Robot robot = new Robot();
		robot.delay(1000);

		// ✅ Upload File Using Robot Class
		StringSelection filePath = new StringSelection(
				"C:\\Users\\umang\\eclipse-workspace\\NaukriAutomation\\src\\test\\resources\\Resume.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

		// Paste file path
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.delay(500);

		// Press "Enter" to confirm
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		 System.out.println("File Uploaded");
//        wt.until(ExpectedConditions.visibilityOf(SucessfulUpload));
		 Thread.sleep(3000);
		 
		    boolean isUploaded = false;
		    try {
		        wt.until(ExpectedConditions.visibilityOf(SucessfulUpload));
		        isUploaded = SucessfulUpload.isDisplayed();
		    } catch (Exception e) {
		        isUploaded = false;
		    }

		    // ✅ Assert Upload Success
		    Assert.assertTrue(isUploaded, "❌ Resume upload failed: Success message not visible!");

		    System.out.println("✅ Upload Confirmation Message Displayed.");
	}

}