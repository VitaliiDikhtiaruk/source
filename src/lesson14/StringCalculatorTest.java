package lesson14;

import static org.junit.Assert.*;

import org.junit.Test;

import lesson14.StringCalculator;

public class StringCalculatorTest {
	StringCalculator calc = new StringCalculator();

	@Test
	public void whenEmptyStringIsUsed() {
		int result = calc.add("");
		assertEquals(0, result);
	}
	@Test(expected = RuntimeException.class)
	public void whenStringConsistNotNumber() {
		calc.add("1,X");
		
	}
	@Test
	public void whenStringConsist2NumbersGetSum() {
		int result = calc.add("1,2");
		assertEquals(3, result);
	}
	@Test
	public void whenStringConsistLotsNumbersGetSum() {
		int result = calc.add("1,1,1,1,1");
		assertEquals(5, result);
	}
	@Test
	public void whenStringConsistNextLine() {
		int result = calc.add("1,\n2");
		assertEquals(3, result);
	}
	
	@Test
	public void whenCustomDelimetrIsSpecified() {
		
		assertEquals(9, calc.add("//;n3;6"));
	}
	@Test(expected = RuntimeException.class)
	public void whenNegativeValueIsUsed() {
		int result = calc.add("-1,-2");
	}
	

}
