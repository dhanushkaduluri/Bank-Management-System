package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton login,clear,sign_up;
	JTextField card_no;
	JPasswordField pin_no;

	public Login() {
		
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		
		Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT );
		ImageIcon i3=new ImageIcon(i2);
		JLabel label=new JLabel(i3);
		label.setBounds(70, 10, 100, 100);
		add(label);
		setSize(800,480);
		getContentPane().setBackground(Color.white);
		
		//welcome text
		JLabel text=new JLabel("Welcome to ATM");
		text.setBounds(200, 40, 400, 50);  
		text.setFont(new Font("Osward",Font.BOLD,40));
		add(text);
		
		//enter card number
		JLabel cardText=new JLabel("Enter Card Number :");
		cardText.setBounds(100, 140, 300, 50);  
		cardText.setFont(new Font("Osward",Font.BOLD,25));
		add(cardText);
		//receive card number
		card_no=new JTextField();
		card_no.setBounds(350, 150, 300, 40);
		card_no.setFont(new Font("Ariel",Font.BOLD,15));
		add(card_no);
		
		//enter pin
		JLabel pinText=new JLabel("Enter PIN Number :");
		pinText.setBounds(100, 210, 300, 50);  
		pinText.setFont(new Font("Osward",Font.BOLD,25));
		add(pinText);
		//receive pin number
		pin_no=new JPasswordField();
		pin_no.setBounds(350, 220, 300, 40);
		pin_no.setFont(new Font("Ariel",Font.BOLD,15));
		add(pin_no);
		
		//add login button
		login=new JButton("Log In");
		login.setBounds(200, 300, 150, 35);
		login.setFont(new Font("Times New Roman",Font.BOLD,25));
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		//clear button
		clear=new JButton("Clear");
		clear.setBounds(400, 300, 150, 35);
		clear.setFont(new Font("Times New Roman",Font.BOLD,25));
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		add(clear);
		
		//sign up button
		sign_up=new JButton("Sign Up");
		sign_up.setBounds(300, 350, 150, 35);
		sign_up.setFont(new Font("Times New Roman",Font.BOLD,25));
		sign_up.setBackground(Color.black);
		sign_up.setForeground(Color.white);
		sign_up.addActionListener(this);
		add(sign_up);
		
		setVisible(true);
		setLocation(250,200);
		setTitle("ATM");
	}
	
	public static void main(String[] args) {
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==clear) {
			card_no.setText("");
			pin_no.setText("");
		}
		else if(e.getSource()==login) {
			Conn conn=new Conn();
			String cardnumber= card_no.getText();
			String pinnumber=pin_no.getText();
			String query="select * from login where cardnumber="+cardnumber+" and pinnumber="+pinnumber+"";
//			System.out.println(query);
			try {
				ResultSet rs= conn.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(card_no, "Incerrect Card Number or PIN");
				}
			}catch (Exception ae) {
				System.out.println(ae);
			}
		}
		else if(e.getSource()==sign_up) {
			setVisible(false);
			new SignUpOne().setVisible(true);
		}
		
	}

	

}
