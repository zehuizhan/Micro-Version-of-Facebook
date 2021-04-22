package Facebook;

import java.awt.EventQueue;
import java.util.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class home extends loginSystem{

	private static JFrame frame;
	static final 	String[] nameArray = {"Liam","Emma","Noah","Olivia","William","Ava","James","Isabella","Logan","Sophia",
			  "Benjamin","Mia","Mason","Charlotte","Elijah","Amelia","Oliver","Evelyn","Jacob","Abigail",
			  "Lucas","Harper","Michael","Emily","Alexander","Elizabeth","Ethan","Avery","Daniel","Sofia",
			  "Matthew","Ella","Aiden","Madison","Henry","Scarlett","Joseph","Victoria","Jackson","Aria",
			  "Samuel","Grace","Sebastian","Chloe","David","Camila","Carter","Penelope","Wyatt","Riley"};
	
	public static int division(String name) {
		int number =0;
		name.toLowerCase();
		for(int i =0;i<name.length();i++) {
			char c = name.charAt(i);    
			int ascii = (int)c;
			number +=ascii;//*Math.pow(26,name.length()-1-i);
		}
		return number%15;
	}
	
	
	public static friendList searchList(Hashtable<Integer,ArrayList<Person>> ht,String targetName) {
		friendList targetList = new friendList();
		for(int i =0;i<ht.size();i++) {
			for(int j =0;j<ht.get(i).size();j++) {
				if(ht.get(i).get(j).getName().contains(targetName)) {
					targetList = ht.get(i).get(j).getFriends();
				}
			}
		}
		return targetList;
	}
	
	
	public static void chainedHashInsert(Hashtable<Integer,ArrayList<Person>> ht,String name,String targetName){
		searchList(ht,name).addFriend(targetName);
		searchList(ht,targetName).addFriend(name);
	}
	
	public static void chainedHashDelete(Hashtable<Integer,ArrayList<Person>> ht,String name,String targetName){
		searchList(ht,name).deleteFriend(targetName);
		searchList(ht,targetName).deleteFriend(name);
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
				System.out.print(ht.get(i).get(j).getName()+":"+ht.get(i).get(j).getFriends()+",");
			}
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Hashtable<Integer,ArrayList<Person>> ht= new Hashtable<Integer,ArrayList<Person>>(15);

		for(int i =0;i<15;i++) {
			ht.put(i,new ArrayList<Person>());
		}
		
		for(int i =0;i<nameArray.length;i++) {
			Person p = new Person(nameArray[i],new friendList());
			int slot = division(nameArray[i]);
			ht.get(slot).add(p);
			
			frame = new JFrame();
			frame.setResizable(false);
			frame.setBounds(100, 100, 247, 511);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JButton btnNewButton = new JButton("Add Friend");
			btnNewButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					String target = (String) JOptionPane.showInputDialog(null,"Choose a guy to add:\n", "Add Friend", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), nameArray,null);  
					if(target.equals("James")) {
						JOptionPane.showMessageDialog(null,"Can not add yourself"+"\n"+"Adding "+target+" Unsuccessfully");
						return;
					}
					if(searchList(ht,"James").toString().contains(target)) {
						JOptionPane.showMessageDialog(null,target+" was your friend" +"\n"+"Adding "+target+" Unsuccessfully");
						return;
					}
					chainedHashInsert(ht,"James",target);
					JOptionPane.showMessageDialog(null,"Adding "+target+" Successfully");
				}
			});
			btnNewButton.setBounds(6, 304, 117, 29);
			frame.getContentPane().add(btnNewButton);
			
			JLabel welcome = new JLabel("Welcome back, James!");
			welcome.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			welcome.setBounds(6, 23, 201, 29);
			frame.getContentPane().add(welcome);
			
			JButton btnDeleteFriend = new JButton("Delete Friend");
			btnDeleteFriend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String target = (String) JOptionPane.showInputDialog(null,"Choose a guy to delete:\n", "Delete Friend", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), nameArray,null); 
					if(target.equals("James")) {
						JOptionPane.showMessageDialog(null,"Can not delete yourself"+"\n"+"Deleting "+target+" Unsuccessfully");
						return;
					}
					if(searchList(ht,"James").checkFriend(target)==false) {
						JOptionPane.showMessageDialog(null,target+" is not your friend"+"\n"+"deleting "+target+" Unsuccessfully");
					}
					chainedHashDelete(ht,"James",target);
					JOptionPane.showMessageDialog(null,"Deleting "+target+" Successfully");
				}
			});
			btnDeleteFriend.setBounds(124, 304, 117, 29);
			frame.getContentPane().add(btnDeleteFriend);
			
			JButton btnNewButton_1 = new JButton("Search Friend");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String target = (String) JOptionPane.showInputDialog(null,"Choose a guy to search:\n", "Search Friend", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), nameArray,null);
					if(searchList(ht,target).toString().equals("")) {
						JOptionPane.showMessageDialog(null,target+" just sign up and don't have any friend yet");
						return;
					}
					JOptionPane.showMessageDialog(null,target+"'s friends list:"+"\n"+searchList(ht,target));
				}
			});
			btnNewButton_1.setBounds(6, 345, 117, 29);
			frame.getContentPane().add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("Check Friend");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			String target1 = (String) JOptionPane.showInputDialog(null,"Choose a guy to check:\n", "Check Friend", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), nameArray,null);
			String target2 = (String) JOptionPane.showInputDialog(null,"Choose anthor guy to check:\n", "Check Friend", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), nameArray,null);
			if(target1.equals(target2)) {
				JOptionPane.showMessageDialog(null,"Can not choose the same guy");
				return;
			}
			JOptionPane.showMessageDialog(null,"True: they are friend; False: they are not friend"+"\n"+"Checking Result: "+chainedHashCheck(ht,target1,target2));
		}
	});
			btnNewButton_2.setBounds(124, 345, 117, 29);
			frame.getContentPane().add(btnNewButton_2);
			
		
			JSeparator separator = new JSeparator();
			separator.setBounds(6, 288, 235, 1);
			frame.getContentPane().add(separator);
			
			JButton btnNewButton_3 = new JButton("Your Friend List");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(searchList(ht,"James").toString().equals("")) {
						JOptionPane.showMessageDialog(null,"It is pathetic for someone don't have any friend"+"\n"+"Try to click the 'Add Friend' bottom");
					}
					else {
						JOptionPane.showMessageDialog(null,"James's Friends List:"+"\n"+searchList(ht,"James"));
					}
				}
			});
			btnNewButton_3.setToolTipText("Your\nFriend\nList");
			btnNewButton_3.setBounds(56, 103, 117, 90);
			frame.getContentPane().add(btnNewButton_3);
			
			
			
		}
		
	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		


	}
}

