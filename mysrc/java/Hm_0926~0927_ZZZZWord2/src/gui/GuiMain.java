package gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import word.WordInfo;

public class GuiMain extends Canvas {
	private JFrame aaa= new JFrame();
	WordInfo w = new WordInfo();
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawLine(50, 100, 100, 200);
		g.drawString(w.getKorName(), 100, 100);
		g.setColor(Color.CYAN);
		g.drawOval(60, 100, 50, 50);
	}

	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
	}

	public GuiMain(){
		aaa.add(this,"Center");
		this.setBackground(Color.yellow);
		aaa.setBounds(100, 200, 300, 500);
		aaa.setVisible(true);
		
	}
}
