package Section12;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class L03_Login {
	WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException, IOException {

		Properties prop = new Properties();
		FileInputStream data = new FileInputStream(
				System.getProperty("user.dir")
						+ File.separator + "src"
						+ File.separator + "test"
						+ File.separator + "java"
						+ File.separator + "Section12"
						+ File.separator + "L03_config.properties");
		prop.load(data);

		if (prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ File.separator + "src"
							+ File.separator + "main"
							+ File.separator + "java"
							+ File.separator + "drivers"
							+ File.separator + "chromedriver");
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ File.separator + "src"
							+ File.separator + "main"
							+ File.separator + "java"
							+ File.separator + "drivers"
							+ File.separator + "geckodriver");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ File.separator + "src"
							+ File.separator + "main"
							+ File.separator + "java"
							+ File.separator + "drivers"
							+ File.separator + "msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);

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
