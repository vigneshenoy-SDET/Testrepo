package E2ETraining;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;



public class LandingPageTest extends Basedriver {

	WebDriver driver;
	
	static Logger logg = LogManager.getLogger(LandingPageTest.class.getName());

	@Test
	public void launchHome() throws IOException {
		driver = setBrowserDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		logg.info("Page launched successfully");

	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
	}

}
