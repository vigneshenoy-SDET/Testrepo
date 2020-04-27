package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import E2ETraining.Basedriver;
import E2ETraining.CreateAccount;
import E2ETraining.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

//@RunWith(Cucumber.class)
public class SigninSteps extends Basedriver{
	
	WebDriver wdl;
	
	@Given("^Launch url \"([^\"]*)\"$")
    public void launch_url_something(String strArg1) throws Throwable {
		wdl = setBrowserDriver();
		wdl.manage().window().maximize();
		wdl.get(prop.getProperty("url"));
    }
	
    @And("^Navigate to SignIn page$")
    public void navigate_to_signin_page() throws Throwable {
    	LoginPage lgp = new LoginPage(wdl);
		lgp.getLogin().click();
    }


    @When("^User enters name (.+),email (.+) and password (.+)$")
    public void user_enters_name_email_and_password(String uname, String email, String pword) throws Throwable {
    	CreateAccount ca = new CreateAccount(wdl);
		ca.createAcc();
		ca.setName(uname);
		ca.setEmail(email);
		ca.setPword(pword);
		ca.checkPword(pword);
		ca.submit();
    }

    @Then("^New account should be created$")
    public void new_account_should_be_created() throws Throwable {
        Assert.assertFalse(false,prop.getProperty("Newaccount_text"));
    }
    
    @And("^Close the browser$")
    public void close_the_browser() throws Throwable {
    	wdl.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wdl.close();
    }

    

}
	
	

