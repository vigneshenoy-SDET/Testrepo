package E2ETraining;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextVerificationTest extends Basedriver{
	
	WebDriver wdr;
	
	static Logger logg = LogManager.getLogger(TextVerificationTest.class.getName());
	
	@BeforeTest
	public void landingPage() throws IOException{
		wdr = setBrowserDriver();
		wdr.manage().window().maximize();
		wdr.get(prop.getProperty("url"));
	}
	
	
	@Test
	public void compareText(){
		VerifyText vtext = new VerifyText(wdr);
		Assert.assertEquals(vtext.checkText(),prop.getProperty("text_to_be_verified"));
		//logg.info("Text is verified successfully");
	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException{
		wdr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wdr.close();
	}

}
