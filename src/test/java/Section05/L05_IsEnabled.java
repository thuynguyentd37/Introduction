package Section05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

public class L05_IsEnabled {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")
						+ File.separator + "src"
						+ File.separator + "main"
						+ File.separator + "java"
						+ File.separator + "drivers"
						+ File.separator + "chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.automationtesting.co.uk/buttons.html");
		
		//checks to see if button 4 is enabled (which is disabled on page load by default)
		System.out.println(driver.findElement(By.cssSelector("button#btn_four")).isEnabled());
		
		//checks to see if button 3 is enabled (which is enabled on page load by default)
		System.out.println(driver.findElement(By.cssSelector("button#btn_three")).isEnabled());
		
	}

}
