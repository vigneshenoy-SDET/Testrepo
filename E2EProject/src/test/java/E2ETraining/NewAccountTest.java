package E2ETraining;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewAccountTest extends Basedriver {

	WebDriver wdl;
	
	static Logger logg = LogManager.getLogger(NewAccountTest.class.getName());

	@BeforeTest
	public void landingPage() throws IOException {
		wdl = setBrowserDriver();
		
	}

	
	@Test(dataProvider = "testData")
	public void enterDetails(String S_name, String S_mail, String S_pwd) throws IOException {
		wdl.manage().window().maximize();
		wdl.get(prop.getProperty("url"));
		LoginPage lgp = new LoginPage(wdl);
		lgp.getLogin().click();
		CreateAccount ca = new CreateAccount(wdl);
		ca.createAcc();
		ca.setName(S_name);
		ca.setEmail(S_mail);
		ca.setPword(S_pwd);
		ca.checkPword(S_pwd);
		ca.submit();
		logg.info("New account test is completed successfully");
		
	}


	

	@AfterTest
	public void closeBrowser() throws InterruptedException {
		wdl.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wdl.close();
	}

	@DataProvider
	public Object testData() {
		Object[][] td = new Object[2][3];

		// 1st set of test data
		td[0][0] = prop.getProperty("Set1_name");
		td[0][1] = prop.getProperty("Set1_email");
		td[0][2] = prop.getProperty("Set1_password");

		// 2nd set of test data
		td[1][0] = prop.getProperty("Set2_name");
		td[1][1] = prop.getProperty("Set2_email");
		td[1][2] = prop.getProperty("Set2_password");

		return td;
	}

}
