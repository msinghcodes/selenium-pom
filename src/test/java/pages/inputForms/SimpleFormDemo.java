package pages.inputForms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleFormDemo {
	
	WebDriver ldriver;
	
	public SimpleFormDemo(WebDriver rdriver ) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//input[@id='user-message']")
	private WebElement userMessage;
	
	public void setUserMessage(String message) {
		userMessage.sendKeys(message);
	}

}
