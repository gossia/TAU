package zad1;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
	Calculator calculator = new Calculator();
	
	@Test
	public void addCheck(){
		assertEquals(5, calculator.add(2, 3));
	}
	@Test
	public void subCheck(){
		assertEquals(-1, calculator.sub(5, 6));
	}
	@Test
	public void multiCheck(){
		assertEquals(0, calculator.multi(5, 0));
	}
	@Test
	public void divCheck(){
		assertEquals(1, calculator.div(5, 3));
	}
	@Test
	public void greaterCheck(){
		assertEquals(true, calculator.greater(5, 3));
	}
	@Test
	  public void testAssertTrue(){
	    assertTrue("failure - should be true", calculator.greater(5, 3));
	  }
	
	@Test
	public void divByZero() { 
		assertEquals(0, calculator.div(2, 0));
	}
	
}
