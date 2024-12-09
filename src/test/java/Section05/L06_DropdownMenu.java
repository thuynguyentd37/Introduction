package Section05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;

public class L06_DropdownMenu {

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
		
		Select menuItem = new Select(driver.findElement(By.cssSelector("select#cars")));
		
		//selecting by visible text as it appears on the web page:
		menuItem.selectByVisibleText("Honda");
		
		//selecting by option value (as it appears in the HTML):
		menuItem.selectByValue("jeep");
		
		
	}

}
