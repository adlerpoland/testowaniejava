package introductionHamcrest;
import java.lang.reflect.Array;
import java.util.*;

public class Friendships {
    Map<String, List<String>> friendships = new HashMap<>();

    //Dodanie przyjaciół - wykorzystuje funkcje addFriend!	
    public void makeFriends(String person1, String person2) {
    	if(friendships.containsValue(person1))
    	{
    		//PERSON 1 NIE JEST PRZYJACIELEM PERSON 2
    		if(!areFriends(person1,person2))
    		{
        		addFriend(person1,person2);
    		}
    	}
    	else //NIE MA PERSON 1
    	{
	    	List<String> friends = new ArrayList<String>();
	    	friends.add(person2);
	    	friendships.put(person1,friends);
		}
    	
    	if(friendships.containsValue(person2))
    	{
    		//PERSON 2 NIE JEST PRZYJACIELEM PERSON 1
    		if(!areFriends(person2,person1))
    		{
        		addFriend(person2,person1);
    		}
    	}
    	else //NIE MA PERSON 2
    	{
	    	List<String> friends = new ArrayList<String>();
	    	friends.add(person1);
	    	friendships.put(person2,friends);
		}
    }
    
    //Pobranie listy przyjaciol
    public List<String> getFriendsList(String person) {
        List<String> friends = friendships.get(person);
        return friends;
    }
    
    //Sprawdzenie czy przyjaciele
    public boolean areFriends(String person1, String person2) {
    	List<String> friends = friendships.get(person1);
    	for(String friend: friends)
    	{
    		if(friend.equals(person2))
    			return true;
    	}
    	return false;
    }
    //Dodanie do listy przyjaciol do danej osoby
    private void addFriend(String person, String friend){
    	List<String> friends = getFriendsList(person);
    	friends.add(friend);
    	friendships.put(person, friends);
    }
}