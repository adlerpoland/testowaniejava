package ships;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ShipTest 
{	
	private Ship ship;
	private Map map;
	
	@Before
	public void init()
	{
		ship = new Ship("concordia");
		map = new Map();
		map.initIslands();
	}
	
	@Test
    public void testShipSetPosition()
    { 	
		int[] xy = {5,2};
		ship.setPosition(map,xy);
		
		int[] result = ship.getPosition();
		
		assertArrayEquals(xy,result);
	}
	
	@Test
	public void testGetMapSize()
	{
		int[] xy = {0,0};
		int[] result = map.getMapSize();
		
		assertNotSame(xy,result);
	}
	
	@Test
	public void testShipSetDirection()
	{
		char direction = 'N';
		ship.setDirection(direction);
		char result = ship.getDirection();
		
		assertEquals(direction,result);
	}
	
	@Test
	public void testShipGetDirection()
	{
		char direction = '?';
		char result = ship.getDirection();
		assertNotSame(direction,result);
	}
	
	@Test
	public void testShipRotateRight()
	{
		char original = ship.getDirection();
		String orient = "NESWN";
		ship.move(map,"p");
		char result = ship.getDirection();
		
		assertThat(orient.indexOf(original)+1,is(equalTo(orient.lastIndexOf(result))));
	}
	
	@Test
	public void testShipRotateLeft()
	{
		char original = ship.getDirection();
		String orient = "NWSEN";
		ship.move(map,"l");
		char result = ship.getDirection();
		
		assertThat(orient.indexOf(original)+1,is(equalTo(orient.lastIndexOf(result))));
	}
	
	@Test
	public void testShipMoveFront()
	{
		map.hideIslands();
		
		int[] position = ship.getPosition();
		int x = position[0];
		int y = position[1];
		
		char direction = ship.getDirection();
		
		ship.move(map,"n");
		int[] getMapSize = map.getMapSize();
		
		if(direction == 'N')
			assertEquals((y+1)%(getMapSize[1]+1),position[1]);
		else if(direction == 'S')
		{
			if(y-1<0)
				y=getMapSize[1];
			else
				y--;
			assertEquals(y,position[1]);
		}
		else if(direction == 'E')
			assertEquals((x+1)%(getMapSize[0]+1),position[0]);
		else if(direction == 'W')
		{
			if(x-1<0)
				x=getMapSize[0];
			else
				x--;
			assertEquals(x,position[0]);
		}
	}
	
	@Test
	public void testShipMoveBack()
	{
		map.hideIslands();
		
		int[] position = ship.getPosition();
		int x = position[0];
		int y = position[1];
		
		char direction = ship.getDirection();
		
		ship.move(map,"w");
		int[] getMapSize = map.getMapSize();
		
		if(direction == 'N')
		{
			if(y-1<0)
				y=getMapSize[1];
			else
				y--;
			assertEquals(y,position[1]);
		}
		else if(direction == 'S')
			assertEquals((y+1)%(getMapSize[1]+1),position[1]);
		else if(direction == 'E')
		{
			if(x-1<0)
				x=getMapSize[0];
			else
				x--;
			assertEquals(x,position[0]);
		}	
		else if(direction == 'W')
			assertEquals((x+1)%(getMapSize[0]+1),position[0]);
	}
	
	@Test
	public void testShipMovement()
	{
		map.showIslands();
		
		int[] position = {0,0};
		char direction = 'E';
		
		ship.setPosition(map,position);
		ship.setDirection(direction);	
		
		ship.move(map,"nnnlnnpnnw");
		position[0] = 4;
		position[1] = 2;
		
		int[] resultposition = ship.getPosition();
		
		assertArrayEquals(resultposition,position);	
	}
	
	@Test
	public void testShipBadMovementCmd()
	{
		map.showIslands();
		
		int[] position = {0,0};
		char direction = 'E';
		
		ship.setPosition(map,position);
		ship.setDirection(direction);	
		
		boolean cmd = ship.move(map,"nnna");
		
		assertThat(cmd,is(equalTo(false)));	
	}
	
	@Test
	public void testShipCollision()
	{
		map.showIslands();
		
		int[] position = {2,3};
		char direction = 'N';
		ship.setPosition(map,position);
		ship.setDirection(direction);
		
		//Island on 3,6
		boolean result = ship.move(map,"nnnpn");
		assertThat(result,is(equalTo(false)));
	}
	
	/*@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Test()
    public void testShipSetPositionThrowsIndexOutOfBoundsException()
    { 	
		
		ship.setDirection('A');
		
		exception.expect(IndexOutOfBoundsException.class);
		ship.move("p");
	}
	*/
}
