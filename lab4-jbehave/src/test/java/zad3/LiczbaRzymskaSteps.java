package zad3;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class LiczbaRzymskaSteps {
	
	private LiczbaRzymska liczba;
	
	private Throwable throwable = null;

	@Given("liczba")
	public void liczbaSetup() {
		liczba = new LiczbaRzymska();
	}
	
	@When("set argument to $arabic")
	public void setArgument(int arabic){
		liczba.setLiczba(arabic);
	}
	
	@Then("the result of conversion should be $roman")
	public void convert(String roman){
		assertEquals(roman, liczba.toString());
	}
	
	@When("set illegal argument like $illegalNumber")
	public void setIllegalNumber(int arabic){
		liczba.setLiczba(arabic);
	}
	
	@Then("an exception is thrown")
	public void verifyException() {
		try {
			liczba.toString();
		} catch (Exception e){
			throwable = e;
		}
		assertThat(throwable, instanceOf(IllegalArgumentException.class));
	}
	
}
