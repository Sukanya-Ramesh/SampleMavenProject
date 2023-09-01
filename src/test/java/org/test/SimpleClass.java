package org.test;

import java.util.Iterator;

import org.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.util.BaseClass;

public class SimpleClass extends BaseClass {
	
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		
		//for (int i = 1; i < 6; i++) {
			//for (int j = 1; j <= 1; j++) {
				
							
			//}
			
		//}
		
		launchChrome();
		getURL("https://wwww.facebook.com/");
		screenShot("page");
		
		LoginPage l = new LoginPage();
		WebElement userEmail = l.getUsername();
		WebElement userPassword = l.getPassword();
		String firstName = readData("Sample", 0, 1, 1);
		String lastName = readData("Sample", 0, 1, 2);
		//String userPassword = readData("Sample", 0, 1, 3);
		String fullName = firstName+" "+lastName;
		sendValues(userEmail, fullName);
		screenShot("email");
		sendValues(userPassword, readData("Sample", 0, 1, 3));
		screenShot("password");
		//WebElement email = driver.findElement(By.id("email"));
		//WebElement password = driver.findElement(By.id("pass"));
		//WebElement loginBtn = driver.findElement(By.name("login"));
		//WebElement forgotPassBtn = driver.findElement(By.xpath("//a[contains(text(), 'password')]"));
		
		//sendValues(email, fullName);
		
		//sendValues(password, userPassword);
		
		
		//click(loginBtn);
		//click(forgotPassBtn);
		//doubleClick(password);
		//pressTab();
		//clickUsingActions(loginBtn);
		
		contextClick(userPassword);
		screenShot("contextClick");
		close();
		
		
		
	}

}
