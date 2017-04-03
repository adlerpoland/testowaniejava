
public class Greeting {
	
	public String returnMessage(String string){
		if (string == null){
			throw new IllegalArgumentException();
		}
		return "Hello " + string;
	}

}
