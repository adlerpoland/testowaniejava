
public class NWD 
{
	public int liczNWD(int a, int b)
	{
		a = Math.abs(a);
		b = Math.abs(b);
		if(a==0 && b==0)
			throw new IllegalArgumentException();
		if(a==0)
			return b;
		if(b==0)
			return a;
		while(a!=b)
		{
			if(a>b)a=a-b;
			if(b>a)b=b-a;
		}
		return a;
	}
}
