package zad2;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
	
	private static final double APPROX = 0.001;
	
	Calculator calculator = new Calculator();
	
	@Test
	public void addCheck(){
		assertEquals(11.6666, calculator.add(10.5555, 1.1111), APPROX);
	}
	@Test
	public void subCheck(){
		assertEquals(9.4444, calculator.sub(10.5555, 1.1111), APPROX);
	}
	@Test
	public void multiCheck(){
		assertEquals(0, calculator.multi(5.555, 0), APPROX);
	}
	@Test
	public void divCheck(){
		assertEquals(5.555, calculator.div(5.555, 1.000), APPROX);
	}
	@Test
	public void greaterCheck(){
		assertEquals(true, calculator.greater(5.001, 3.0077));
	}
	
	@Test
	public void divByZero() { 
		assertEquals(Double.POSITIVE_INFINITY, calculator.div(2.888, 0.000), APPROX);  
	}

}
