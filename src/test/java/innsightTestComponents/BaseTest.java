package innsightTestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.Loginpage;

public class BaseTest {
	public WebDriver driver; 
	public Loginpage loginpage ;// Class-level driver (so it can be used across methods)

	public void Intializebrowser() throws IOException {
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Chirayu.Dutt\\eclipse-workspace\\Innsight_Reports_Automation\\src\\main\\java\\innsight_resources\\Globaldata.properties");
		pro.load(fis);

		String browser = pro.getProperty("browser");

		if (browser != null && browser.equalsIgnoreCase("chrome")) {
			// Use equalsIgnoreCase() for string comparison
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); // Assigning to class-level 'driver'
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		} else {
			System.out.println("Browser not supported");
		}
	}

	// This method assumes the browser has already been initialized
     @BeforeMethod
	public Loginpage launchInnsight() throws IOException {
    	 Intializebrowser();
		 loginpage = new Loginpage(driver);
		loginpage.Goto();
		// Assuming Goto() performs the navigation to the login page
		return loginpage;
	}
     public String getScreenShot(String testCaseName,WebDriver driver) throws IOException {
    	 TakesScreenshot ts = (TakesScreenshot) driver;
    	 File Source =ts.getScreenshotAs(OutputType.FILE);
    	 File file=new File(System.getProperty("user.dir")+ "//reports//" + testCaseName + ".png");
    	 FileUtils.copyFile(Source, file);
    	 return System.getProperty("user.dir") +"//reports//" + testCaseName + ".png";
     }
     
     
     
     
     
     
     
     
     
     
     
     
	@AfterMethod
	public void Driverclose() {
		driver.quit();
	}

	// Method to quit the browser (if needed)
	public void tearDown() {
		if (driver != null) {
			driver.quit(); // Close the browser
		}
	}
}
