package me.TwoLions.sDodge;

import java.awt.Canvas;
import java.awt.Dimension;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Window extends Canvas{

	private static final long serialVersionUID = 4995473199116630544L;
	
	public Window(float width, float height, String title, SDodge game)
	{
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension((int) width, (int) height));
		frame.setMaximumSize(new Dimension((int) width, (int) height));
		frame.setMinimumSize(new Dimension((int) width, (int) height));	
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);		
		frame.setVisible(true);		
		game.start();
	}

}
