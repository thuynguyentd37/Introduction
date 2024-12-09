package Section05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

public class L07_Alerts {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")
						+ File.separator + "src"
						+ File.separator + "main"
						+ File.separator + "java"
						+ File.separator + "drivers"
						+ File.separator + "chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.automationtesting.co.uk/popups.html");

		driver.findElement(By.cssSelector("[onclick='alertTrigger\\(\\)']")).click();

		// slowing the test down for demonstration purposes
		Thread.sleep(3000);

		// switching to the alert and clicking the ok button
		driver.switchTo().alert().accept();

	}

}
