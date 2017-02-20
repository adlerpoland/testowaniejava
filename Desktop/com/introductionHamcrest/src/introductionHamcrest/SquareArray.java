package introductionHamcrest;

import java.util.ArrayList;
import java.util.List;

public class SquareArray {
	
	private List<Integer> list;

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}
	
	public void podniesDoKwadratu()
	{
		List <Integer> temp = getList();
		List <Integer> result = new ArrayList<Integer>();
		for(Integer i :temp)
		{
			i = i*i;	
			result.add(i);
		}
		setList(result);
	}
	
	public boolean znajdzWartosc(int wartosc){
		List <Integer> temp = getList();
		for(Integer i:temp)
		{
			if(i==wartosc)
				return true;
		}
		return false;
	}
	
	public void dodajOdejmij(int wartosc){
		List <Integer> temp = getList();
		List <Integer> result = new ArrayList<Integer>();
		for(Integer i:temp)
		{
			i=i+wartosc;
			result.add(i);
		}
		setList(result);
	}

}
