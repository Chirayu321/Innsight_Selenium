package reportsOnly;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import innsightTestComponents.BaseTest;
import pageobject.OpeningReports;

public class SentimentAnalysis extends BaseTest{
	@Test
	public void Sentiments() {
		OpeningReports openingreports = loginpage.logininnsight("kunalorg", "Kumar@123");
		openingreports.clickOnReports();
		openingreports.SAb();
	WebElement PositiveUsers=driver.findElement(By.id("positiveUsers"));
	List <WebElement> PositiveUsersname=PositiveUsers.findElements(By.tagName("a"));
	
	System.out.println( ":");
	for(WebElement TopPersons :PositiveUsersname ) {
		System.out.println(TopPersons);
		
		
	}

}
}
