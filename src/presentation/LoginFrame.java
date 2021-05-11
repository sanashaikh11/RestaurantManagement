package presentation;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class LoginFrame extends JFrame {

	private JLabel lblUsername, lblPassword;
	private JTextField txtUsername, txtPassword;
	private JButton btnLogin;
	private MainClass parentFrame;

	public LoginFrame(MainClass parent) {
		getContentPane().setBackground(new Color(240, 248, 255));
		initialize();
		this.parentFrame = parent;
	}

	private void initialize() {
		this.setSize(500, 450);
		lblUsername = new JLabel("  Username");
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblUsername.setBounds(81, 30, 109, 64);
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPassword.setBounds(94, 138, 109, 76);
		txtUsername = new JTextField();
		txtUsername.setBounds(224, 40, 154, 40);
		txtPassword = new JTextField();
		txtPassword.setBounds(224, 154, 151, 40);
		btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBackground(new Color(192, 192, 192));
		btnLogin.setBounds(142, 254, 180, 40);
		getContentPane().setLayout(null);
		getContentPane().add(lblUsername);
		getContentPane().add(txtUsername);
		getContentPane().add(lblPassword);
		getContentPane().add(txtPassword);
		getContentPane().add(btnLogin);
		btnLogin.addActionListener(new LoginButtonHandler(this));
	}

	private class LoginButtonHandler implements ActionListener {
		private LoginFrame outer;

		public LoginButtonHandler(LoginFrame outer) {
			this.outer = outer;
		}

		public void actionPerformed(ActionEvent e) {
			// JOptionPane.showMessageDialog(null, "Login
			// Successful!","Login",JOptionPane.INFORMATION_MESSAGE);
			if ("admin".equalsIgnoreCase(txtUsername.getText())) {
				JOptionPane.showMessageDialog(null, txtUsername.getText().toUpperCase() + "  Loged in!!!","Login",JOptionPane.INFORMATION_MESSAGE);
				this.outer.parentFrame.setInternalFrame("Admin");
				
			}
			else if("staff".equalsIgnoreCase(txtUsername.getText())) {
				JOptionPane.showMessageDialog(null,"Customer Loged in!!!","Login",JOptionPane.INFORMATION_MESSAGE);
				this.outer.parentFrame.setInternalFrame("Staff");
			}
			else {
				JOptionPane.showMessageDialog(null, txtUsername.getText() + "Login UnSuccessful!","Login",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
