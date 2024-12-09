package Section09;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L04_Screenshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")
						+ File.separator + "src"
						+ File.separator + "main"
						+ File.separator + "java"
						+ File.separator + "drivers"
						+ File.separator + "chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.automationtesting.co.uk/");
		driver.manage().window().maximize();

		takeSnapShot(driver);

	}

	public static void takeSnapShot(WebDriver webdriver) throws IOException {
		File srcFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);

		File destFile = new File("C:\\Users\\sbrun\\OneDrive - Learn Automation\\Desktop\\Resources\\screenshots\\"
				+ timestamp() + ".png");

		FileUtils.copyFile(srcFile, destFile);

	}

	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}
