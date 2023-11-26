package bank_management_system;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PinChange extends JFrame implements ActionListener{

	String pinnumber;
	JPasswordField nPin,renPin;
	JButton change,back;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new PinChange("");
	}

	/**
	 * Create the application.
	 */
	public PinChange(String pinnumber) {
		this.pinnumber=pinnumber;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, DO_NOTHING_ON_CLOSE);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text=new JLabel("Change Your PIN");
		text.setFont(new Font("Calbri",Font.BOLD,18));
		text.setBounds(250,300,400,35);
		text.setForeground(Color.white);
		image.add(text);
		
		JLabel newpin=new JLabel("Enter New PIN");
		newpin.setFont(new Font("Calbri",Font.BOLD,15));
		newpin.setBounds(180,410,150,35);
		newpin.setForeground(Color.white);
		image.add(newpin);
		
		JLabel newpin2=new JLabel("Re-Enter New PIN");
		newpin2.setFont(new Font("Calbri",Font.BOLD,15));
		newpin2.setBounds(180,440,150,35);
		newpin2.setForeground(Color.white);
		image.add(newpin2);
		
		nPin=new JPasswordField();
		nPin.setBounds(332,410,150,25);
		nPin.setFont(new Font("Calbri",Font.BOLD,15));
		image.add(nPin);
		
		renPin=new JPasswordField();
		renPin.setBounds(332,440,150,25);
		renPin.setFont(new Font("Calbri",Font.BOLD,15));
		image.add(renPin);
		
		back=new JButton("BACK");
		back.setBounds(180,500,100,30);
		back.setBackground(Color.white);
		back.addActionListener(this);
		image.add(back);
		
		change=new JButton("CHANGE");
		change.setBounds(300,500,100,30);
		change.setBackground(Color.white);
		change.addActionListener(this);
		image.add(change);
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==change) {
			String newPin=nPin.getText();
			String rNewPin=renPin.getText();
			if(newPin.equals(rNewPin)==false || newPin.isEmpty() || rNewPin.isEmpty() ||pinnumber.equals(newPin)) {
				JOptionPane.showMessageDialog(null, "Invalid Pin");
			}
			Conn c=new Conn();
			String query1="update bank set pin="+newPin+" where pin="+pinnumber+"";
			String query2="update login set pinnumber="+newPin+" where pinnumber="+pinnumber+"";
			String query3="update signup_three set PIN="+newPin+" where PIN="+pinnumber+"";
			System.out.println(query1);
			
			try {
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				c.s.executeUpdate(query3);
				JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
			}catch(Exception ae) {
				System.out.println(ae);
			}
		}else {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		
	}

}
