package Section05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

public class L08_RadioButtons {

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

		driver.get("https://www.automationtesting.co.uk/dropdown.html");
		
		//[for='demo-priority-low']
		//[for='demo-priority-normal']
		//[for='demo-priority-high']
		
		driver.findElement(By.cssSelector("[for='demo-priority-low']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("[for='demo-priority-normal']")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.cssSelector("[for='demo-priority-high']")).click();

	}

}
