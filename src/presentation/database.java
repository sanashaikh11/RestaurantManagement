package presentation;


import java.awt.Container;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import javax.swing.BoxLayout;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
//import net.miginfocom.swing.MigLayout;



public class database extends JFrame implements ActionListener {
	
	



	JLabel lblsrno,lblfood,lblspecial,lblcost,lblF,lblL,lblA,lblS,

	lblFVal,lblLVal,lblAVal,lblSVal;

	JTextField txtsrno,txtfood,txtspecial,txtcost;
	JButton btnAdd,btnUpdate,btnDelete,btnPrev,btnNext;
	ResultSet rs;
	protected Statement stm=null;


	public database() {
	
	/**
	 * @wbp.parser.entryPoint
	 */
	//public void createUI()

	{
		JFrame frame = new JFrame("Menu Card");
		frame.getContentPane().setBackground(new Color(240, 255, 255));
		JPanel pnlInput = new JPanel();
		pnlInput.setBackground(new Color(240, 255, 255));
												pnlInput.setLayout(null);
										
												lblsrno = new JLabel("  SR.NO :");
												lblsrno.setBounds(57, 2, 72, 20);
												lblsrno.setBackground(new Color(240, 255, 255));
												lblsrno.setFont(new Font("Calibri", Font.PLAIN, 16));
													pnlInput.add(lblsrno);
								
										txtsrno = new JTextField(15);
										txtsrno.setBounds(149, 1, 159, 18);
												pnlInput.add(txtsrno);



		JPanel pnlButton = new JPanel();
		pnlButton.setBackground(new Color(240, 255, 255));
						
						
						
								btnDelete = new JButton("Delete");
								btnDelete.setBounds(212, 37, 88, 29);
								btnDelete.setFont(new Font("Calibri", Font.PLAIN, 16));
								btnDelete.setBackground(new Color(220, 220, 220));
								
										btnDelete.addActionListener(this);
										
												btnUpdate = new JButton("Update");
												btnUpdate.setBounds(113, 37, 88, 29);
												btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 16));
												btnUpdate.setBackground(new Color(220, 220, 220));
												
														btnUpdate.addActionListener(this);
														


		btnAdd = new JButton("Add");
		btnAdd.setBounds(15, 37, 88, 29);
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnAdd.setBackground(new Color(220, 220, 220));
		
				btnAdd.addActionListener(this);
				pnlButton.setLayout(null);
				pnlButton.add(btnAdd);
														pnlButton.add(btnUpdate);
										pnlButton.add(btnDelete);



		JPanel pnlNavigate = new JPanel();
		pnlNavigate.setBackground(new Color(240, 255, 255));
		
				btnPrev = new JButton(" Previous ");
				btnPrev.setBounds(35, 26, 104, 29);
				btnPrev.setFont(new Font("Calibri", Font.PLAIN, 16));
				btnPrev.setBackground(new Color(220, 220, 220));
				
						btnPrev.setActionCommand("Prev");
						
								btnPrev.addActionListener(this);
								pnlNavigate.setLayout(null);
								pnlNavigate.add(btnPrev);
		JPanel pnlNavAns = new JPanel();
		pnlNavAns.setBackground(new Color(240, 255, 255));


