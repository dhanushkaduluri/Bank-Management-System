package bank_management_system;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener{

	String pinnumber;
	JButton back;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new BalanceEnquiry("");
	}

	/**
	 * Create the application.
	 */
	public BalanceEnquiry(String pinnumber) {
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
		
		back=new JButton("BACK");
		back.setFont(new Font("calbri",Font.BOLD,17));
		back.setBounds(380,520,100,30);
		back.addActionListener(this);
		image.add(back);
		
		Conn c=new Conn();
		int balance=0;
		try {
			ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance+=Integer.parseInt(rs.getString("amount"));
				}else {
					balance-=Integer.parseInt(rs.getString("amount"));
				}
			}
		}catch(Exception ae) {
			System.out.println(ae);
		}
		JLabel display=new JLabel("Balance Amount: Rs."+balance);
		display.setForeground(Color.RED);
		display.setFont(new Font("calbri",Font.BOLD,20));
		display.setBounds(210,350,300,40);
		image.add(display);
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		
	}

}
