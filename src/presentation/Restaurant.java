package presentation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextArea;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Restaurant extends JFrame {
	public Restaurant() {
		this.setSize(500, 450);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(95, 158, 160));
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(43, 51, 48, 14);
		getContentPane().add(label);
		
		JButton btnlogin = new JButton("Click here to Login");
		btnlogin.setBounds(143, 163, 184, 43);
		btnlogin.addActionListener(new LoginHandler());
		getContentPane().add(btnlogin);
	
		
		
		JLabel lblwelcome = new JLabel("Welcome to Restaurant Management");
		lblwelcome.setForeground(new Color(0, 0, 0));
		lblwelcome.setFont(new Font("Calibri", Font.BOLD, 22));
		lblwelcome.setBackground(new Color(255, 255, 255));
		lblwelcome.setBounds(65, 98, 373, 43);
		getContentPane().add(lblwelcome);
		
		JLabel lblBy = new JLabel("BY:");
		lblBy.setFont(new Font("Calibri", Font.BOLD, 18));
		lblBy.setBounds(224, 299, 48, 23);
		getContentPane().add(lblBy);
		
		JLabel lblSanaShaikhn = new JLabel("Sana Shaikh(N01350800)");
		lblSanaShaikhn.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblSanaShaikhn.setBounds(224, 320, 214, 32);
		getContentPane().add(lblSanaShaikhn);
		
		JLabel lblCharmiBhattn = new JLabel("Charmi Bhatt(N01350347)");
		lblCharmiBhattn.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCharmiBhattn.setBounds(224, 363, 194, 23);
		getContentPane().add(lblCharmiBhattn);
		
		JButton btnapply = new JButton("Click here to Apply");
		btnapply.setBounds(143, 226, 184, 43);
		btnapply.addActionListener(new applyHandler());
		getContentPane().add(btnapply);
	}
	private class LoginHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			MainClass p=new MainClass();
			p.setVisible(true);
			p.setSize(500,450);

			System.out.println("logout ");
			//me.setVisible(true);
			//prentFrame.add(me);
		}
	}
	private class applyHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			ProgramsDB p=new ProgramsDB();
			p.setVisible(true);
			p.setSize(500,450);

			System.out.println("logout ");
			//me.setVisible(true);
			//prentFrame.add(me);
		}
	}
}
