package E2ETraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyText {
	
	WebDriver wd;
	private By text = By.xpath("//span[@class='a-size-base a-color-base']");
	
	
	public VerifyText(WebDriver wdr) {
		this.wd = wdr;
	}


	public String checkText(){
		return wd.findElement(text).getText();
	}

}
