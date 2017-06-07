package spock;

public class Calculator {
	
	public int add(int a, int b) {
		return a+b;
	}
	
	public int sub(int a, int b) {
		return a-b;
	}
	
	public int mul(int a, int b) {
		return a*b;
	}
	
	public int div(int a, int b) {
		return a/b;
	}
	
	public int pow(int a, int b) {
		int c = a;
		for(int i=1;i<b;i++)
			c = c * a;
		return c;
	}
}