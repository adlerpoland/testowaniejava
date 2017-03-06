package ships.ships;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ShipTest 
{	
	private Ship ship;
	
	@Before
	public void initShip()
	{
		ship = new Ship();
		ship.initIslands();
	}
	
	@Test
    public void testShipSetPosition()
    { 	
		int[] xy = {5,2};
		ship.setPosition(xy);
		
		int[] result = ship.getPosition();
		
		assertArrayEquals(xy,result);
	}
	
	@Test
	public void testGetMapSize()
	{
		int[] xy = {0,0};
		int[] result = ship.getMapSize();
		
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
		ship.move("p");
		char result = ship.getDirection();
		if(original == 'N')
			assertEquals('E',result);
		else if(original == 'E')
			assertEquals('S',result);
		else if(original == 'S')
			assertEquals('W',result);
		else if(original == 'W')
			assertEquals('N',result);
	}
	
	@Test
	public void testShipRotateLeft()
	{
		char original = ship.getDirection();
		ship.move("l");
		char result = ship.getDirection();
		if(original == 'N')
			assertEquals('W',result);
		else if(original == 'W')
			assertEquals('S',result);
		else if(original == 'S')
			assertEquals('E',result);
		else if(original == 'E')
			assertEquals('N',result);
	}
	
	@Test
	public void testShipMoveFront()
	{
		ship.hideIslands();
		
		int[] position = ship.getPosition();
		int x = position[0];
		int y = position[1];
		
		char direction = ship.getDirection();
		
		ship.move("n");
		int[] getMapSize = ship.getMapSize();
		
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
		ship.hideIslands();
		
		int[] position = ship.getPosition();
		int x = position[0];
		int y = position[1];
		
		char direction = ship.getDirection();
		
		ship.move("w");
		int[] getMapSize = ship.getMapSize();
		
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
		ship.showIslands();
		
		int[] position = {0,0};
		char direction = 'E';
		
		ship.setPosition(position);
		ship.setDirection(direction);	
		
		ship.move("nnnlnnpnnw");
		position[0] = 4;
		position[1] = 2;
		
		int[] resultposition = ship.getPosition();
		
		assertArrayEquals(resultposition,position);	
	}
	
	@Test
	public void testShipCollision()
	{
		ship.showIslands();
		
		int[] position = {5,5};
		char direction = 'N';
		ship.setPosition(position);
		ship.setDirection(direction);
		
		//Island on 5,7
		boolean result = ship.move("nn");
		assertFalse(result);
	}
	
}
