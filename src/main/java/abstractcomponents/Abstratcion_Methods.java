package abstractcomponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Abstratcion_Methods {
	WebDriver driver;

	public void WordCloudData(String Top) {
		WebElement reportname=driver.findElement(By.id("twWcHash1"));
		List <WebElement> Person=reportname.findElements(By.tagName("span"));
		System.out.println(Top+ ":");
		for(WebElement TopPersons : Person) {
			System.out.println(TopPersons.getText());
	}

}
}
