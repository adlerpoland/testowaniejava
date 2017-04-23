package ships;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ShipExceptionsTest {
	private Ship ship;
	private Map map;
	
	@Before
	public void init()
	{
		ship = new Ship("concordia");
		map = new Map();
		map.initIslands();
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test(expected = Exception.class)
	public void exceptIndexOutOfBoundsTest()
	{
		ship.move(map, "abc");
		
		exception.expect(IndexOutOfBoundsException.class);
	}
	
	@Test(expected = Exception.class)
	public void exceptArrayIndexOutOfBoundsTest()
	{
		int[] xy = new int[1];
		ship.setPosition(map, xy);
		
		exception.expect(ArrayIndexOutOfBoundsException.class);
	}
	
	@Test(expected = Exception.class)
	public void except()
	{
		char dir = 'a';
		ship.setDirection(dir);
		
		exception.expect(ArrayIndexOutOfBoundsException.class);
	}
	
	
}
