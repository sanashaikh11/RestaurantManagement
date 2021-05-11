package presentation;
import business.CProgram;
import javax.swing.*;
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

public class ProgramDB2 extends JFrame {
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtpos;
	private JTextField txtphn;
	//private JTextField txtpos;
	private DBAccess1 db=null;
	
	
	public void showProgram(CProgram program) {
		txtId.setText(String.valueOf(program.getpID()));
		txtName.setText(program.getpName());
		txtpos.setText(program.getpPos());
		txtphn.setText(""+program.getpPhn());
	}
	public ProgramDB2() {
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
		lblID.setBounds(88, 51, 46, 28);
		lblID.setFont(new Font("Calibri", Font.PLAIN, 16));
		getContentPane().add(lblID);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(88, 90, 60, 19);
		lblName.setFont(new Font("Calibri", Font.PLAIN, 16));
		getContentPane().add(lblName);
		
		JLabel lblexp = new JLabel("Position:");
		lblexp.setBounds(88, 120, 89, 30);
		lblexp.setFont(new Font("Calibri", Font.PLAIN, 16));
		getContentPane().add(lblexp);
		
		JLabel lblphn = new JLabel("Phone:");
		lblphn.setBounds(88, 161, 89, 19);
		lblphn.setFont(new Font("Calibri", Font.PLAIN, 16));
		getContentPane().add(lblphn);
		
		
		
		txtId = new JTextField();
		txtId.setBounds(187, 53, 131, 19);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(187, 87, 131, 19);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtpos = new JTextField();
		txtpos.setBounds(187, 123, 131, 19);
		getContentPane().add(txtpos);
		txtpos.setColumns(10);
		
		txtphn = new JTextField();
		txtphn.setBounds(187, 158, 131, 19);
		getContentPane().add(txtphn);
		txtphn.setColumns(10);
		
		
		
		JButton btnFirst = new JButton("First");
		btnFirst.setBounds(28, 226, 89, 21);
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CProgram program=db.getFirst();
					if(program!=null)
						showProgram(program);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					showException(e1);
				}
			}
		});
		btnFirst.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(btnFirst);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(120, 226, 89, 21);
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CProgram program=db.getPrevious();
					if(program!=null)
						showProgram(program);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					showException(e1);
				}
			}
		});
		btnPrevious.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(btnPrevious);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(212, 226, 89, 21);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CProgram program=db.getNext();
					if(program!=null)
						showProgram(program);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					showException(e1);
				}
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(btnNext);
		
		JButton btnLast = new JButton("Last");
		btnLast.setBounds(302, 226, 89, 21);
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CProgram program=db.getLast();
					if(program!=null)
						showProgram(program);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					showException(e1);
				}
			}
		});
		btnLast.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(btnLast);

		
		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(120, 290, 89, 21);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					try{
						db.deleteProgram(txtId.getText());
						JOptionPane.showMessageDialog(null,"Deleted successfully");
					}
					catch(SQLException e1) {
						JOptionPane.showMessageDialog(null,"Deleted Unsuccessfully");	
					}
				}});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Interview");
		btnUpdate.setBounds(212, 290, 89, 21);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result= "Interview Appointment sent successfully";
				//CProgram program = new CProgram(txtId.getText(), txtName.getText() , Integer.parseInt(txtpos.getText()), Integer.parseInt(txtphn.getText()));
				JOptionPane.showMessageDialog(null,result , "", JOptionPane.INFORMATION_MESSAGE);
				
				}});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(btnUpdate);
		
		try {
			db=new DBAccess1();
			CProgram program=db.getFirst();
			if(program!=null)
				showProgram(program);
		}
		catch(ClassNotFoundException | SQLException sqle) {
			showException(sqle);
			System.exit(1);
		}
	}
	private void showException(Exception e) {
		JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	}
	public static void main(String args[]) {
		ProgramDB2 p=new ProgramDB2();
		p.setVisible(true);
		p.setSize(400,400);
	}
}