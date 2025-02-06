package reportsOnly;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import abstractcomponents.Abstratcion_Methods;
import innsightTestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.Loginpage;
import pageobject.OpeningReports;

public class WordCloud extends BaseTest {

	@Test
	public void TrendingHashtags() throws IOException {

		OpeningReports openingreports = loginpage.logininnsight("kunalorg", "Kumar@123");
		openingreports.clickOnReports();
		openingreports.WordCloud();
		openingreports.TrendingHashtags();

		openingreports.Hashtagsveri();

		List<WebElement> hashtags = driver.findElements(By.xpath("//div[@id='twWcHash1']/span"));
		for (WebElement hashtag : hashtags) {
			System.out.println("Hashtags count" + hashtag.getSize());

		}

	}

	@Test
	public void TrendingMention() {
		OpeningReports openingreports = loginpage.logininnsight("kunalorg", "Kumar@123");
		openingreports.clickOnReports();
		openingreports.WordCloud();
		openingreports.Mentions();

		List<WebElement> mentions = driver
				.findElements(By.xpath("//div[@id='twWcHash1']//span[contains(text(), '@')]"));

		List<String> mentionTexts = mentions.stream().map(WebElement::getText) // Extract text
				.map(String::trim) // Trim spaces
				.collect(Collectors.toList()); // Collect into a List

		System.out.println("Total Mentions Found: " + mentionTexts.size());

		mentionTexts.forEach(mention -> System.out.println("Mention: " + mention));

	}

	@Test
	public void TrendingPlaces() {
		OpeningReports openingreports = loginpage.logininnsight("kunalorg", "Kumar@123");
		openingreports.clickOnReports();
		openingreports.WordCloud();
		openingreports.Places();
		openingreports.WordCloudData("Trending Places");

	}

	@Test
	public void Trendingpersons() {
		OpeningReports openingreports = loginpage.logininnsight("kunalorg", "Kumar@123");
		openingreports.clickOnReports();
		openingreports.WordCloud();
		openingreports.Peoples();
		openingreports.WordCloudData("Top Persons");
	}

	@Test
	public void TrendingOrganziations() {
		OpeningReports openingreports = loginpage.logininnsight("kunalorg", "Kumar@123");
		openingreports.clickOnReports();
		openingreports.WordCloud();
		openingreports.TopOrganization();
		openingreports.WordCloudData("Top Organization");

	}

	@Test
	public void TrendingUsers() {
		OpeningReports openingreports = loginpage.logininnsight("kunalorg", "Kumar@123");
		openingreports.clickOnReports();
		openingreports.WordCloud();
		openingreports.TrendingUser();
		openingreports.WordCloudData("Trending Users");

	}

	@Test
	public void TrendingThemes() throws InterruptedException {
		OpeningReports openingreports = loginpage.logininnsight("kunalorg", "Kumar@123");
		openingreports.clickOnReports();
		openingreports.WordCloud();
		openingreports.TrendingThemes();
		openingreports.WordCloudData("Trending Themes");

	}
	
	
}
