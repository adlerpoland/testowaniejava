import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorTest
{
	private Calculator calc;
	private int inputA;
	private int inputB;
	private int output;
	
	@Parameters
    public static Collection<Object[]> data() {
        Object[][] c = {
        		{4,8,12}, {12,24,36}, {13,12,25}, {100,25,125}
   		};
        return  Arrays.asList(c);
    }
	
	@Before
	public void setUp()
	{
		calc = new Calculator();
	}
	public CalculatorTest(int a, int b, int c){
		inputA = a;
		inputB = b;
		output = c;
	}

	@Test
	public void add()
	{
		//int result = calc.add(987, 123);
		//assertEquals(1110,result);
		System.out.println("TEST: "+inputA+" + "+inputB+" = "+output);
		assertEquals(output,calc.add(inputA, inputB));
	}
	
	/*
	@Test
	public void sub()
	{
		int result = calc.sub(851, 51);
		assertEquals(800,result);
	}

	@Test
	public void multiDodatnie()
	{
		int result = calc.multi(50, 20);
		assertEquals(1000,result);
	}
	
	@Test
	public void multiZeroA()
	{
		int result = calc.multi(0, 20);
		assertEquals(0,result);
	}
	
	@Test
	public void multiZeroB()
	{
		int result = calc.multi(50, 0);
		assertEquals(0,result);
	}
	
	@Test
	public void multiUjemne()
	{
		int result = calc.multi(-50, -20);
		assertEquals(1000,result);
	}

	@Test
	public void divDodatnie()
	{
		int result = calc.div(85, 5);
		assertEquals(17,result);
	}
	
	@Test
	public void divUjemne()
	{
		int result = calc.div(-85, 5);
		assertEquals(-17,result);
	}

	@Test(expected=IllegalArgumentException.class)
	public void divZero()
	{
		int result = calc.div(85, 0);
		assertEquals(null,result);
	}
	
	@Test
	public void greaterTrue()
	{
		boolean result = calc.greater(20,5);
		assertEquals(true,result);
	}
	
	@Test
	public void greaterFalse()
	{
		boolean result = calc.greater(5,20);
		assertEquals(false,result);
	}
	*/
	
	@After
	public void tearDown()
	{
		calc = null;
	}
}