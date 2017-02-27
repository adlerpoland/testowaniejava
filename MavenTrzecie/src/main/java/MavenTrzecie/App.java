package MavenTrzecie;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public static int BinSearch(int[] list, int value)
    {
		if(list.length<1)
		{
			System.out.println("Twoja lista jest pusta!");
			return -1;
		}
    	System.out.println("Binsearch");
		int left = 1;
		int right = list.length;
		int id;
		while (left < right)
		{
			int middle = (left + right)/2;
			if (list[middle] < value)
				left = middle + 1;
			else
				right = middle;
		}
		 
		
		if(list[left] == value)
		{
			id = left;
			System.out.println("Wyszukany index: " + id);
		}
		else
		{
			id = -1;
			System.out.println("Nie znaleziono obiektu");
		}
		return id;
	}
}
