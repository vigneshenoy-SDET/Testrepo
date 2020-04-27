package E2ETraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver drive;

	private By Login = By.xpath("//a[@id='nav-link-accountList']");

	public LoginPage(WebDriver wdl) {
		this.drive = wdl;
	}

	public WebElement getLogin() {
		return drive.findElement(Login);
	}

}
