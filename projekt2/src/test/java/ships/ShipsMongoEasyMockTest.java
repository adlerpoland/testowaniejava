package ships;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.doReturn;


@RunWith(EasyMockRunner.class)
public class ShipsMongoEasyMockTest {

	@TestSubject
	ShipsMongo ships = new ShipsMongo();
	Map map = new Map();
	
	//A nice mock expects recorded calls in any order and returning null for other calls
	@Mock(type = MockType.NICE)
	ShipCollection shipcollection;
	
	@Test
	public void mockingWorskAsExpected(){
		Ship joe = new Ship("Joe");
		expect(shipcollection.findByName("Joe")).andReturn(joe);
		replay(shipcollection);
		
		assertThat(shipcollection.findByName("Joe")).isEqualTo(joe);
	}
	
	@Test
	public void bobIsOnStartPosition(){
		Ship bob = new Ship("bob");
		expect(shipcollection.findByName("bob")).andReturn(bob);
		replay(shipcollection);
		int xy[] = {0,0};
		assertThat(shipcollection.findByName("bob").getPosition()).isEqualTo(xy);
	}
	
	@Test
	public void moveJamesInToIsland(){
		Ship james = new Ship("james");
		expect(shipcollection.findByName("james")).andReturn(james);
		
		int xy[] = {1,9};
		james.setPosition(map, xy);
		
		map.initIslands();
		
		xy[1] = 10;
		james.setDirection('E');
		james.move(map, "n");
		
		//Island on 2,9 ship shouldn't move
		
		int[] island = {2,9};
		replay(shipcollection);
		int[][] output = shipcollection.findByName("james").getHistory();
		
		assertThat(output).doesNotContain(island);
	}
	
	@Test
	public void testShipMovement()
	{
		Ship james = new Ship("james");
		expect(shipcollection.findByName("james")).andReturn(james);
		int[] position = {0,0};
		char direction = 'E';
		
		james.setPosition(map,position);
		james.setDirection(direction);	
		
		james.move(map,"nnnlnnpnnw");
		position[0] = 4;
		position[1] = 2;
		
		replay(shipcollection);
		int[] resultposition = shipcollection.findByName("james").getPosition();
		
		assertArrayEquals(resultposition,position);	
	}
	
	@Test
	public void testShipGetDirection()
	{
		Ship james = new Ship("james");
		expect(shipcollection.findByName("james")).andReturn(james);
		
		char direction = '?';

		replay(shipcollection);
		char result = shipcollection.findByName("james").getDirection();
		
		assertNotSame(direction,result);
	}
	
	@Test
	public void testGetShipHistory()
	{
		Ship james = new Ship("james");
		
		int xy[] = {9,7};
		james.setPosition(map, xy);
		james.setDirection('E');
		james.move(map, "npnpnpnpn");
		
		int[][] array = new int[225][2];
		for(int i=0;i<225;i++)
		{ array[i][0] = -1; array[i][1] = -1;}
		
		array[0][0] = 9; array[0][1] = 7;
		array[1][0] = 10; array[1][1] = 7;
		array[2][0] = 10; array[2][1] = 6;
		array[3][0] = 9; array[3][1] = 6;
		array[4][0] = 9; array[4][1] = 7;
		array[5][0] = 10; array[5][1] = 7;
		
		expect(shipcollection.findByName("james")).andReturn(james);
		
		replay(shipcollection);
		int[][] output = ships.getHistoryByName("james");
		
		assertArrayEquals(array,output);	
	}
	
	
}
