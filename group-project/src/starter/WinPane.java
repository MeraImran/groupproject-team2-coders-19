package starter;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import java.awt.*;
import javax.swing.*;

public class WinPane extends GraphicsPane {

	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GImage img;
	private GParagraph para;
	private Alien Alien;
	private GButton exit;
	private GImage alien;
	private GButton menu;
	



	public WinPane(MainApplication app) {
		this.program = app;
		img = new GImage("robot head.jpg", 100, 100);
		img.setColor(Color.CYAN);
		para = new GParagraph("Your win! Congratulation!", 150, 300);
		para.setFont("Arial-24");
		para.setColor(Color.blue);
		exit = new GButton("Exit Game", 200, 300, 400, 75);
		menu = new GButton("Return Menu", 200, 200, 400, 75);
		// wining score board
	    
	}


	@Override
	public void showContents() {
		program.add(img);
		program.add(para);
		program.add(exit);
		program.add(menu);
		
	}

	@Override
	public void hideContents() {
		program.remove(img);
		program.remove(para);
		program.remove(exit);
		program.remove(menu);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		para.setText("Exit");
		para.setText("you need\nto click\non the eyes\nto go back");
		para.setText("Play again");
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == menu) {
			program.switchToMenu();
		}
		else if(obj==exit) {
			program.switchToExit();
		}
		
		
	}
}
