import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GreetingTest {
	
	private Greeting gret;
	
	@Before
	public void setUp(){
		gret = new Greeting();
	}
	
	@Test
	public void returnMessage(){
		String result = gret.returnMessage("JUnit");
		assertEquals("Hello JUnit",result);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void returnNullMessage(){
		String result = gret.returnMessage(null);
		assertEquals(null,result);
	}
	
	@After
	public void tearDown(){
		gret = null;
	}
	
}
