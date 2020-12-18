package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Oval extends JPanel {
	
	int mark;
	
	public Oval(int mark) {
		this.mark = mark;
	    this.setPreferredSize(new Dimension(150, 150));
	}
	
	public void paint(Graphics g) {
		if (mark == 1) {
			g.setColor(Color.BLACK);
		} else {
			g.setColor(Color.WHITE);
		}
		
		g.fillOval(25, 20, 100, 100);
			
		
	}
}
