package presentation;


import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class MainClass extends JFrame {
	private JDesktopPane desktop;
	private LoginFrame lf;
	private MainFrame af;
	private MainFrame2 ef;
	
	public MainClass() {
	this.setInternalFrame("Login");
		this.setTitle("Main");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setInternalFrame(String type) {
		switch (type) {
		/*
		 * case "Login":lf = new LoginFrame(this); lf.setVisible(true);
		 * MainClass.this.desktop.add(lf); break;
		 */
		case "Login":
			lf =  new LoginFrame(this);
			lf.setVisible(true);
			if(af!=null)
				af.setVisible(false);
			if(ef!=null)
				ef.setVisible(false);
			
			MainClass.this.desktop.add(lf);
			break;
		
		case "Admin":
			af =  new MainFrame();
			//MainFrame af =  new MainFrame();
			lf.setVisible(false);
			if(ef!=null)
				ef.setVisible(false);
			af.setVisible(true);
			MainClass.this.desktop.add(af) ;
			break;
		
		case "Staff":
			 ef =  new MainFrame2(this);
			lf.setVisible(false);
			af.setVisible(false);
		ef.setVisible(true);
			MainClass.this.desktop.add(ef) ;
			
			break;
		default:
			af =  new MainFrame();
			//MainFrame af =  new MainFrame();
			lf.setVisible(false);
			if(ef!=null)
				ef.setVisible(false);
			af.setVisible(true);
			MainClass.this.desktop.add(af) ;
	}
	}
}

