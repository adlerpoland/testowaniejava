package introductionHamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SquareArrayTest {
	
	private SquareArray array; 

	@Before
	public void setUp() throws Exception {
		array = new SquareArray();
	}
	
	@Test
	public void getArray(){
		array.setList(Arrays.asList(1,2,3));
		List <Integer> tempList = array.getList();
		assertThat(tempList,contains(1,2,3));
	}
	
	@Test
	public void podniesDoKwadratu(){
		array.setList(Arrays.asList(1,2,3));
		List <Integer> tempList = array.getList();
		assertThat(tempList, hasSize(3));
		
		array.podniesDoKwadratu();
		tempList = array.getList();
		assertThat(tempList, contains(1,4,9));
		
		array.podniesDoKwadratu();
		tempList = array.getList();
		assertThat(tempList, contains(1,16,81));
	}
	
	@Test
	public void podniesDoKwadratu2(){
		array.setList(Arrays.asList(-5,-1,2));
		List <Integer> tempList = array.getList();
		assertThat(tempList, hasSize(3));
		
		array.podniesDoKwadratu();
		tempList = array.getList();
		assertThat(tempList, contains(25,1,4));
	}
	
	
	
	@Test
	public void czyIstniejeWartosc(){
		array.setList(Arrays.asList(3,8,9,15,2,1));
		boolean result = array.znajdzWartosc(8);
		assertThat(result,is(true));
		
		result = array.znajdzWartosc(1);
		assertThat(result,is(true));
		
		result = array.znajdzWartosc(3);
		assertThat(result,is(true));
		
		result = array.znajdzWartosc(10);
		assertThat(result,is(false));
	}
	
	@Test
	public void zwiekszWartosc(){
		array.setList(Arrays.asList(1,2,5,8));
		array.dodajOdejmij(3);
		List <Integer> tempList = array.getList();
		assertThat(tempList,contains(4,5,8,11));
		assertThat(tempList,hasSize(4));
			
		array.dodajOdejmij(-5);
		tempList = array.getList();
		assertThat(tempList,contains(-1,0,3,6));
	}
	
	@Test
	public void pustaLista(){
		array.setList(new ArrayList<Integer>());
		List <Integer> tempList = array.getList();
		assertThat(tempList, hasSize(0));
		
		array.podniesDoKwadratu();
		tempList = array.getList();
		assertThat(tempList, hasSize(0));
		
		array.dodajOdejmij(3);
		tempList = array.getList();
		assertThat(tempList, hasSize(0));
		
		array.znajdzWartosc(0);
		tempList = array.getList();
		assertThat(tempList, hasSize(0));
	}

	@After
	public void tearDown() throws Exception {
		array = null;
	}
	
}
