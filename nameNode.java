package Facebook;


public class nameNode {
		private String		name;
		private nameNode	next;	
		
		nameNode(String name){this.name = name; }
		
		nameNode getNext(){return next;}
		
		void setNext(nameNode next){this.next = next;}
		
		String getName(){return name;}
}
