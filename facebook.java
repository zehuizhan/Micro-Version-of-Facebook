package Facebook;

import java.util.*;

public class facebook extends friendList{
	
	public static int division(String name) {
		int number =0;
		name.toLowerCase();
		for(int i =0;i<name.length();i++) {
			char c = name.charAt(i);    
			int ascii = (int)c;
			number +=ascii;
		}
		return number%15;
	}
	public static int multiplication(String name) {
		int number = 0;
		double A = 0.618;
		for(int i =0;i<name.length();i++) {
			char c = name.charAt(i); 
			int ascii = (int)c;
			number+=ascii;
		}
		return (int)Math.floor(((number*A)%1)*15);
	}
	
	public static friendList searchList(Hashtable<Integer,ArrayList<Person>> ht,String targetName) {
		friendList targetList = new friendList();
		for(int i =0;i<ht.size();i++) {
			for(int j =0;j<ht.get(i).size();j++) {
				if(ht.get(i).get(j).getName().contains(targetName)) {
					targetList = ht.get(i).get(j).getFriends();}}}
		return targetList;
	}
	
	
	public static void chainedHashInsert(Hashtable<Integer,ArrayList<Person>> ht,String name,String targetName){
		searchList(ht,name).addFriend(targetName);	searchList(ht,targetName).addFriend(name);
	}
	
	public static void chainedHashDelete(Hashtable<Integer,ArrayList<Person>> ht,String name,String targetName){
		searchList(ht,name).deleteFriend(targetName);	searchList(ht,targetName).deleteFriend(name);
	}
	
	public static friendList chainedHashSearch(Hashtable<Integer,ArrayList<Person>> ht,String targetName){
		return searchList(ht,targetName);
	}
	
	public static boolean chainedHashCheck(Hashtable<Integer,ArrayList<Person>> ht,String name,String targetName){
		return searchList(ht,name).checkFriend(targetName);
	}
	
	public static void printHashtable(Hashtable<Integer,ArrayList<Person>> ht) {
		for(int i =0;i<ht.size();i++) {
			System.out.print("\n"+"slot"+(i+1)+":");
			for(int j =0;j<ht.get(i).size();j++) {
				System.out.print(ht.get(i).get(j).getName()+ht.get(i).get(j).getFriends()+",");}}
	}
	
	public static void main(String[] args) {
		String[] nameArray = {"Liam","Emma","Noah","Olivia","William","Ava","James","Isabella","Logan","Sophia",
							  "Benjamin","Mia","Mason","Charlotte","Elijah","Amelia","Oliver","Evelyn","Jacob","Abigail",
							  "Lucas","Harper","Michael","Emily","Alexander","Elizabeth","Ethan","Avery","Daniel","Sofia",
							  "Matthew","Ella","Aiden","Madison","Henry","Scarlett","Joseph","Victoria","Jackson","Aria",
							  "Samuel","Grace","Sebastian","Chloe","David","Camila","Carter","Penelope","Wyatt","Riley"};
		Hashtable<Integer,ArrayList<Person>> ht= new Hashtable<Integer,ArrayList<Person>>(15);
		for(int i =0;i<15;i++) {
			ht.put(i,new ArrayList<Person>());
		}
		System.out.print("Hashtable by Division Method");
		for(int i =0;i<nameArray.length;i++) {
				Person p = new Person(nameArray[i],new friendList());
				int slot = division(nameArray[i]);
				ht.get(slot).add(p);
		}
		printHashtable(ht);
	}
}
