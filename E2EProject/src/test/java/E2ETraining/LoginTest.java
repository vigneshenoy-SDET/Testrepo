package E2ETraining;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LoginTest extends Basedriver{
	
	WebDriver wdl;
	
	static Logger logg = LogManager.getLogger(LoginTest.class.getName());
	
	@BeforeTest
	public void landingPage() throws IOException{
		wdl = setBrowserDriver();
		wdl.manage().window().maximize();
		wdl.get(prop.getProperty("url"));
	}
	
	@Test
	public void newLogin() throws IOException{
		LoginPage lgp = new LoginPage(wdl);
		lgp.getLogin().click();
		logg.info("Login Page is displayed");
	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException{
		wdl.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wdl.close();
	}


}
