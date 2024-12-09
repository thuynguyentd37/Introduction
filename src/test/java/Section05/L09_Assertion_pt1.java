package Section05;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

public class L09_Assertion_pt1 {

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

		driver.get("https://www.automationtesting.co.uk");
		
		String pageTitle = driver.getTitle();
		
		//assertion that passes because the expected and actual value matches:
		Assert.assertEquals("Homepage1", pageTitle);
		
		//assertion that fails because of a miss match:
		Assert.assertEquals("Homepage", pageTitle);

	}

}
