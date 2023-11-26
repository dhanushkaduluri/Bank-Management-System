package bank_management_system;

import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JFrame;

public class SignUpThree extends JFrame implements ActionListener{

	
	
	JRadioButton r1,r2,r3,r4;
	
	JCheckBox c1,c2,c3,c4,c5;
	
	JButton cancel,submit;
	
	String formno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new SignUpThree("");
	}

	/**
	 * Create the application.
	 */
	public SignUpThree(String formno) {
		this.formno=formno;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setLayout(null);
		JLabel l1=new JLabel("Page 3: Account Details");
		l1.setBounds(280,40,400,40);
		l1.setFont(new Font("Raleway",Font.BOLD,22));
		add(l1);
		
		JLabel type=new JLabel("Account Type");
		type.setFont(new Font("Raleway",Font.BOLD,16));
		type.setBounds(100,140,200,30);
		add(type);
		
		r1=new JRadioButton("Saving Account");
		r1.setFont(new Font("Raleway",Font.BOLD,16));
		r1.setBackground(Color.white);
		r1.setBounds(100,180,200,20);
		add(r1);
		
		r2=new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("Raleway",Font.BOLD,16));
		r2.setBackground(Color.white);
		r2.setBounds(350,180,200,20);
		add(r2);
		
		r3=new JRadioButton("Current Account");
		r3.setFont(new Font("Raleway",Font.BOLD,16));
		r3.setBackground(Color.white);
		r3.setBounds(100,220,200,20);
		add(r3);
		
		r4=new JRadioButton("Reccuring Deposit Account");
		r4.setFont(new Font("Raleway",Font.BOLD,16));
		r4.setBackground(Color.white);
		r4.setBounds(350,220,250,20);
		add(r4);
		
		ButtonGroup group=new ButtonGroup();
		group.add(r1);
		group.add(r2);
		group.add(r3);
		group.add(r4);
		
		JLabel card=new JLabel("Card Number");
		card.setFont(new Font("Raleway",Font.BOLD,16));
		card.setBounds(100,300,200,30);
		add(card);
		
		JLabel cardDetail=new JLabel("Your 16 Digit Card Number");
		cardDetail.setFont(new Font("Raleway",Font.ITALIC,12));
		cardDetail.setBounds(100,330,300,20);
		add(cardDetail);
		
		JLabel number=new JLabel("XXXX-XXXX-XXXX-1234");
		number.setFont(new Font("Raleway",Font.BOLD,16));
		number.setBounds(330,300,200,30);
		add(number);
		
		JLabel pin=new JLabel("PIN");
		pin.setFont(new Font("Raleway",Font.BOLD,16));
		pin.setBounds(100,370,200,30);
		add(pin);
		
		JLabel pinDetail=new JLabel("Your 4 Digit PIN");
		pinDetail.setFont(new Font("Raleway",Font.ITALIC,12));
		pinDetail.setBounds(100,400,300,20);
		add(pinDetail);
		
		JLabel pnumber=new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway",Font.BOLD,16));
		pnumber.setBounds(330,370,200,30);
		add(pnumber);
		
		JLabel service=new JLabel("Services Required");
		service.setFont(new Font("Raleway",Font.BOLD,16));
		service.setBounds(100,450,300,30);
		add(service);
		
		c1=new JCheckBox("ATM Card");
		c1.setBackground(Color.white);
		c1.setFont(new Font("Raleway",Font.BOLD,16));
		c1.setBounds(100,500,200,30);
		add(c1);
		
		c2=new JCheckBox("Internet Banking");
		c2.setBackground(Color.white);
		c2.setFont(new Font("Raleway",Font.BOLD,16));
		c2.setBounds(350,500,200,30);
		add(c2);
		
		c3=new JCheckBox("Mobile Banking");
		c3.setBackground(Color.white);
		c3.setFont(new Font("Raleway",Font.BOLD,16));
		c3.setBounds(100,550,200,30);
		add(c3);
		
		c4=new JCheckBox("Check Box");
		c4.setBackground(Color.white);
		c4.setFont(new Font("Raleway",Font.BOLD,16));
		c4.setBounds(350,550,200,30);
		add(c4);
		
		c5=new JCheckBox("I hereby declare that above entered datails are correct to the best of my knowledge");
		c5.setBackground(Color.white);
		c5.setFont(new Font("Raleway",Font.BOLD,12));
		c5.setBounds(100,610,1000,30);
		add(c5);
		
		submit=new JButton("SUBMIT");
		submit.setForeground(Color.white);
		submit.setBackground(Color.black);
		submit.setFont(new Font("Raleway",Font.BOLD,15));
		submit.setBounds(450,650,100,30);
		add(submit);
		submit.addActionListener(this);
		
		cancel=new JButton("CANCEL");
		cancel.setForeground(Color.white);
		cancel.setBackground(Color.black);
		cancel.setFont(new Font("Raleway",Font.BOLD,15));
		cancel.setBounds(250,650,100,30);
		add(cancel);
		cancel.addActionListener(this);
		
		getContentPane().setBackground(Color.white);
		
		setSize(850,820);
		setLocation(350,0);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource().equals(submit)) {
			String accountType=null;
			if(r1.isSelected()) {
				accountType="Saving Account";
			}else if(r2.isSelected()) {
				accountType="Fixed Deposit Account";
			}else if(r3.isSelected()) {
				accountType="Current Account";
			}else if(r4.isSelected()) {
				accountType="Reccuring Deposit Account";
			}
			
			Random random =new Random();
			String cardNumber=""+Math.abs((random.nextLong() % 90000000L)+ 504093600000000L);
			String pinNumber=" " + Math.abs((random.nextLong()%9000L)+1000L);
			
			String services="";
			
			if(c1.isSelected()) {
				services +=" ATM Card";
			}else if(c2.isSelected()) {
				services +=" Internet Banking";
			}else if(c3.isSelected()) {
				services +=" Mobile Banking";
			}else if(c4.isSelected()) {
				services +=" Check Book";
			}
			
			try {
				if(c5.isSelected()==false) {
					JOptionPane.showMessageDialog(null, "Declaration Is Required");
				}else {
					Conn conn=new Conn();
					String query1 = "insert into signup_three values('"+formno+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+services+"')";
					String query2 = "insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
					
					conn.s.executeUpdate(query1);
					conn.s.executeUpdate(query2);
					
					JOptionPane.showMessageDialog(null, "Your Account Details \nCardNumber :"+cardNumber+" \nPIN :"+pinNumber+" \nDeposit Minimum Balance Atleast Rs.500");
					
					new Deposit(PIN).setVisible(true);
				}
			}catch (Exception e) {
				System.out.println(e);
			}
			
			
		}else if(ae.getSource()== cancel) {
			setVisible(false);
			new Login().setVisible(true);;
		}
		
	}
	

}
