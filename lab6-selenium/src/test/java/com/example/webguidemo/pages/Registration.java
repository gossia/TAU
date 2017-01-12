package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class Registration extends WebDriverPage{
	
	private final static By FIRSTNAME = By.name("bill[firstname]");
	private final static By LASTNAME = By.name("bill[lastname]");
	private final static By EMAIL = By.name("global[email]");
	private final static By PASSWORD = By.name("global[password]");
	private final static By PASSWORD_REPETITION = By.name("global[repassword]");
	private final static By ACCEPT_RULES_CHECKBOX = By.id("doRules");
	private final static By ACCEPT_MARKETING_CHECKBOX = By.name("global[accept_newsletter_mail]");
	private final static By REGISTRATION_BUTTON = By.cssSelector(".inpRegister");

	
	public Registration(WebDriverProvider driverProvider) {
		super(driverProvider);		
	}

	public void open() {
		get("http://www.butsklep.pl/rejestracja");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void register(String firstname, String lastname, String email, String password) {
		 findElement(FIRSTNAME).sendKeys(firstname);
		 findElement(LASTNAME).sendKeys(lastname);
		 findElement(EMAIL).sendKeys(email);
		 findElement(PASSWORD).sendKeys(password);
		 findElement(PASSWORD_REPETITION).sendKeys(password);
		 findElement(ACCEPT_RULES_CHECKBOX).click();
		 findElement(ACCEPT_MARKETING_CHECKBOX).click();
		 findElement(REGISTRATION_BUTTON).click();
	}
	
}
