import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileDownload {

	public static void main(String[] args) {
		String filePath = System.getProperty("user.dir") + File.separator + "JenkinsDownload";
		File file = new File(filePath);
		if (!file.exists()) {
			System.out.println("Jenkins folder not present");
			if (file.mkdir()) {
				System.out.println("Created jenkins download folder");
			}
		}
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("download.default_directory", filePath);
		prefs.put("download.prompt_for_download", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		WebDriver wd = new ChromeDriver(options);
		wd.get("https://get.jenkins.io/war-stable/2.528.2/jenkins.war");
		File f = new File(filePath, "jenkins.war");
		while (!f.exists()) {
			System.out.println("Waiting....");
		}
		if (f.exists()) {
			System.out.println("File downloaded successfully");
		}

	}

}
