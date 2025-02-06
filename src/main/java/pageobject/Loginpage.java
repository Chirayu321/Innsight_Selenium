package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	 public WebDriver driver;
	
	
	
	public Loginpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	
	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css="input#username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(className="login-button")
	WebElement submit;
	
	
	
	public OpeningReports logininnsight(String email,String pass) {
		username.sendKeys(email);
		password.sendKeys(pass);
		submit.click();
		OpeningReports openingReports=new OpeningReports(driver);
		return openingReports;
	}
	
	public void Goto() {
		driver.get("http://192.168.2.91:8080/innsight");
		
	}
	
}
