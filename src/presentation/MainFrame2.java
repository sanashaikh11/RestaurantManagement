package presentation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.*;






public class MainFrame2 extends JFrame {
	JFrame parentFrame;
	private JDesktopPane desktop;
	JMenu menu, submenu, exit,ok,apply;
	JMenuItem i1, i2, i3, i4, i5,ok2,logout,apply1;
	JInternalFrame me ;

	MainFrame2(JFrame pFrame) {
		getContentPane().setBackground(new Color(240, 255, 255));
		this.parentFrame = pFrame;
		JMenuBar mb = new JMenuBar();
		mb.setBackground(new Color(143, 188, 143));
		menu = new JMenu("Customer's Preference ");
		exit = new JMenu("Exit");
		submenu = new JMenu("Sub Menu");
		i1 = new JMenuItem("Restaurants Menu Card");
		i1.setMnemonic(KeyEvent.VK_M);
		i1.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		
		i2 = new JMenuItem("Review");
		i2.setMnemonic(KeyEvent.VK_R);
		i2.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		i3 = new JMenuItem("Resevation");
		i3.setMnemonic(KeyEvent.VK_B);
		i3.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		i5 = new JMenuItem("Item 5");
		
	//	apply1=new JMenuItem("Apply here");
		//apply1.setMnemonic(KeyEvent.VK_A);
		//apply1.setAccelerator(
				//KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		logout=new JMenuItem("Logout");
		logout.setMnemonic(KeyEvent.VK_L);
		logout.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		ok2 = new JMenuItem("Exit");
		ok2.setMnemonic(KeyEvent.VK_X);
		ok2.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

		menu.add(i1);
		menu.add(i2);
		menu.add(i3);
		
		//menu.add(apply1);
		menu.add(ok2);
		//menu.add(logout);
		mb.add(menu);
		mb.add(logout);
		setJMenuBar(mb);
		setSize(500, 450);
		getContentPane().setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//i1.addActionListener(new MenuHandler(this));
		i1.addActionListener(new MenuHandler());
		i2.addActionListener(new ReviewHandler(this));
		i3.addActionListener(new registrationHandler(this));
		exit.addActionListener(new ExitHandler());
		logout.addActionListener(new logoutHandler());
		//apply1.addActionListener(new ApplyHandler());
		ok2.addActionListener(new ExitHandler());
	}
	private class MenuHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JFrame frame = new MenuTable();
			frame.setVisible(true);
			frame.setSize(500, 450);
			System.out.println("logout ");
		}
	}
	private class registrationHandler implements ActionListener {
		JFrame prentFrame;

		public registrationHandler(JFrame parentFrame) {
			this.prentFrame = parentFrame;
		}

		public void actionPerformed(ActionEvent e) {

			if(me!=null)
				me.dispose();

			me = new HomeInternalFrame1(new registration());
			me.setVisible(true);
			prentFrame.getContentPane().add(me);
		}
	}
	private class ReviewHandler implements ActionListener {
		JFrame prentFrame;

		public ReviewHandler(JFrame parentFrame) {
			this.prentFrame = parentFrame;
		}

		public void actionPerformed(ActionEvent e) {
			if(me!=null)
				me.dispose();

			me = new HomeInternalFrame1(new ReviewPanel());
			me.setVisible(true);
			prentFrame.getContentPane().add(me);
		}
	}


	private class ExitHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			System.out.println("exit on");

			System.exit(0);
		}

	}

	private class logoutHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFrame frame = new MainClass();
			frame.setVisible(true);
			

			System.out.println("logout ");
		}
	}
	/*private class ApplyHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
				ProgramsDB p=new ProgramsDB();
				p.setVisible(true);
				p.setSize(500,450);
			

			System.out.println("logout ");
		}
	}*/


}