package Section09;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class L02_DesiredCapabilities {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")
						+ File.separator + "src"
						+ File.separator + "main"
						+ File.separator + "java"
						+ File.separator + "drivers"
						+ File.separator + "chromedriver");


		// Create ChromeOptions to replace DesiredCapabilities
		ChromeOptions options = new ChromeOptions();

		// Set capabilities for accepting SSL certificates
		options.setAcceptInsecureCerts(true);

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://expired.badssl.com/");
		System.out.println("Page title is: " + driver.getTitle());

		// Close the browser
		driver.quit();
	}

}
