import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class NWDTest 
{
	
	private NWD nwdobj;
	
	
	@Before
	public void setUp()
	{
		nwdobj = new NWD();
	}
	
	@Test
	public void NWDdadatnie()
	{
		int result = nwdobj.liczNWD(1989,867);
		assertEquals(51,result);
	}
	
	@Test
	public void NWDaUjemne()
	{
		int result = nwdobj.liczNWD(-1989, 867);
		assertEquals(51,result);
	}
	
	@Test
	public void NWDbUjemne()
	{
		int result = nwdobj.liczNWD(1989, -867);
		assertEquals(51,result);
	}
	
	@Test
	public void NWDujemne()
	{
		int result = nwdobj.liczNWD(-1989, -867);
		assertEquals(51,result);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void NWDzero()
	{
		int result = nwdobj.liczNWD(0,0);
		assertEquals(null,result);
	}
	
	@Test
	public void NWDaZero()
	{
		int result = nwdobj.liczNWD(0,24);
		assertEquals(24,result);
	}
	
	@Test
	public void NWDbZero()
	{
		int result = nwdobj.liczNWD(24,0);
		assertEquals(24,result);
	}
	
	@Test
	public void NWDpierwsze()
	{
		int result = nwdobj.liczNWD(15,13);
		assertEquals(1,result);
	}
	
	@After
	public void tearDown()
	{
		nwdobj = null;
	}

}
