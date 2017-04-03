
public class CalculatorDouble
{
	public double add(double a,double b)
	{
		return a+b;
	}
	public double sub(double a,double b)
	{
		return a-b;
	}
	public double multi(double a,double b)
	{
		return a*b;
	}
	public double div(double a,double b)
	{
		if(b==0.0)
			throw new IllegalArgumentException();
		return (double)(a/b);
	}
	public boolean greater(double a,double b)
	{
		if(a>b)return true;
		return false;
	}
}