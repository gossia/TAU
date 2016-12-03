package zad2;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


public class CalculatorSteps {
	
	private static final double APPROX = 0.001;;
	private Calculator calculator;
	
	@Given("a calculator")
	public void calculatorSetup() {
		calculator = new Calculator();
	}
	
	@When("set arguments to $a and $b")
	public void setArguments(double a, double b){
		calculator.setA(a);
		calculator.setB(b);
	}
	
	@Then("adding should return $result")
	public void testAdd(double result){
	    assertEquals(result, calculator.add(), APPROX);
	}
	
	@Then("subtracting should return $result")
	public void testSub(double result){
	    assertEquals(result, calculator.sub(), APPROX);
	}
	
	@Then("multiplying should return $result")
	public void testMulti(double result){
	    assertEquals(result, calculator.multi(), APPROX);
	}
	
	@Then("dividing should return $result")
	public void testDiv(double result){
	    assertEquals(result, calculator.div(), APPROX);
	}
	
	@Then("comparison should return $result")
	public void testGreater(boolean result){
	    assertEquals(result, calculator.greater());
	}
	
	
	@When("$a is divided by 0")
    public void testDivByZero(double a) {
        calculator.setA(a);
        calculator.setB(0);
    }

    @Then("infinity is returned")
    public void returnInfinity() {
        assertEquals(Double.POSITIVE_INFINITY, calculator.div(), APPROX);
    }
	
}
