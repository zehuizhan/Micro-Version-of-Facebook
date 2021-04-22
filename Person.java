package Facebook;

import java.util.*;
public class Person {
	
	private String name;
	private friendList friends;
	
	public Person(String name,friendList friends) {
		this.name = name;
		this.friends = friends;
	}
	
	public String getName() {return name;}
	
	public friendList getFriends() {return friends;}
}

