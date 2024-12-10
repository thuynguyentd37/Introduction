package Section12;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class L02_Login {
	WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException, IOException {
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
		Thread.sleep(2000);

		Properties prop = new Properties();
		FileInputStream data = new FileInputStream(
				System.getProperty("user.dir")
						+ File.separator + "src"
						+ File.separator + "test"
						+ File.separator + "java"
						+ File.separator + "Section12"
						+ File.separator + "L02_config.properties");

		prop.load(data);

		driver.get(prop.getProperty("url"));
	}

	@Test
	public void signin() throws InterruptedException {

		driver.findElement(By.cssSelector("[title] .hidden-sm-down")).click();
		driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test@test.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("test123");
		driver.findElement(By.cssSelector("button#submit-login")).click();
		System.out.println("user has logged in");
		Thread.sleep(2000);
	}
}
