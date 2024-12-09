package Section08;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class L11_JavaScriptExecutor_Pt2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")
						+ File.separator + "src"
						+ File.separator + "main"
						+ File.separator + "java"
						+ File.separator + "drivers"
						+ File.separator + "chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://automationtesting.co.uk/contactForm.html");
		
		driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("James");
		driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys("Smith");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("james@test.com");
		driver.findElement(By.cssSelector("textarea")).sendKeys("this is a sample comment");
		
		WebElement submit = driver.findElement(By.cssSelector("[type='submit']"));
		WebElement reset = driver.findElement(By.cssSelector("[type='reset']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click(), arguments[1].click()", reset, submit);

	}

}
