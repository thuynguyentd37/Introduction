package Section12;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class L05_BasePage {

	public static WebDriver driver;
	private String url;
	private Properties prop;

	public L05_BasePage() throws IOException {
		prop = new Properties();
		FileInputStream data = new FileInputStream(
				System.getProperty("user.dir")
						+ File.separator + "src"
						+ File.separator + "test"
						+ File.separator + "java"
						+ File.separator + "Section12"
						+ File.separator + "L04_config.properties");
		prop.load(data);
	}

	public WebDriver getDriver() throws IOException {
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

		return driver;
	}

	public String getUrl() throws IOException {
		url = prop.getProperty("url");
		return url;
	}

	public void takeSnapShot(WebDriver webdriver) throws IOException {
		File srcFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") + File.separator + "reports" + timestamp() + ".png");

		FileUtils.copyFile(srcFile, destFile);
	}

	public String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}
