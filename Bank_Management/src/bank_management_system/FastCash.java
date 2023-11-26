package bank_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Date;
import java.sql.*;
import javax.swing.*;


public class FastCash extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton deposit,withdrawl,ministatement,pinchange,exit,balanceenquery,fastcash;
	
	String pinnumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new FastCash(" ");
	}

	/**
	 * Create the application.
	 */
	public FastCash(String pinnumber) {
		this.pinnumber=pinnumber;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text=new JLabel("Select Withdrawl Amount");
		text.setBounds(215,300,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("Calbri", Font.BOLD,17));
		image.add(text);
		
		deposit = new JButton("Rs.100");
		deposit.setBounds(170,415,150,30);
		image.add(deposit);
		deposit.addActionListener(this);
		
		withdrawl = new JButton("Rs.500");
		withdrawl.setBounds(355,415,150,30);
		image.add(withdrawl);
		withdrawl.addActionListener(this);
		
		fastcash = new JButton("Rs.1000");
		fastcash.setBounds(170,450,150,30);
		image.add(fastcash);
		fastcash.addActionListener(this);
		
		ministatement = new JButton("Rs.2000");
		ministatement.setBounds(355,450,150,30);
		image.add(ministatement);
		ministatement.addActionListener(this);
		
		pinchange = new JButton("Rs.5000");
		pinchange.setBounds(170,485,150,30);
		image.add(pinchange);
		pinchange.addActionListener(this);
		
		balanceenquery = new JButton("Rs.10000");
		balanceenquery.setBounds(355,485,150,30);
		image.add(balanceenquery);
		balanceenquery.addActionListener(this);
		
		exit = new JButton("Back");
		exit.setBounds(260,520,150,30);
		image.add(exit);
		exit.addActionListener(this);
		
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exit) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}else {
			String amount=((JButton)ae.getSource()).getText().substring(3);
			Conn c=new Conn();
			try {
				ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
				int balance=0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance+=Integer.parseInt(rs.getString("amount"));
					}else {
						balance-=Integer.parseInt(rs.getString("amount"));
					}
				}
				if(ae.getSource()!=exit && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				
				Date date = new Date();
				String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs."+amount+"Debited Successfully");
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
	}

}
