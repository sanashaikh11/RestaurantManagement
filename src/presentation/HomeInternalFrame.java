package presentation;
import java.awt.BorderLayout;

import javax.swing.JFrame;
	import javax.swing.JInternalFrame;
	import javax.swing.JPanel;
public class HomeInternalFrame extends JInternalFrame {
	

		
		private JPanel panel;
		JFrame j1;
		public HomeInternalFrame(JPanel panel) {
			if(this.panel!=null)
				this.remove(this.panel);
			this.panel = panel;
			this.setLayout(new BorderLayout());
			this.add(this.panel,BorderLayout.CENTER);
			
			
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setIconifiable(true);
			this.setVisible(true);
			this.setClosable(true);
			this.setSize(450,350);

			
			
		}


	}


