package presentation;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


import javax.swing.*;
public class MainFrame extends JFrame {

	private JMenuBar menuBar;
	private JMenu mhome,mexit,mreview,mrestm,mapply;
	private JMenu mdetails,mmenu;
	private JMenu morder,mbilling;
	private JMenuItem mItemExit,mItemBill,mItemHome,mItemReview,mItemMenu,mItemrestm,mItemapply;
	private JMenuItem mItemorder;
	private JMenuItem mItemPerson;
	private JDesktopPane desktop;


	private JMenuItem menuItem;

	public MainFrame()
	{
		this.initialize();
		this.setTitle("PROJECT");
		this.setSize(500,450);

		//setLayout(new BorderLayout());



	}

	private void initialize()
	{
		menuBar = new JMenuBar();	
		menuBar.setBackground(new Color(143, 188, 143));
		
		mbilling =new JMenu("Admin's Login");
		mbilling.setBackground(new Color(143, 188, 143));
		mexit= new JMenu("EXIT");

		mreview = new JMenu("Logout");
		mrestm=new JMenu("Restaurant's Menu");
        mapply=new JMenu("Applications");


		desktop=new JDesktopPane();
		desktop.setBackground(new Color(240, 255, 255));
		desktop.setForeground(Color.white);

		this.setContentPane(desktop);

		mItemBill = new JMenuItem("Staff Payroll");
		mItemBill.setMnemonic(KeyEvent.VK_P);
		mItemBill.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
	//	mItemBill.addActionListener(new ExitEventHandler());
		
		mItemrestm=new JMenuItem("Menu Card");
		mItemrestm.setMnemonic(KeyEvent.VK_M);
		mItemrestm.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
	//	mItemrestm.addActionListener(new ExitEventHandler());
		
		mItemapply=new JMenuItem("Check the applications");
		mItemapply.setMnemonic(KeyEvent.VK_A);
		mItemapply.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
	//	mItemapply.addActionListener(new ExitEventHandler());
		
		mItemapply.addActionListener(new applyEventHandler());
		mItemrestm.addActionListener(new DatabaseEventHandler());

		mItemExit = new JMenuItem("Exit");
		mItemExit.setMnemonic(KeyEvent.VK_X);
		mItemExit.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		mItemExit.addActionListener(new ExitEventHandler());

		mItemReview = new JMenuItem("To Logout from the admin");
		mItemReview.setMnemonic(KeyEvent.VK_L);
		mItemReview.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		mItemReview.addActionListener(new ExitEventHandler());
		mItemReview.addActionListener(new reviewEventHandler());




		mItemBill.addActionListener(new billEventHandler());
        mapply.add(mItemapply);
		mexit.add(mItemExit);
		mrestm.add(mItemrestm);
		mreview.add(mItemReview);
		mbilling.add(mItemBill);
		menuBar.add(mbilling);
		menuBar.add(mrestm);
		menuBar.add(mapply);
		menuBar.add(mreview);


		menuBar.add(mexit);
		this.setJMenuBar(menuBar);



	}
	private class ExitEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}


	private class billEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			MainFrame.this.desktop.removeAll();
			JInternalFrame bill = new HomeInternalFrame(new StaffPay());
			bill.setVisible(true);
			MainFrame.this.desktop.add(bill);
		}
	}
	private class DatabaseEventHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			database obj = new database();

		//	obj.createUI();
			//obj.setSize(400,400);

			System.out.println("logout ");
			//me.setVisible(true);
			//prentFrame.add(me);
		}
	}
	private class reviewEventHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JFrame frame = new MainClass();
			frame.setVisible(true);

			System.out.println("logout ");
			//me.setVisible(true);
			//prentFrame.add(me);
		}
	}
	private class applyEventHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			ProgramDB2 p=new ProgramDB2();
			p.setVisible(true);
			p.setSize(500,450);

			System.out.println("logout ");
			//me.setVisible(true);
			//prentFrame.add(me);
		}
	}
	




}