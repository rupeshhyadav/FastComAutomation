
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FastCom {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();
		wd.get("https://fast.com/");
		By speedValueLocator = By.id("speed-value");
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
		WebElement speedValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedValueLocator));
		By succeedSpeedLocator = By
				.xpath("//div[contains(@class,'succeeded')]//parent::div[@class='bordered-speed-container']");
		String className;
		while (true) {
			System.out.println(speedValueElement.getText());
			className = speedValueElement.getAttribute("class");
			if (className.contains("succeeded")) {
				break;
			}

		}
		wd.close();

	}

}
