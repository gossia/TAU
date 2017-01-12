package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class TenMinuteMail extends WebDriverPage{
	
	public TenMinuteMail(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("https://10minutemail.com/");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public String getEmailAddress(){
		return findElement(By.id("mailAddress")).getAttribute("value");
	}
	
}
