package presentation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.*;
public class HomePanel extends JPanel {



	private String message = "Restaurant Management ";
	private String message2 = "SANA SHAIKH ";
	private String message3 = "CHARMI BHATT";
	private String message1 = "BY ";
	public HomePanel() {
		setBackground(Color.black);
		setForeground(Color.white);

	}

	/** Construct a message panel with a specified message */
	public HomePanel(String message) {

		// this.message = message;
	}


	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Font font = new Font("Serif", Font.PLAIN, 25);
		g.setFont(font);
		g.setFont(new Font(font.getName(),Font.ITALIC,font.getSize()));
		g.drawString(message, 70, 100);
		g.drawString(message1, 250, 240);
		g.drawString(message2, 250, 270);
		g.drawString(message3, 250, 300);


	}

}


