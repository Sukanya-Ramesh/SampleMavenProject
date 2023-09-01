package org.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.util.BaseClass;

public class LoginPage extends BaseClass {

	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(id="email")
	private WebElement username;

	public WebElement getUsername() {
		return username;
	}
	
	@FindBy(id="pass")
	public WebElement password;

	public WebElement getPassword() {
		return password;
	}
}
