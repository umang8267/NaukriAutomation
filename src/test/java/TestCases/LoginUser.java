package TestCases;

import java.awt.AWTException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.testBase;
import pages.DashBoard;
import pages.Homepage;
import pages.LandingPage;
import pages.profilePage;

public class LoginUser extends testBase {
	Homepage homepage ;
	@Test
	public void LoginUsertoNaukriAPk() throws AWTException, InterruptedException {
		LandingPage Lp =new LandingPage(driver);

		Lp.clickingLogin();
		Lp.userLoginWithEmail(p.getProperty("email"), p.getProperty("pwd"));
//		wait.until(ExpectedConditions.vi(expectedUrl));
		String expectedUrl = "https://www.naukri.com/mnjuser/homepage";
		
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Login failed!");
		
		 homepage =new Homepage(driver);      
		 homepage.ClickingProfileBtn();
		 
		 profilePage PP=new profilePage(driver);
		 PP.UpdatingProfileSummary();
	
	}

}
