package com.example.webguidemo.steps;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.example.webguidemo.Pages;

public class ButsklepRegistrationSteps {
	
	private final Pages pages;
	
	private String emailAddress;
	private static final String FFIRSTNAME = "Anna";
	private static final String LASTNAME = "Kowalska";
	private static final String PASSWORD = "1qaz2wsx";
	private static final String PROFILE_PAGE_TITLE = "ButSklep.pl - moje konto - zmiana hasła - Buty Damskie, Obuwie Męskie i Dziecięce, Sklep";

	public ButsklepRegistrationSteps(Pages pages){
		this.pages = pages;
	}
	
	@Given("user is on Registration page")
	public void userIsOnRegistrationPage(){
		pages.tenMinuteMail().open();
		emailAddress = pages.tenMinuteMail().getEmailAddress();
		pages.registration().open();
	}
	
	@When("user registers")
	public void userRegisters(){
		pages.registration().register(FFIRSTNAME, LASTNAME, emailAddress, PASSWORD);
	}
	
	@Then("Profile page is shown")
	public void profilePageIsShown(){
		assertEquals(PROFILE_PAGE_TITLE, pages.registration().getTitle());
	}
	
}
