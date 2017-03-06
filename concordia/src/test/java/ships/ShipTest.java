package ships;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testShipSetPosition()
    {
		int[] xy = {5,2};
		ship.setPosition(xy[0],xy[1]);
		
		int[] resultArray = ship.getPosition();
		
		assertArrayEquals(xy,resultArray);
	}
	public void testShipGetDirection()
	{
		char direction = '';
		char result = ship.getDirection();
		assertNotSame(direction,result);
	}
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
	public void testShipMoveFront()
	{
		int[] position = ship.getPosition();
		char direction = ship.getDirection();
		
		ship.move("n");
		int[] resultposition = ship.getPosition();
		
		int[] getMapSize = ship.getMapSize();
		
		if(direction == 'N')
			assertEquals(position[1]+1%getMapSize[1],resultposition[1]);
		else if(direction == 'S')
			assertEquals(position[1]-1%getMapSize[1],resultposition[1]);
		else if(direction == 'E')
			assertEquals(position[0]+1%getMapSize[0],resultposition[0]);
		else if(direction == 'W')
			assertEquals(position[0]-1%getMapSize[0],resultposition[0]);
	}
	public void testShipMoveBack()
	{
		int[] position = ship.getPosition();
		char direction = ship.getDirection();
		
		ship.move("w");
		int[] resultposition = ship.getPosition();
		
		int[] getMapSize = ship.getMapSize();
		
		if(direction == 'N')
			assertEquals(position[1]-1%getMapSize[1],resultposition[1]);
		else if(direction == 'S')
			assertEquals(position[1]+1%getMapSize[1],resultposition[1]);
		else if(direction == 'E')
			assertEquals(position[0]-1%getMapSize[0],resultposition[0]);
		else if(direction == 'W')
			assertEquals(position[0]+1%getMapSize[0],resultposition[0]);
	}
	public void testShipMovement()
	{
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
	public void testShipCollision()
	{
		int[] position = {5,5};
		char direction = 'N';
		ship.setPosition(position);
		ship.setDirection(direction);
		
		//Island on 7,5
		boolean result = ship.move("nn");
		assertFalse(result);
	}
	
}
