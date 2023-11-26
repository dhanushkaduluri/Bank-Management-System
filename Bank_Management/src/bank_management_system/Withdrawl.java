package bank_management_system;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener{
	
	JTextField amount;
	
	JButton withdraw,back;
	
	String PIN;
	
	public static void main(String[] args) {
		new Withdrawl("");
	}

	/**
	 * Create the application.
	 */
	public Withdrawl(String PIN) {
		this.PIN=PIN;
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
		
		JLabel text=new JLabel("Enter the Amount");
		text.setForeground(Color.white);
		text.setFont(new Font("system" ,Font.BOLD,17));
		text.setBounds(268,300,300,20);
		image.add(text);
		
		amount=new JTextField();
		amount.setFont(new Font("RaleWay",Font.BOLD,22));
		amount.setBounds(170,350,320,25);
		image.add(amount);
		
		withdraw=new JButton("Withdraw");
		withdraw.setBounds(355,485,150,30);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		back=new JButton("Back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==withdraw) {
			
			String depAmount=amount.getText();
			
			Date date=new Date();
			
			if(depAmount.equals(null)) {
				JOptionPane.showMessageDialog(null,"Please Enter Valid Amount");
			}else {
				Conn conn=new Conn();
				String query="insert into bank values('"+PIN+"','"+date+"','Withdraw','"+depAmount+"')";
				try {
					conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Rs."+depAmount+" Withdrawl Successful");
					setVisible(false);
					new Transactions(PIN).setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}else if(ae.getSource()==back){
			setVisible(false);
			new Transactions(PIN).setVisible(true);
		}
	}



}





