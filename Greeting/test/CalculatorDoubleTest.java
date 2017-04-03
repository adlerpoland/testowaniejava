
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class CalculatorDoubleTest 
{
	private CalculatorDouble calc;
	
	@Before
	public void setUp()
	{
		calc = new CalculatorDouble();
	}

    @Test
    public void add()
    {
    	
        assertEquals(10.0,calc.add(4.4,5.6),0);
    }

    @Test
    public void sub()
    {
        assertEquals(1.1,calc.sub(7.7,6.6),0.01);
    }

    @Test
    public void multi()
    {
        assertEquals(12.0,calc.multi(3.0,4.0),0);
    }

    @Test
    public void div()
    {
        assertEquals(11.0,calc.div(121.0,11.0),0);
    }
    
    @Test
    public void divEpsilon()
    {
        assertEquals(1.333,calc.div(4.0,3.0),0.001);
    }
    
    @Test(expected=IllegalArgumentException.class)
	public void divZero()
	{

		assertEquals(null,calc.div(85.0, 0.0));
	}

    @Test
    public void greater()
    {
        assertTrue(calc.greater(6.0,2.0));
    }
    
	@After
	public void tearDown()
	{
		calc = null;
	}

}

