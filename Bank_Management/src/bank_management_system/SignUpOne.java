package bank_management_system;

import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.ActionListener;

import com.toedter.calendar.JDateChooser;





public class SignUpOne extends JFrame implements ActionListener{

	private JFrame frame;
	
	long random;
	
	JTextField rname,rfname,eadress,raddrs,rcity,rcode,rstate;
	
	JRadioButton male,female,married,single,other;
	
	JDateChooser datechooser;
	
	JButton next;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpOne window = new SignUpOne();
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
	public SignUpOne() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setLayout(null);
		frame.setBounds(260, 20, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		
		
		
		//form number
		Random ran=new Random();
		random=Math.abs((ran.nextLong()%9000L)+1000L);
		JLabel formno=new JLabel("APPLICATION FORM NO :" + random);
		formno.setFont(new Font("Ralewy",Font.BOLD,38));
		formno.setBounds(100,20,600,40);
		frame.add(formno);
		
		//personal details
		JLabel details=new JLabel("Page 1: Personal Details");
		details.setFont(new Font("Ralewy",Font.BOLD,22));
		details.setBounds(270,80,400,30);
		frame.add(details);
	
		
		// name of the user
		JLabel name=new JLabel("Name:");
		name.setFont(new Font("Ralewy",Font.BOLD,18));
		name.setBounds(120,150,100,30);
		frame.add(name);
		
		rname=new JTextField();
		rname.setBounds(310,150,300,30);
		rname.setFont(new Font("Ralewy",Font.ROMAN_BASELINE,17));
		frame.add(rname);
		
		//father name
		JLabel fname=new JLabel("Father's Name:");
		fname.setFont(new Font("Ralewy",Font.BOLD,18));
		fname.setBounds(120,190,200,30);
		frame.add(fname);
		
		rfname=new JTextField();
		rfname.setBounds(310,190,300,30);
		rfname.setFont(new Font("Ralewy",Font.ROMAN_BASELINE,17));
		frame.add(rfname);
		
		//Date of birth
		JLabel dob=new JLabel("Date of Birth:");
		dob.setFont(new Font("Ralewy",Font.BOLD,18));
		dob.setBounds(120,230,200,30);
		frame.add(dob);
		
		datechooser=new JDateChooser();
		datechooser.setBounds(310,230,300,30);
		frame.add(datechooser);
		
		
		//gender
		JLabel gender=new JLabel("Gender:");
		gender.setFont(new Font("Ralewy",Font.BOLD,18));
		gender.setBounds(120,270,100,30);
		frame.add(gender);
		
		male=new JRadioButton("Male");
		male.setBounds(340,270,100,30);
		male.setBackground(Color.WHITE);
		frame.add(male);
		
		female=new JRadioButton("Female");
		female.setBounds(440,270,100,30);
		female.setBackground(Color.WHITE);
		frame.add(female);
		
		
		//email address
		JLabel eAddress=new JLabel("E-Mail Address:");
		eAddress.setFont(new Font("Ralewy",Font.BOLD,18));
		eAddress.setBounds(120,310,200,30);
		frame.add(eAddress);
		
		eadress=new JTextField();
		eadress.setBounds(310,310,300,30);
		eadress.setFont(new Font("Ralewy",Font.ROMAN_BASELINE,17));
		frame.add(eadress);
		
		// marital status
		JLabel mstatus=new JLabel("Marital Status:");
		mstatus.setFont(new Font("Ralewy",Font.BOLD,18));
		mstatus.setBounds(120,350,200,30);
		frame.add(mstatus);
		
		married=new JRadioButton("Married");
		married.setBounds(340,350,100,30);
		married.setBackground(Color.WHITE);
		frame.add(married);
		
		single=new JRadioButton("Single");
		single.setBounds(440,350,100,30);
		single.setBackground(Color.WHITE);
		frame.add(single);
		
		//Address
		JLabel address=new JLabel("Address:");
		address.setFont(new Font("Ralewy",Font.BOLD,18));
		address.setBounds(120,390,100,30);
		frame.add(address);
		
		 raddrs=new JTextField();
		raddrs.setBounds(310,390,300,30);
		raddrs.setFont(new Font("Ralewy",Font.ROMAN_BASELINE,17));
		frame.add(raddrs);
		
		//city
		JLabel city=new JLabel("City:");
		city.setFont(new Font("Ralewy",Font.BOLD,18));
		city.setBounds(120,430,100,30);
		frame.add(city);
		
		 rcity=new JTextField();
		rcity.setBounds(310,430,300,30);
		rcity.setFont(new Font("Ralewy",Font.ROMAN_BASELINE,17));
		frame.add(rcity);
		
		//state
		JLabel state=new JLabel("State:");
		state.setFont(new Font("Ralewy",Font.BOLD,18));
		state.setBounds(120,470,100,30);
		frame.add(state);
		
		 rstate=new JTextField();
		rstate.setBounds(310,470,300,30);
		rstate.setFont(new Font("Ralewy",Font.ROMAN_BASELINE,17));
		frame.add(rstate);
		
		//pin code
		JLabel pinCode=new JLabel("Pin Code:");
		pinCode.setFont(new Font("Ralewy",Font.BOLD,18));
		pinCode.setBounds(120,510,100,30);
		frame.add(pinCode);
		
		 rcode=new JTextField();
		rcode.setBounds(310,510,300,30);
		rcode.setFont(new Font("Ralewy",Font.ROMAN_BASELINE,17));
		frame.add(rcode);
		
		//next button
		
		next=new JButton("Next");
		next.setBounds(570,550,100,40);
		next.setFont(new Font("Ralewy",Font.ROMAN_BASELINE,17));
		next.setOpaque(true);
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		frame.add(next);
		next.addActionListener(this);
		
		
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String formno="" + random;
		String name=rname.getText();
		String fname=rfname.getText();
		String dob=((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
		String gender=null;
		if(male.isSelected()) {
			gender="Male";
		}else {
			gender="Female";
		}
		String email=eadress.getText();
		String address=raddrs.getText();
		String mstatus=null;
		if(married.isSelected()) {
			mstatus="Married";	
		}else {
			mstatus="Single";
		}
		String state=rstate.getText();
		String pincode=rcode.getText();
		String city=rcity.getText();
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required");
			}else {
				Conn c=new Conn();
				String Query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+email+"','"+address+"','"+mstatus+"','"+gender+"','"+city+"','"+state+"','"+pincode+"')";
				c.s.executeUpdate(Query);
				
				setVisible(false);
				new SignUpTwo(formno).setVisible(true);
			}
		}                                                                                                                                                   
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
















