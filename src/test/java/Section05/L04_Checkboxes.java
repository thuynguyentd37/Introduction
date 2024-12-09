package Section05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

public class L04_Checkboxes {

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

		driver.get("https://www.automationtesting.co.uk/dropdown.html");

		// tests the first check box which is ticked on page load
		System.out.println(driver.findElement(By.cssSelector("input#cb_red")).isSelected());

		// tests the second check box which is not ticked on page load
		System.out.println(driver.findElement(By.cssSelector("input#cb_green")).isSelected());

	}

}
