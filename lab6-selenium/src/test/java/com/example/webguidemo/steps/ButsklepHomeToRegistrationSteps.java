package com.example.webguidemo.steps;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.example.webguidemo.Pages;

public class ButsklepHomeToRegistrationSteps {
	
	private final Pages pages;
	
	private static final String REGISTRATION_PAGE_TITLE = "ButSklep.pl - rejestracja - Buty Damskie, Obuwie Męskie i Dziecięce, Sklep";

	public ButsklepHomeToRegistrationSteps(Pages pages) {
		this.pages = pages;
	}
	
	@Given("user is on Home page")
    public void userIsOnHomePage(){        
        pages.home().open();        
    }
 
    @When("user opens Registration link")
    public void userClicksOnRegistrationLink(){        
        pages.home().clickRegistrationLink();
    }
 
    @Then("Registration page is shown")
    public void registrationPageIsShown(){
    	//pages.home().switchTo().activeElement();
    	assertEquals(REGISTRATION_PAGE_TITLE, pages.registration().getTitle());
    	
    }

}
