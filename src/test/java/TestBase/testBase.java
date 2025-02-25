package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testBase {
	public WebDriver driver;
	
	public Properties p;
	public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	@BeforeClass
	public void setup() throws IOException {

		FileReader file = new FileReader("./src/test/resources/config.properties");
		p = new Properties();
		p.load(file);

//		switch (br.toLowerCase()) {
//		case "chrome":
//			driver = new ChromeDriver();
//			break;
//		case "edge":
//			driver = new EdgeDriver();
//			break;
//		case "firefox":
//			driver = new FirefoxDriver();
//			break;
//		default:
//			System.out.println("Invalid browser name..");
//			return;
//		}

		WebDriverManager.chromedriver();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
	}

	@AfterClass()
	public void teardown() {
		driver.quit();
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}
}
