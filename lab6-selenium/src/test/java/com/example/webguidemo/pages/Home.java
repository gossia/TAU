package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Home extends WebDriverPage {

	public Home(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	//private final static String REGISTRATION_LINK = "//*[@id='main-menu']/a[4]";
	private final static By REGISTRATION_LINK_TEXT = By.linkText("Rejestracja");
	private final static By SEARCH_BOX = By.id("search");

	public void open() {
		get("http://www.butsklep.pl");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void clickRegistrationLink(){
		//findElement(By.xpath(SPORT_LINK)).click();
		findElement(REGISTRATION_LINK_TEXT).click();
	}
	
	public void search(String phrase){
		findElement(SEARCH_BOX).sendKeys(phrase + Keys.ENTER);
	}
}
