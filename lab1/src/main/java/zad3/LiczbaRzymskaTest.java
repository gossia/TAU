package zad3;

import static org.junit.Assert.*;

import org.junit.Test;

public class LiczbaRzymskaTest {
	
	@Test
	public void check1(){
		assertEquals("I", LiczbaRzymska.toString(1));
	}
	
	@Test
	public void check3999(){
		assertEquals("MMMCMXCIX", LiczbaRzymska.toString(3999));
	}
	
	@Test
	public void check888(){
		assertEquals("DCCCLXXXVIII", LiczbaRzymska.toString(888));
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkNegative(){
		LiczbaRzymska.toString(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkToHigh(){
		LiczbaRzymska.toString(4000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checkZero(){
		LiczbaRzymska.toString(0);
	}
	
}
