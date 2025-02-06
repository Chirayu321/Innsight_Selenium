package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.types.Duration;

public class OpeningReports {
	WebDriver driver;

	public OpeningReports(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void WordCloudData(String Top) {
		WebElement reportname=driver.findElement(By.id("twWcHash1"));
		List <WebElement> Person=reportname.findElements(By.tagName("span"));
		System.out.println(Top+ ":");
		for(WebElement TopPersons : Person) {
			System.out.println(TopPersons.getText());
	}
	}

	public OpeningReports() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[1]/div[6]/div[7]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/span[2]")
	WebElement reportsclick;

	// Method to perform the action
	public void clickOnReports() {
		Actions actions = new Actions(driver);
		actions.moveToElement(reportsclick).click().perform(); // Move to the element and click
	}

	@FindBy(xpath = "//*[@id=\"rptTwitter\"]/a/span[2]")
	WebElement WordCloud;

	public void WordCloud() {
		WordCloud.click();
	}

	@FindBy(xpath = "//*[@id=\"rptHtwc\"]/span[2]")

	WebElement Trendinghash;

	public void TrendingHashtags() {
		Trendinghash.click();
	}

	@FindBy(id = "twWcHash1")
	WebElement hashtagConatiner;
	@FindBy(xpath = "//a[@id='rptmentionwc']//span[@class='menu-title'][normalize-space()='Trending Mentions']")
	WebElement TrendingMentions;
	

	public void Hashtagsveri() {
		String trending = hashtagConatiner.getText();
		System.out.println(trending);
		boolean isIndiaTrending = trending.contains("#India");

		System.out.println("#India is trending!" + isIndiaTrending);

	}

	public void Mentions() {
		TrendingMentions.click();
		
		
	}
	
	@FindBy(xpath="//span[normalize-space()='Sentiment']")
	WebElement SentimentAnalysisbutton;
	@FindBy(xpath="//*[@id=\"sentimentAnalysisRptId\"]/a/span[2]")
	WebElement SentimentAnalysisReports;
	
	
	public void SAb() {
		Actions action=new Actions(driver);
		action.moveToElement(SentimentAnalysisbutton).perform();
		SentimentAnalysisReports.click();
		
	}
	
	@FindBy(xpath="//a[@id='rptplacewc']//span[@class='menu-title'][normalize-space()='Trending Places']")
	WebElement TrendingPlaces;
	
	public void Places() {
		TrendingPlaces.click();
	}
	
	@FindBy(xpath="//a[@id='rptpersonnwc']//span[@class='menu-title'][normalize-space()='Trending Persons']")
	WebElement TrendingPeoples;

	public void Peoples() {
		TrendingPeoples.click();
	}
	
	@FindBy(xpath ="//a[@id='rptorgwc']//span[@class='menu-title'][normalize-space()='Trending Organizations']")
	WebElement TrendingOrg;
	public void TopOrganization() {
		TrendingOrg.click();
	}
	@FindBy(xpath="//span[normalize-space()='Trending users']")
	WebElement   Trendingusers   ;
	public void TrendingUser() {
		Trendingusers.click();
	}
	
	@FindBy(xpath="/html/body/div[1]/form/div/div[6]/div[7]/div[2]/div[1]/div[2]/div/div/div/div/div[6]/div[2]/div[11]/div/div[7]/a/span[2]")
	WebElement TrendingTheme;
	public void TrendingThemes() throws InterruptedException {
		
	
		 // Click "Trending Themes"
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", TrendingTheme);


	}
	
	

}
