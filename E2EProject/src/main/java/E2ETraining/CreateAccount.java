package E2ETraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {

	WebDriver wd;

	@FindBy(xpath = "//a[@id='createAccountSubmit']")
	private WebElement Create;

	@FindBy(id = "ap_customer_name")
	private WebElement Name;

	@FindBy(id = "ap_email")
	private WebElement Email;

	@FindBy(id = "ap_password")
	private WebElement Password;

	@FindBy(id = "ap_password_check")
	private WebElement Password_Check;

	@FindBy(id = "continue")
	private WebElement Continue;

	public CreateAccount(WebDriver wdl) {
		this.wd=wdl;
		PageFactory.initElements(wdl, this);
	}

	public void createAcc() {
		Create.click();
	}

	public void setName(String name) {
		Name.sendKeys(name);
	}

	public void setEmail(String email) {
		Email.sendKeys(email);
	}

	public void setPword(String pwd) {
		Password.sendKeys(pwd);
	}

	public void checkPword(String cwd) {
		Password_Check.sendKeys(cwd);
	}

	public void submit() {
		Continue.click();
	}

}
