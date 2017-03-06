package ships;

public class Ship 
{
	private int[] xy = {0,0};
	private char dir = 'N';
	private int[] mapsize = {20,20};
	
	
    public void setPosition(int[] xxyy)
    {
		xy = xxyy;
	}
	
	public int[] getPosition()
	{
		return xy;
	}
	
	public void setDirection(char direction)
	{
		dir = direction;
	}
	
	public char getDirection()
	{
		return dir;
	}
	
	public int[] getMapSize()
	{
		return mapsize;
	}
	
	public boolean move(String str)
	{
		//nnnlnnpnnw
		int n = str.length()
		for(int i=0,i<n,i++)
		{
			char c = str.charAt(i);
			switch(c){
				case 'n':
				
					break;
				case 'w':
				
					break;
				case 'l':
					
					break
				case 'p':
				
					break;
				default: return false;
					break;
			}
		}
	}
	
	public boolean isIsland()
	{
		
	}
	
}
