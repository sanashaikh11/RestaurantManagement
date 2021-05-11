package presentation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import business.Test;
//import data.DAOFactory;
import data.DAOFactory2;
import data.TestDAO;
import java.awt.Color;
import java.awt.Font;


public class ReviewPanel extends JPanel{
	private JLabel lblCustomerName,lblEmail,lblservice,lblFeedback,lblslider,lblempty1,lblempty2;
	private JTextField txtCustomerName,txtEmail;
	private JRadioButton GRadioButton, ARadioButton,
    ERadioButton;
	String review ;
	JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 5, 3);  
	private JButton butSave;
	private TestDAO tDao = DAOFactory2.getTestDAO();
	private ButtonGroup bgroup = new ButtonGroup();
	 JTextArea textArea = new JTextArea(20, 20);  
     JScrollPane scrollableTextArea = new JScrollPane(textArea);
	


	private void initialize() {
		lblCustomerName = new JLabel();
		lblCustomerName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCustomerName.setBounds(72, -2, 109, 33);
		lblCustomerName.setText("Customer Name");
		lblEmail = new JLabel();
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblEmail.setBounds(72, 31, 109, 33);
		lblEmail.setText("Email(optional)");
		
		lblservice= new JLabel("Overall Service");
		lblservice.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblservice.setBounds(72, 64, 109, 33);
		GRadioButton = new JRadioButton("Good");
		GRadioButton.setBackground(new Color(240, 255, 255));
		GRadioButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		GRadioButton.setBounds(225, 67, 119, 27);
		ERadioButton = new JRadioButton("Excellent");
		ERadioButton.setBackground(new Color(240, 255, 255));
		ERadioButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		ERadioButton.setBounds(225, 100, 119, 27);
		ARadioButton = new JRadioButton("Avarage");
		ARadioButton.setBackground(new Color(240, 255, 255));
		ARadioButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		ARadioButton.setBounds(225, 133, 119, 27);
		
		lblFeedback = new JLabel("Feedback");
		lblFeedback.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblFeedback.setBounds(72, 196, 109, 33);
		lblempty1 = new JLabel("");
		lblempty1.setBounds(0, 100, 225, 33);
		lblempty2 = new JLabel("");
		lblempty2.setBounds(0, 133, 225, 33);
		lblslider = new JLabel("Rating");
		lblslider.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblslider.setBounds(72, 166, 109, 33);
		slider.setBackground(new Color(240, 255, 255));
		slider.setFont(new Font("Calibri", Font.PLAIN, 16));
		slider.setBounds(225, 166, 174, 33);
		
		slider.setMinorTickSpacing(0);  
		slider.setMajorTickSpacing(1);  
		slider.setPaintLabels(true);
		slider.setPaintTrack(true);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setBounds(225, 1, 119, 27);
		txtEmail = new JTextField();
		txtEmail.setBounds(225, 34, 119, 27);
		bgroup.add(ARadioButton);
		bgroup.add(GRadioButton);
		bgroup.add(ERadioButton);

		butSave = new JButton("Submit");
		butSave.setFont(new Font("Calibri", Font.PLAIN, 16));
		butSave.setBounds(98, 256, 160, 33);
		setLayout(null);
		this.add(lblCustomerName);
		this.add(txtCustomerName);
		this.add(lblEmail);
		this.add(txtEmail);
		this.add(lblservice);
		this.add(GRadioButton);
		this.add(lblempty1);
		this.add(ERadioButton);
		this.add(lblempty2);
		this.add(ARadioButton);
		this.add(lblslider);
		this.add(slider);
		this.add(lblFeedback);
		scrollableTextArea.setBounds(225, 204, 182, 45);
		this.add(scrollableTextArea);
		this.add(butSave);
	
	}
	public ReviewPanel() {
		setBackground(new Color(240, 255, 255));
		this.initialize();
		butSave.addActionListener(new SaveButtonHandler());
        
	}

	private class SaveButtonHandler implements ActionListener{
		//private static final String Good = null;

		public void actionPerformed(ActionEvent e) {
			if (!isValidData())
				return;
			String testName = txtCustomerName.getText();
			String email = txtEmail.getText();
			String feedback=textArea.getText();
		//	int sli1 = slider.getValue();
		//String sli=String.valueOf(sli1);
		
			if (ERadioButton.isSelected()) {
				  review = "Excelent";
				}
				else if (GRadioButton.isSelected()) {
				  review = "GOOD";
				}
				else if (ARadioButton.isSelected()) {
					  review = "Average";
					}
				else {
				  review = "Unknow";
				}

			
			String rev = review;
			//public String a= Good;
			//double scoreObtained = Double.parseDouble(txtScoreObtained.getText());
			//double maxScore = Double.parseDouble(txtMaxScore.getText());
			if (tDao.addTest(new Test(testName,email,rev,feedback))) {
				String result = "Test: " + testName ;
				String email1= "Email " + email;
				String rev1= "rev " + rev;
				JOptionPane.showMessageDialog(null, result, "Thanks for the review!", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Not Saved!", "Save Test", JOptionPane.WARNING_MESSAGE);
			}
			 
			
		}

	}
	 public boolean isValidData() {
	 		if(!Validator.isPresent(txtCustomerName,"username")) return false;
	 		//if(!Validator.isPresent(scrollableTextArea,"Feedback")) return false;
	 		//if(!Validator.isInteger(txtMaxScore,"Max Score")) return false;
	 		return true;
	 	}

}