package Facebook;

import java.util.*;



public class friendList
{
	private  nameNode	head;	
	private  nameNode	tail;
	public friendList() {
		
	}
	
	
	public void addFriend (String name){
       nameNode target = new nameNode(name); 
        if (head == null) { 
            head = target; 
        } 
        else { 
            nameNode last = head; 
            while (last.getNext() != null) { 
                last = last.getNext(); 
            } 
            last.setNext(target); 
            target.setNext(tail);
        } 
	}
	
	public void deleteFriend(String name) {
		
		if (head.getName().equals(name)) {
	        head=head.getNext();
	        return;
	    } 
		else {	
	        nameNode beforeTarget = head;
	        while(beforeTarget.getNext().getName().equals(name)==false) {
	        	beforeTarget= beforeTarget.getNext();
	        }
	        beforeTarget.setNext(beforeTarget.getNext().getNext());
	    }	  
	}
	
	public boolean checkFriend(String name) {
		nameNode first = head;
		while(first != null) {
			if(first.getName() != name) {
				first = first.getNext();
			}
			else {
				return true;
			}
		}
		return false;
	}

	
	
	public String toString()
	{
		String s = "";
		nameNode node = head;
		while (node != null)
		{
			s += node.getName()+" ";
			node = node.getNext();
		}
		return s;
	}

	

}
