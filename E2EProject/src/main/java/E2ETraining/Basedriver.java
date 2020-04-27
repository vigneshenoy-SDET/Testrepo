package E2ETraining;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Basedriver {

	protected Properties prop;

	WebDriver wd = null;

	public WebDriver setBrowserDriver() throws IOException {

		String current_directory = System.getProperty("user.dir");

		String prop_path = current_directory + "\\src\\main\\java\\E2ETraining\\testbase.properties";
		String gc_driver = current_directory + "\\src\\main\\Resources\\chromedriver.exe";
		String ff_driver = current_directory + "\\src\\main\\Resources\\geckodriver.exe";
		String ie_driver = current_directory + "\\src\\main\\Resources\\IEDriverServer.exe";

		prop = new Properties();
		FileInputStream fis = new FileInputStream(prop_path);

		prop.load(fis);

		// String browserName = System.getProperty("browser");

		String browserName = prop.getProperty("browser");

		if (browserName.contains("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			System.setProperty("webdriver.chrome.driver", gc_driver);
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			wd = new ChromeDriver(options);
		} else if (browserName.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver", ff_driver);

			wd = new FirefoxDriver();
		} else if (browserName.contains("IE")) {
			System.setProperty("webdriver.ie.driver", ie_driver);

			wd = new InternetExplorerDriver();
		}

		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return wd;

	}

	public void errorScreenshot(String failure) throws IOException {

		wd = setBrowserDriver();

		File src = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File("E:/Vignesh/" + failure + "_screenshot.jpg"));
	}
}
