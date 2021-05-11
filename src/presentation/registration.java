package presentation;
 import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import business.Test;
import data.DAOFactory1;
import data.TestDAO;
import java.awt.Color;
import java.awt.Font;
//import data.DAOFactory;


public class registration extends JPanel{
	private String check;
 private JLabel lblCustomerName,lblempty,lblDate;
 private JTextField txtCustomerName,txtDate;
 private JCheckBox T1check, T2check, T3check,T4check;
 private JButton butSave;
 private TestDAO tDao = DAOFactory1.getTestDAO();
 
 
 private void initialize() {
	 lblCustomerName = new JLabel();
	 lblCustomerName.setFont(new Font("Calibri", Font.PLAIN, 16));
	 lblCustomerName.setBounds(73, 0, 135, 50);
	 lblCustomerName.setText("Customer Name");
	 txtCustomerName = new JTextField();
	 txtCustomerName.setBounds(225, 9, 130, 32);
	 lblDate = new JLabel();
	 lblDate.setFont(new Font("Calibri", Font.PLAIN, 16));
	 lblDate.setBounds(73, 41, 80, 50);
	 lblDate.setText("Date");
	 txtDate = new JTextField();
	 txtDate.setBounds(225, 50, 130, 32);
	 T1check = new JCheckBox("Table for 2 ");
	 T1check.setFont(new Font("Calibri", Font.PLAIN, 16));
	 T1check.setBackground(new Color(240, 255, 255));
	 T1check.setBounds(73, 108, 119, 34);
	 T2check = new JCheckBox("Table for 5 ");
	 T2check.setFont(new Font("Calibri", Font.PLAIN, 16));
	 T2check.setBackground(new Color(240, 255, 255));
	 T2check.setBounds(228, 109, 103, 32);
	 T3check = new JCheckBox("Table for 10");
	 T3check.setFont(new Font("Calibri", Font.PLAIN, 16));
	 T3check.setBackground(new Color(240, 255, 255));
	 T3check.setBounds(79, 162, 113, 32);
	 T4check = new JCheckBox("Table for 10");
	 T4check.setFont(new Font("Calibri", Font.PLAIN, 16));
	 T4check.setBackground(new Color(240, 255, 255));
	 T4check.setBounds(228, 162, 103, 32);
	 lblempty= new JLabel ("");
	 lblempty.setBounds(0, 200, 225, 50);
	 butSave = new JButton("Save");
	 butSave.setBackground(new Color(220, 220, 220));
	 butSave.setFont(new Font("Calibri", Font.PLAIN, 16));
	 butSave.setBounds(79, 226, 158, 50);
	 setLayout(null);
	 this.add(lblCustomerName);
	 this.add(txtCustomerName);
	 this.add(lblDate);
	 this.add(txtDate);
	 this.add(T1check);
		this.add(T2check);
		this.add(T3check);
		this.add(T4check);
	 this.add(lblempty);
	 this.add(butSave);
	// this.add(butFind);
	 
 
 }
     public registration() {
     	setBackground(new Color(240, 255, 255));
    	 this.initialize();
    	 butSave.addActionListener(new SaveButtonHandler());
    	// butFind.addActionListener(new FindButtonHandler());
    	 
     }
     
    private class SaveButtonHandler implements ActionListener{
    				//private static final String Good = null;

    				public void actionPerformed(ActionEvent e) {
    					if (!isValidData())
    						return;
    					String testName = txtCustomerName.getText();
    					String email = txtDate.getText();
    					//String a=T1check.getText();
    				//	String feedback=textArea.getText();
    				//	int sli1 = slider.getValue();
    				//String sli=String.valueOf(sli1);
    				
    					if (T1check.isSelected()==true) {
    						  check = "Table for 2";
    						}
    						else if (T2check.isSelected()==true) {
    						  check = "Table for 5";
    						}
    						else if (T3check.isSelected()==true) {
    							  check = "Table for 8";
    							}
    						else {
    						  check = "A banquent";
    						}

    					
    					String rev = check;
    					//public String a= Good;
    					//double scoreObtained = Double.parseDouble(txtScoreObtained.getText());
    					//double maxScore = Double.parseDouble(txtMaxScore.getText());
    					if (tDao.addTest(new Test(testName,email,rev))) {
    						String result = "Test: " + testName ;
    						String email1= "Email " + email;
    						String rev1= "rev " + rev;
    						//JOptionPane.showMessageDialog(null, result, "Save Test", JOptionPane.INFORMATION_MESSAGE);
    					} else {
    						JOptionPane.showMessageDialog(null, "Not Saved!", "Save Test", JOptionPane.WARNING_MESSAGE);
    					}
    					 
    					
    			
    		
    		 System.out.println("t1 : "+T1check.isSelected()); 
    		 System.out.println("t1 : "+T2check.isSelected());
    		 System.out.println("t1 : "+T3check.isSelected());
    		 System.out.println("t1 : "+T4check.isSelected());
    		 JOptionPane.showMessageDialog(null, "succsessfully registered", "Thank you", JOptionPane.INFORMATION_MESSAGE);
    	 }
    	 
     }
     
     public boolean isValidData() {
    	 	
    	
    	 	
	 		if(!Validator.isPresent(txtCustomerName,"Name ")) return false;
	 		if(!Validator.isPresent(txtDate,"Name ")) return false;
	 	//	if(!Validator.isDouble(txtCustomerName," ")) return false;
	 		//if(!Validator.isInteger(txtMaxScore,"Max Score")) return false;
	 		
	 		if(T1check.isSelected()==false && T2check.isSelected()==false && T3check.isSelected()==false && T4check.isSelected()==false ) {
				JOptionPane.showMessageDialog(this, "Message", "Choose any one", JOptionPane.ERROR_MESSAGE); 
	 			return false;
	    	}
	 		return true;
	 	}
     
    
}