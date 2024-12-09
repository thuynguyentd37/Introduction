package Section11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class L09_Annotation_Pt2 {
	
	WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sbrun\\OneDrive - Learn Automation\\Desktop\\Resources\\driver_v1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}
	
	@BeforeMethod
	public void signin() throws InterruptedException {
		driver.get("http://teststore.automationtesting.co.uk/");
		driver.findElement(By.cssSelector("[title] .hidden-sm-down")).click();
		driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test@test.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("test123");
		driver.findElement(By.cssSelector("button#submit-login")).click();
		System.out.println("user has logged in");
		Thread.sleep(2000);
	}

	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.linkText("CLOTHES")).click();
		System.out.println("user has clicked the clothes link");
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void signout() throws InterruptedException {
		driver.findElement(By.cssSelector(".hidden-sm-down.logout")).click();
		System.out.println("user has logged out");
		Thread.sleep(2000);
	}

	@AfterSuite
	public void end() {
		driver.close();
		driver.quit();
	}

}
