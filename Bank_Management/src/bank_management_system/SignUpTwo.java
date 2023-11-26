package bank_management_system;

import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.ActionListener;

import com.toedter.calendar.JDateChooser;





public class SignUpTwo extends JFrame implements ActionListener{

	private JFrame frame;
	
	String random;
	
	JComboBox<String> religion,occupation,category,income,education;
	
	JTextField rname,rfname,eadress,raddrs,rcity,rcode,rstate,pan,aadhaar;
	
	JRadioButton male,female,married,single,other,scity,notcity,exist,notexist;
	
	JDateChooser datechooser;
	
	JButton next;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpTwo window = new SignUpTwo("");
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

	public SignUpTwo(String s) {
		initialize(s);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String s) {
		random=s;
		frame = new JFrame();
		frame.setLayout(null);
		frame.setBounds(260, 20, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		
		setTitle("NEW APLLICATION FORM - PAGE 2");
		
		
		//personal details
		JLabel details=new JLabel("Page 1: Additional Details");
		details.setFont(new Font("Ralewy",Font.BOLD,22));
		details.setBounds(270,80,400,30);
		frame.add(details);
	
		
		// Religion of the user
		JLabel name=new JLabel("Religion:");
		name.setFont(new Font("Ralewy",Font.BOLD,18));
		name.setBounds(120,150,100,30);
		frame.add(name);
		
		String[] value= {"choose...","Hindu","Muslim","Cristian","Other" };
		religion = new JComboBox<>(value);
		religion.setBounds(310,150,300,30);
		religion.setBackground(Color.WHITE);
		religion.setFont(new Font("Ralewy",Font.ROMAN_BASELINE,17));
		frame.add(religion);
		
		//category
		JLabel fname=new JLabel("Category:");
		fname.setFont(new Font("Ralewy",Font.BOLD,18));
		fname.setBounds(120,190,200,30);
		frame.add(fname);
		
		String catValue[]= {"choose...","OBC","OC","SC/ST","GENERAL","OTHER" };
		category=new JComboBox<>(catValue);
		category.setBounds(310,190,300,30);
		category.setBackground(Color.WHITE);
		category.setFont(new Font("Ralewy",Font.ROMAN_BASELINE,17));
		frame.add(category);
		
		//Date of birth
		JLabel dob=new JLabel("Income:");
		dob.setFont(new Font("Ralewy",Font.BOLD,18));
		dob.setBounds(120,230,200,30);
		frame.add(dob);
		
		String incValue[]= {"choose...","NULL","<1,50,000","<2,50,000","<5,00,000",">5,00,000" };
		income=new JComboBox<>(incValue);
		income.setBounds(310,230,300,30);
		income.setFont(new Font("Ralewy",Font.ROMAN_BASELINE,17));
		income.setBackground(Color.WHITE);
		frame.add(income);
		
		
		//gender
		JLabel gender=new JLabel("Educational");
		gender.setFont(new Font("Ralewy",Font.BOLD,18));
		gender.setBounds(120,280,120,30);
		frame.add(gender);
		
		
		//email address
		JLabel eAddress=new JLabel("Qualification:");
		eAddress.setFont(new Font("Ralewy",Font.BOLD,18));
		eAddress.setBounds(120,300,250,30);
		frame.add(eAddress);
		
		String eduValue[]= {"choose...","Non-Graaduate","Graduate","Under-Grad","Post-Grad","Doctrate" };
		education=new JComboBox<>(eduValue);
		education.setBounds(310,290,300,30);
		education.setFont(new Font("Ralewy",Font.ROMAN_BASELINE,17));
		education.setBackground(Color.WHITE);
		frame.add(education);
		
		// marital status
		JLabel mstatus=new JLabel("Occupation:");
		mstatus.setFont(new Font("Ralewy",Font.BOLD,18));
		mstatus.setBounds(120,350,250,30);
		frame.add(mstatus);
		
		String occValue[]= {"choose...","Salaried","Self-Employement","Bussiness","Student","Retired" };
		occupation=new JComboBox<>(occValue);
		occupation.setBounds(310,350,300,30);
		occupation.setFont(new Font("Ralewy",Font.ROMAN_BASELINE,17));
		occupation.setBackground(Color.WHITE);
		frame.add(occupation);
		
		
		
		//Address
		JLabel address=new JLabel("PAN No:");
		address.setFont(new Font("Ralewy",Font.BOLD,18));
		address.setBounds(120,390,100,30);
		frame.add(address);
		
		 pan=new JTextField();
		 pan.setBounds(310,390,300,30);
		 pan.setFont(new Font("Ralewy",Font.ROMAN_BASELINE,17));
		 frame.add(pan);
		
		//city
		JLabel city=new JLabel("Aadhaar no:");
		city.setFont(new Font("Ralewy",Font.BOLD,18));
		city.setBounds(120,430,200,30);
		frame.add(city);
		
		 aadhaar=new JTextField();
		 aadhaar.setBounds(310,430,300,30);
		 aadhaar.setFont(new Font("Ralewy",Font.ROMAN_BASELINE,17));
		 frame.add(aadhaar);
		
		//state
		JLabel state=new JLabel("Senior Citizen:");
		state.setFont(new Font("Ralewy",Font.BOLD,18));
		state.setBounds(120,470,250,30);
		frame.add(state);
		
		scity=new JRadioButton("YES");
		scity.setBounds(340,470,100,30);
		scity.setBackground(Color.WHITE);
		frame.add(scity);
		
		notcity=new JRadioButton("NO");
		notcity.setBounds(440,470,100,30);
		notcity.setBackground(Color.WHITE);
		frame.add(notcity);
		
		 
		//pin code
		JLabel pinCode=new JLabel("Existing Account:");
		pinCode.setFont(new Font("Ralewy",Font.BOLD,18));
		pinCode.setBounds(120,510,250,30);
		frame.add(pinCode);
		
		exist=new JRadioButton("YES");
		exist.setBounds(340,510,100,30);
		exist.setBackground(Color.WHITE);
		frame.add(exist);
		
		notexist=new JRadioButton("NO");
		notexist.setBounds(440,510,100,30);
		notexist.setBackground(Color.WHITE);
		frame.add(notexist);
//		
		
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
		String sreligion=(String)religion.getSelectedItem();
		String sincome=(String)income.getSelectedItem();
		String seducation=(String)education.getSelectedItem();
		String citizen=null;
		if(scity.isSelected()) {
			citizen="Yes";
		}else {
			citizen="No";
		}
		String sadhar=aadhaar.getText();
		String span=pan.getText();
		String existing=null;
		if(exist.isSelected()) {
			existing="Yes";	
		}else {
			existing="No";
		}
		String scategory=(String)category.getSelectedItem();
		String soccupation=(String)occupation.getSelectedItem();
		
		
		try {
			
				Conn c=new Conn();
				String Query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+sadhar+"','"+citizen+"','"+existing+"')";
				c.s.executeUpdate(Query);
				
				//signupthree object
				frame.setVisible(false);
				new SignUpThree(formno).setVisible(true);
			
		}                                                                                                                                                   
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
















