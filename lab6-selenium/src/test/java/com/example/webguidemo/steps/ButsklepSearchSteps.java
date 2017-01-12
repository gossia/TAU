package com.example.webguidemo.steps;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.example.webguidemo.Pages;

public class ButsklepSearchSteps{
	
	private final Pages pages;
	
	private static final String PHRASE = "muszkieterki venezia";
	private static final String RESULT_PAGE_TITLE = "ButSklep.pl - wyszukiwanie: " + PHRASE + " - Buty Damskie, Obuwie Męskie i Dziecięce, Sklep";
	
	public ButsklepSearchSteps(Pages pages){
		this.pages = pages;
	}
	
	@Given("user is on Home page")
	public void userIsOnHomePage(){
		pages.home().open();
	}
	
	@When("user types phrase in search box")
	public void userTypesPhraseInSearchBox(){
		pages.home().search(PHRASE);
	}
	
	@Then("search result is displayed")
	public void searchResultIsDisplayed(){
		assertEquals(RESULT_PAGE_TITLE, pages.registration().getTitle());
	}

}