		Container cn = frame.getContentPane();
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));



		frame.getContentPane().add(pnlInput);
						
						
						
								lblfood = new JLabel("  Food Item");
								lblfood.setBounds(57, 25, 72, 20);
								lblfood.setBackground(new Color(240, 255, 255));
								lblfood.setFont(new Font("Calibri", Font.PLAIN, 16));
										pnlInput.add(lblfood);
												
														txtfood = new JTextField();
														txtfood.setBounds(149, 23, 159, 20);
																pnlInput.add(txtfood);
										
										
										
												lblspecial = new JLabel("  Specials : ");
												lblspecial.setBounds(57, 50, 73, 20);
												lblspecial.setBackground(new Color(240, 255, 255));
												lblspecial.setFont(new Font("Calibri", Font.PLAIN, 16));
														pnlInput.add(lblspecial);
														
																txtspecial = new JTextField();
																txtspecial.setBounds(149, 48, 159, 20);
																		pnlInput.add(txtspecial);
																		
																		
																		
																				lblcost = new JLabel("  Price: ");
																				lblcost.setBounds(57, 75, 48, 20);
																				lblcost.setBackground(new Color(240, 255, 255));
																				lblcost.setFont(new Font("Calibri", Font.PLAIN, 16));
																						pnlInput.add(lblcost);
																						
																								txtcost = new JTextField();
																								txtcost.setBounds(149, 73, 159, 20);
																										pnlInput.add(txtcost);

		frame.getContentPane().add(pnlButton);

		frame.getContentPane().add(pnlNavAns);
		GridBagLayout gbl_pnlNavAns = new GridBagLayout();
		gbl_pnlNavAns.columnWidths = new int[]{70, 99, 141, 0};
		gbl_pnlNavAns.rowHeights = new int[]{20, 26, 20, 20, 0};
		gbl_pnlNavAns.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlNavAns.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlNavAns.setLayout(gbl_pnlNavAns);
		lblF = new JLabel("   SR.NO : ");
		lblF.setFont(new Font("Calibri", Font.PLAIN, 16));
		GridBagConstraints gbc_lblF = new GridBagConstraints();
		gbc_lblF.anchor = GridBagConstraints.NORTH;
		gbc_lblF.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblF.insets = new Insets(0, 0, 5, 5);
		gbc_lblF.gridx = 1;
		gbc_lblF.gridy = 0;
		pnlNavAns.add(lblF, gbc_lblF);
		lblFVal = new JLabel("Val");
		lblFVal.setFont(new Font("Calibri", Font.PLAIN, 16));
		GridBagConstraints gbc_lblFVal = new GridBagConstraints();
		gbc_lblFVal.anchor = GridBagConstraints.NORTH;
		gbc_lblFVal.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFVal.insets = new Insets(0, 0, 5, 0);
		gbc_lblFVal.gridx = 2;
		gbc_lblFVal.gridy = 0;
		pnlNavAns.add(lblFVal, gbc_lblFVal);
		lblL = new JLabel("  FOOD : ");
		lblL.setFont(new Font("Calibri", Font.PLAIN, 16));
		GridBagConstraints gbc_lblL = new GridBagConstraints();
		gbc_lblL.anchor = GridBagConstraints.SOUTH;
		gbc_lblL.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblL.insets = new Insets(0, 0, 5, 5);
		gbc_lblL.gridx = 1;
		gbc_lblL.gridy = 1;
		pnlNavAns.add(lblL, gbc_lblL);
		lblLVal = new JLabel("Val");
		lblLVal.setFont(new Font("Calibri", Font.PLAIN, 16));
		GridBagConstraints gbc_lblLVal = new GridBagConstraints();
		gbc_lblLVal.anchor = GridBagConstraints.NORTH;
		gbc_lblLVal.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLVal.insets = new Insets(0, 0, 5, 0);
		gbc_lblLVal.gridx = 2;
		gbc_lblLVal.gridy = 1;
		pnlNavAns.add(lblLVal, gbc_lblLVal);
		lblA = new JLabel(" SPECIAL : ");
		lblA.setFont(new Font("Calibri", Font.PLAIN, 16));
		GridBagConstraints gbc_lblA = new GridBagConstraints();
		gbc_lblA.anchor = GridBagConstraints.NORTH;
		gbc_lblA.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblA.insets = new Insets(0, 0, 5, 5);
		gbc_lblA.gridx = 1;
		gbc_lblA.gridy = 2;
		pnlNavAns.add(lblA, gbc_lblA);
		lblAVal = new JLabel("Val");
		lblAVal.setFont(new Font("Calibri", Font.PLAIN, 16));
		GridBagConstraints gbc_lblAVal = new GridBagConstraints();
		gbc_lblAVal.anchor = GridBagConstraints.NORTH;
		gbc_lblAVal.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAVal.insets = new Insets(0, 0, 5, 0);
		gbc_lblAVal.gridx = 2;
		gbc_lblAVal.gridy = 2;
		pnlNavAns.add(lblAVal, gbc_lblAVal);
		
		
		
				lblS = new JLabel("  PRICE : ");
				lblS.setFont(new Font("Calibri", Font.PLAIN, 16));
				GridBagConstraints gbc_lblS = new GridBagConstraints();
				gbc_lblS.anchor = GridBagConstraints.NORTH;
				gbc_lblS.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblS.insets = new Insets(0, 0, 0, 5);
				gbc_lblS.gridx = 1;
				gbc_lblS.gridy = 3;
				pnlNavAns.add(lblS, gbc_lblS);
		
				lblSVal = new JLabel("Val");
				lblSVal.setFont(new Font("Calibri", Font.PLAIN, 16));
				GridBagConstraints gbc_lblSVal = new GridBagConstraints();
				gbc_lblSVal.anchor = GridBagConstraints.NORTH;
				gbc_lblSVal.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblSVal.gridx = 2;
				gbc_lblSVal.gridy = 3;
				pnlNavAns.add(lblSVal, gbc_lblSVal);

		frame.getContentPane().add(pnlNavigate);
		btnNext = new JButton(" Next");
		btnNext.setBounds(149, 26, 104, 29);
		btnNext.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnNext.setBackground(new Color(220, 220, 220));
		btnNext.setActionCommand("Next");
		btnNext.addActionListener(this);
		pnlNavigate.add(btnNext);



		frame.pack();

		frame.setVisible(true);
		frame.setSize(518, 423);
		
	}
	}
	public void refresh() throws SQLException{
		String sql = "Select * From menu";
		//Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@CALVIN.HUMBER.CA:1521:GROK","N01350800","oracle");


		
		stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rs = stm.executeQuery(sql);
		rs.first();
	}

	@Override

	public void actionPerformed(ActionEvent evt) {



		String action = evt.getActionCommand();

		if(action.equals("Add"))

		{

			addOperation();

		}else if(action.equals("Update"))

		{

			updateOperation();

		}else if(action.equals("Delete"))

		{

			deleteOperation();

		}else if(action.equals("Prev"))
		{

			preNavigation();

		}else if(action.equals("Next"))

		{

			nextNavigation();

		}

	}


	private void addOperation()

	{

		try

		{
			//Load Jdbc Odbc Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@CALVIN.HUMBER.CA:1521:GROK","N01350800","oracle");
			String sql = "INSERT INTO MENU (SR_NO,HELLO_BELLY,WHT_IS_FOR_TODAY,COST) " +

                    "Values ('"+txtsrno.getText()+"'," +

                            "'"+txtfood.getText()+"'," +

                            "'"+txtspecial.getText()+"'," +

                            "'"+txtcost.getText()+"')";
			Statement st = con.createStatement();

			st.execute(sql);



			JOptionPane.showMessageDialog(null, "Record Added Succesfully.","Record Added",

					JOptionPane.INFORMATION_MESSAGE);

			clearControls();
			this.refresh();
			

		}catch(Exception e)

		{

			JOptionPane.showMessageDialog(null, "Sr.no Already Exist","Error",

					JOptionPane.ERROR_MESSAGE);

		}

	}

	private void updateOperation()

	{

		try

		{

			//Load Jdbc Odbc Driver

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@CALVIN.HUMBER.CA:1521:GROK","N01350800","oracle");



			String sql = "Update MENU " +

                            "SET HELLO_BELLY = '"+txtfood.getText()+"'," +

                            "WHT_IS_FOR_TODAY = '"+txtspecial.getText()+"'," +

                            "COST = '"+txtcost.getText()+"'" +

                            "Where SR_NO = '"+txtsrno.getText()+"'";



			JOptionPane.showMessageDialog(null, sql,"Record Updated",

					JOptionPane.INFORMATION_MESSAGE);

			Statement st = con.createStatement();

			st.execute(sql);



			JOptionPane.showMessageDialog(null, "Record Update Succesfully.",

					"Record Updated",JOptionPane.INFORMATION_MESSAGE);

			clearControls();
			this.refresh();

		}catch(Exception e)

		{

			JOptionPane.showMessageDialog(null, "Please enter a value","Error",

					JOptionPane.ERROR_MESSAGE);

		}

	}

	private void deleteOperation()

	{

		int ans = JOptionPane.showConfirmDialog(null,

				"Are you sure to delete the Record ?", "Delete Record",

				JOptionPane.YES_NO_OPTION);
		if(ans == JOptionPane.YES_OPTION)

		{

			try{

				//Load Jdbc Odbc Driver

				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@CALVIN.HUMBER.CA:1521:GROK","N01350800","oracle");



				String sql = "Delete FROM MENU where SR_NO = '"+txtsrno.getText()+"'";



				Statement st = con.createStatement();

				st.execute(sql);
				this.refresh();

			}catch(Exception e)
			{

				JOptionPane.showMessageDialog(null, "Please enter a value you would like to delete","Error",

						JOptionPane.ERROR_MESSAGE);

			}

			JOptionPane.showMessageDialog(null, "Record Deleted","Success",

					JOptionPane.INFORMATION_MESSAGE);

		}

		else

		{

			JOptionPane.showMessageDialog(null, "Operation Canceled","Cancel",

					JOptionPane.INFORMATION_MESSAGE);

		}

	}

	private void preNavigation()

	{

		try{
			if(rs == null)
			{

				//Load Jdbc Odbc Driver

				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@CALVIN.HUMBER.CA:1521:GROK","N01350800","oracle");


				String sql = "SELECT * FROM MENU";



				Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,

						ResultSet.CONCUR_UPDATABLE);

				rs = st.executeQuery(sql);

			}

			if(rs.previous())

			{

				populateValue();

			}

		}catch(Exception e)

		{

			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",

					JOptionPane.ERROR_MESSAGE);

		}

	}

	private void nextNavigation()

	{

		try{

			if(rs == null)

			{

				//Load Jdbc Odbc Driver

				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@CALVIN.HUMBER.CA:1521:GROK","N01350800","oracle");



				String sql = "SELECT * FROM MENU";



				Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,

						ResultSet.CONCUR_UPDATABLE);

				rs = st.executeQuery(sql);

			}

			if(rs.next())

			{

				populateValue();

			}

		}catch(Exception e)

		{

			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",

					JOptionPane.ERROR_MESSAGE);

		}

	}

	private void populateValue() throws Exception

	{

		String srno = rs.getString("SR_NO");

		String food = rs.getString("HELLO_BELLY");

		String special = rs.getString("WHT_IS_FOR_TODAY");

		String cost = rs.getString("COST");



		lblFVal.setText(srno);

		lblLVal.setText(food);

		lblAVal.setText(special);

		lblSVal.setText(cost);



		txtsrno.setText(srno);

		txtfood.setText(food);

		txtspecial.setText(special);

		txtcost.setText(cost);

	}

	private void clearControls()

	{

		txtsrno.setText("");

		txtfood.setText("");

		txtspecial.setText("");

		txtcost.setText("");

	}

}