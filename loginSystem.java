package Facebook;


//https://www.youtube.com/watch?v=-hpX9oEvoXc
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class loginSystem {

	private JFrame frmMicroVersionOf;
	public JTextField txtUser;
	private JPasswordField txtPassword;

	static final 	String[] nameArray = {"Liam","Emma","Noah","Olivia","William","Ava","James","Isabella","Logan","Sophia",
			  "Benjamin","Mia","Mason","Charlotte","Elijah","Amelia","Oliver","Evelyn","Jacob","Abigail",
			  "Lucas","Harper","Michael","Emily","Alexander","Elizabeth","Ethan","Avery","Daniel","Sofia",
			  "Matthew","Ella","Aiden","Madison","Henry","Scarlett","Joseph","Victoria","Jackson","Aria",
			  "Samuel","Grace","Sebastian","Chloe","David","Camila","Carter","Penelope","Wyatt","Riley"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginSystem window = new loginSystem();
					window.frmMicroVersionOf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public loginSystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMicroVersionOf = new JFrame();
		frmMicroVersionOf.setBackground(new Color(0, 51, 204));
		frmMicroVersionOf.setTitle("Micro Version of Facebook");
		frmMicroVersionOf.setBounds(100, 100, 451, 301);
		frmMicroVersionOf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMicroVersionOf.getContentPane().setLayout(null);
		frmMicroVersionOf.setLocation(600,350);
		
		JLabel lblNewLabel = new JLabel("Welcome to the Facebook");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblNewLabel.setBounds(106, 17, 256, 44);
		frmMicroVersionOf.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email or Phone");
		lblNewLabel_1.setBounds(42, 81, 104, 16);
		frmMicroVersionOf.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(64, 137, 61, 16);
		frmMicroVersionOf.getContentPane().add(lblNewLabel_2);
		
		txtUser = new JTextField();
		txtUser.setText("JamesWillGetBouns@gmail.com");
		txtUser.setBounds(145, 76, 228, 26);
		frmMicroVersionOf.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(145, 132, 228, 26);
		frmMicroVersionOf.getContentPane().add(txtPassword);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String> nameList = new ArrayList<String>();
				for(int i =0;i<nameArray.length;i++) {
					nameList.add(nameArray[i]);
				}
				String password = txtPassword.getText();
				
				
					if(password.contains("handsome")) {
						JOptionPane.showMessageDialog(null,"Log in successfully");
						frmMicroVersionOf.setVisible(false);
						home.main(null);
					}
					else {
						txtPassword.setText(null);
						JOptionPane.showMessageDialog(null,"Password is not correct"+"\n"+"Check out the bottom 'forgot password'");
					}
				}
				
				
		});
		btnLogIn.setBounds(173, 208, 117, 29);
		frmMicroVersionOf.getContentPane().add(btnLogIn);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(316, 208, 117, 29);
		frmMicroVersionOf.getContentPane().add(btnQuit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUser.setText("JamesWillGetBouns@gmail.com");
				txtPassword.setText(null);
			}
		});
		btnReset.setBounds(30, 208, 117, 29);
		frmMicroVersionOf.getContentPane().add(btnReset);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 172, 438, 12);
		frmMicroVersionOf.getContentPane().add(separator);
		
		JButton btnNewButton = new JButton("forgot password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Hint:"+"\n"+"How is Professor Wu?");
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnNewButton.setForeground(SystemColor.inactiveCaptionText);
		btnNewButton.setBounds(280, 156, 100, 20);
		frmMicroVersionOf.getContentPane().add(btnNewButton);
	}
	
}
