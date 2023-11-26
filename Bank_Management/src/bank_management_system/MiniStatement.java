package bank_management_system;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame {

	String pinnumber;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new MiniStatement("");
	}

	/**
	 * Create the application.
	 */
	public MiniStatement(String pinnumber) {
		this.pinnumber=pinnumber;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Mini Statement");
		setLayout(null);
		
		JLabel mini=new JLabel();
		
		
		JLabel bank=new JLabel("NATIONAL BANK");
		bank.setBounds(140,20,100,20);
		add(bank);
		
		JLabel card= new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		JLabel balance= new JLabel();
		balance.setBounds(20,150,300,20);
		add(balance);
		
		
		
		try {
			Conn conn=new Conn();
			ResultSet rs=conn.s.executeQuery("select * from login where pinnumber='"+pinnumber+"'");
			while(rs.next()) {
				card.setText("Card Number: " +rs.getString("cardnumber").substring(0,4)+" XXXX XXXX "+rs.getString("cardnumber").substring(12));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		try {
			Conn conn=new Conn();
			int balancex=0;
			ResultSet rs=conn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
			while(rs.next()) {
				mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br></html>");
				add(mini);
				if(rs.getString("type").equals("Deposit")) {
					balancex+=Integer.parseInt(rs.getString("amount"));
				}else {
					balancex-=Integer.parseInt(rs.getString("amount"));
				}
			}
			
			balance.setText("Your Current Balance : Rs."+balancex);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		mini.setBounds(20,140,400,200);
		
		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.white);
		setVisible(true);
	}

}
