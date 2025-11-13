
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class penCode {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();
		wd.get("https://codepen.io/pen/");
		By allEditorlocator = By.cssSelector("div.CodeMirror");
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(20));
		List<WebElement> allEditorlist = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allEditorlocator));
		WebElement cssElement = allEditorlist.get(1);
		By cssTextAreaLocator = By.tagName("textarea");
		WebElement cssTextAreaElement = cssElement.findElement(cssTextAreaLocator);
		Actions ac = new Actions(wd);
		ac.click(cssTextAreaElement);
		ac.perform();
		cssTextAreaElement.sendKeys("I'm Rupesh");

	}

}
