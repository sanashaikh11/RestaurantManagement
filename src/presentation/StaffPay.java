package presentation;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import business.Test;
import data.DAOFactory;
import data.TestDAO;
import java.awt.Color;
import java.awt.Font;


@SuppressWarnings("serial")
public class StaffPay extends JPanel{
 private JLabel lblCustomerName, lblSalary,lbljob,lblhr,lblempty;
 private JTextField txtCustomerName, txtSalary;
 private JButton butSave,butFind;
 String[] JobStrings = { "Part-Time", "Full-Time", "Contract"};
 private JSpinner hr ;
 
 private JComboBox jobList ;
 //private JTextArea txtArea;
 JTextArea txtArea = new JTextArea(40, 40);  
 JScrollPane scrollableTextArea = new JScrollPane(txtArea);
	
 private TestDAO tDAO = DAOFactory.getTestDAO();
 
 private void initialize() {
	 lblCustomerName = new JLabel();
	 lblCustomerName.setFont(new Font("Calibri", Font.PLAIN, 16));
	 lblCustomerName.setBounds(55, 0, 136, 50);
	 lblCustomerName.setText("Customer Name");
	 lblSalary = new JLabel("Salary");
	 lblSalary.setFont(new Font("Calibri", Font.PLAIN, 16));
	 lblSalary.setBounds(55, 150, 110, 50);
	 txtCustomerName = new JTextField();
	 txtCustomerName.setBounds(225, 8, 136, 35);
	 txtSalary = new JTextField();
	 txtSalary.setBounds(225, 154, 136, 42);
	// txtMaxScore = new JTextField();
	 lbljob= new JLabel("Job Type");
	 lbljob.setFont(new Font("Calibri", Font.PLAIN, 16));
	 lbljob.setBounds(55, 50, 110, 50);
	  jobList=new JComboBox(JobStrings);
	  jobList.setFont(new Font("Calibri", Font.PLAIN, 16));
	  jobList.setBounds(225, 54, 136, 42);
	 jobList.setSelectedIndex(1);
	 lblhr= new JLabel("Work Hours");
	 lblhr.setFont(new Font("Calibri", Font.PLAIN, 16));
	 lblhr.setBounds(55, 100, 88, 50);
	 hr= new JSpinner(new SpinnerNumberModel(0, 0, 100, 0.5));
	 hr.setBounds(225, 104, 136, 42);
	 /*SpinnerModel hr1 =new SpinnerNumberModel(5, //initial value  
                5, //minimum value  
                40, //maximum value  
                1);*/
	// JSpinner hr = new JSpinner(hr1); 
	 txtArea = new JTextArea();
	 txtArea.setBounds(43, 250, 374, 50);
	 lblempty= new JLabel ("");
	 butSave = new JButton("Save");
	 butSave.setFont(new Font("Calibri", Font.PLAIN, 16));
	 butSave.setBounds(79, 200, 136, 50);
	 butFind = new JButton("Find");
	 butFind.setFont(new Font("Calibri", Font.PLAIN, 16));
	 butFind.setBounds(225, 200, 136, 50);
	 setLayout(null);
	 this.add(lblCustomerName);
	 this.add(txtCustomerName);
	 this.add(lbljob);
	 this.add(jobList);
	 this.add(lblhr);
	 this.add(hr);
	 this.add(lblSalary);
	 this.add(txtSalary);
	// this.add(lblempty);
	 this.add(butSave);
	 //this.add(lblempty);
	 this.add(butFind);
	// this.add(lblempty);
	 this.add(txtArea);
	 
 
 }
     public StaffPay() {
     	setBackground(new Color(240, 255, 255));
    	 this.initialize();
    	 butSave.addActionListener(new SaveButtonHandler());
    	  butFind.addActionListener(new FindButtonHandler());
    	 
     }
     private class SaveButtonHandler implements ActionListener {
 		public void actionPerformed(ActionEvent e) {
 			String testName = txtCustomerName.getText();
 			double hour = Double.parseDouble(hr.getValue().toString());
 			double salary = Double.parseDouble(txtSalary.getText());
 			//JComboBox cb = (JComboBox)e.getSource();
 			// String prof = (String)cb.getSelectedItem();
 			if(isValidData()) {
 				Test test = new Test();
 				test.setTestName(testName);
 				test.sethour(hour);
 				test.setsalary(salary);
 				//test.setprof(prof);
 				if(tDAO.addTest(test)) {
 				
 			String result = "Employee:" + testName ;
 			JOptionPane.showMessageDialog(null, result + "Employee Record is saved", "Save Payroll", JOptionPane.INFORMATION_MESSAGE);
 				}
 				}
 		}

 	}
 	
     /*private class SaveButtonHandler implements ActionListener{
    	 public void actionPerformed(ActionEvent e) {
    			if (!isValidData())
    				return;
    			String testName = txtCustomerName.getText();
    		//	double hour = Double.parseDouble(hr.getValue().toString());
    			//String prof  = jobList.getSelectedItem().toString();
    			double salary = Double.parseDouble(txtSalary.getText());
    			if (tDao.addTest(new Test(testName,salary))) {
    				String result = "Test: " + testName + "\n Score: " + "\n Max Score: " + salary;
    				JOptionPane.showMessageDialog(null, result, "Save Test", JOptionPane.INFORMATION_MESSAGE);
    			} else {
    				JOptionPane.showMessageDialog(null, "Not Saved!", "Save Test", JOptionPane.WARNING_MESSAGE);
    			}
    		
    		 
    		 
    	 }
    	 
     }*/
    /* private class FindButtonHandler implements ActionListener {
 		public void actionPerformed(ActionEvent e) {
 			String testName = txtCustomerName.getText();
 			if (testName.isEmpty()) {
 				String txt = " ";
 				for (Test test : tDao.getTests()) {
 					txt += "\n" + test.toString();
 				}
 				txtAreaList.setText(txt);
 			} else {
 				Test test = tDao.getTest(testName);
 				if (test == null) {
 					JOptionPane.showMessageDialog(null, "Test Not Found", "Find Test", JOptionPane.ERROR_MESSAGE);
 				} else {
 					txtSalary.setText("" + test.getsalary());
 					//txtMaxScore.setText("" + test.getMaxScore());
 				}
 			}
 		}
 	}*/private class FindButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String targetName = txtCustomerName.getText();
			if(targetName.length()>0) {
				business.Test test = tDAO.getTest(targetName);
				if(test !=null) {
					txtCustomerName.setText(test.getTestName());
					//JComboBox cb = (JComboBox)e.getSource();
		 			// String prof = (String)cb.getSelectedItem();
		 			// jobList.updateLabel()
		 			//updateLabel(prof);
					hr.setValue(test.gethour()); 
					txtSalary.setText("" +test.getsalary());
				}else
					JOptionPane.showMessageDialog(null, "Employee Record"+ txtCustomerName.getText()  + "' does not exist");
			}else {
				txtArea.setText("");
				java.util.ArrayList<business.Test> tests = tDAO.getTests();
				for(business.Test t:tests) {
					txtArea.append("Emp:"+t.getTestName()+ " Hour:" + t.gethour()+ " Salary:" + t.getsalary() + "\n");
				}
			}
		}
	}
     
     public boolean isValidData() {
	 		if(!Validator.isPresent(txtCustomerName,"Name ")) return false;
	 		if(!Validator.isDouble(txtSalary,"salary ")) return false;
	 		//if(!Validator.isInteger(txtMaxScore,"Max Score")) return false;
	 		return true;
	 	}
     
    
}
