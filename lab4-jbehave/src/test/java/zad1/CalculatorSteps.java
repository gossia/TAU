package zad1;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


public class CalculatorSteps {
	
	private Calculator calculator;
	
	@Given("a calculator")
	public void calculatorSetup() {
		calculator = new Calculator();
	}
	
	@When("set arguments to $a and $b")
	public void setArguments(int a, int b){
		calculator.setA(a);
		calculator.setB(b);
	}
	
	@Then("adding should return $result")
	public void testAdd(int result){
	    assertEquals(result, calculator.add());
	}
	
	@Then("subtracting should return $result")
	public void testSub(int result){
	    assertEquals(result, calculator.sub());
	}
	
	@Then("multiplying should return $result")
	public void testMulti(int result){
	    assertEquals(result, calculator.multi());
	}
	
	@Then("dividing should return $result")
	public void testDiv(int result){
	    assertEquals(result, calculator.div());
	}
	
	@Then("comparison should return $result")
	public void testGreater(boolean result){
	    assertEquals(result, calculator.greater());
	}
	
}
