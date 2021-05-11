package presentation;
import business.CProgram;
import javax.swing.*;

import data.DBAccess;
import data.DBAccess1;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ProgramsDB extends JFrame {
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtpos;
	private JTextField txtphn;
	
	private DBAccess1 db=null;
	
	
	public void showProgram(CProgram program) {
		txtId.setText(String.valueOf(program.getpID()));
		txtName.setText(program.getpName());
		txtpos.setText(program.getpPos());
		txtphn.setText(""+program.getpPhn());
	}
	public ProgramsDB() {
		getContentPane().setBackground(new Color(240, 255, 255));
		setTitle("DB");
		addWindowListener(new WindowAdapter() {
			public void windowsClosing(WindowEvent e) {
				try {
					db.disconnect();
					System.exit(0);
				}
				catch(SQLException e1) {
					showException(e1);
					System.exit(1);
				}
			}
		});
		getContentPane().setLayout(null);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(102, 45, 46, 13);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblID);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(102, 90, 46, 13);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblName);
		
		JLabel lblpos = new JLabel("Position:");
		lblpos.setBounds(102, 135, 75, 13);
		lblpos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblpos);
		
		JLabel lblphn = new JLabel("Phone:");
		lblphn.setBounds(102, 178, 75, 13);
		lblphn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblphn);
		
	
		
		txtId = new JTextField();
		txtId.setBounds(187, 45, 131, 19);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(187, 88, 131, 19);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtpos = new JTextField();
		txtpos.setBounds(187, 133, 131, 19);
		getContentPane().add(txtpos);
		txtpos.setColumns(10);
		
		txtphn = new JTextField();
		txtphn.setBounds(187, 176, 131, 19);
		getContentPane().add(txtphn);
		txtphn.setColumns(10);
		
		
		try {
			db = new DBAccess1();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

		JButton btnInsert = new JButton("Apply");
		btnInsert.setBounds(28, 290, 89, 21);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					System.out.println("id : "+txtId.getText().toString());
					System.out.println("name : "+txtName.getText());
					System.out.println("Phone : "+txtphn.getText());
					System.out.println("pos : "+txtpos.getText());
					CProgram program = new CProgram(Integer.parseInt(txtId.getText().toString()), txtName.getText() , Integer.parseInt(txtphn.getText().toString()),txtpos.getText().toString());
					
					try{
						db.addProgram(program);
						JOptionPane.showMessageDialog(null,"Applied successfully");
					}
					catch(SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null,"Applied Unsuccessfully","please insert a value",JOptionPane.ERROR_MESSAGE);
					
					}
				}});
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(btnInsert);
		
		
	
	}
	private void showException(Exception e) {
		JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	}
	public static void main(String args[]) {
		ProgramsDB p=new ProgramsDB();
		p.setVisible(true);
		p.setSize(400,400);
	}
}