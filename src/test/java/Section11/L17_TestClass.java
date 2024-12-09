package Section11;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Section11.L17_ITestListener.class)

public class L17_TestClass {
	
	WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")
						+ File.separator + "src"
						+ File.separator + "main"
						+ File.separator + "java"
						+ File.separator + "drivers"
						+ File.separator + "chromedriver");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://teststore.automationtesting.co.uk/login?back=my-account");
		Thread.sleep(3000);
	}

	@Test
	public void enterEmail() throws InterruptedException {
		Assert.fail();
		driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test@test.com");
		Thread.sleep(3000);
	}

	@Test
	public void enterPassword() throws InterruptedException {
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("test123");
		Thread.sleep(3000);
	}


}
