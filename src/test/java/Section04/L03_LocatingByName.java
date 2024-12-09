package Section04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class L03_LocatingByName {

	public static void main(String[] args) {
		// Set the path to ChromeDriver
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")
						+ File.separator + "src"
						+ File.separator + "main"
						+ File.separator + "java"
						+ File.separator + "drivers"
						+ File.separator + "chromedriver");

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.automationtesting.co.uk/contactForm.html");
		
		driver.findElement(By.name("first_name")).sendKeys("abcd");

		driver.close();
		
	}

} 
