package starter;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import javafx.print.PrintColor;

import java.awt.*;
import java.awt.List;

import javax.swing.*;




public class WinPane {

	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GImage img;
	private GParagraph para;
	
	private GButton exit;
	private GButton menu;

	private GamePane gamePane;
	
	private Scoreboard scoreboard;
	private GButton savescore;
	


	
	// winpane code


	public WinPane(MainApplication app) {
		this.program = app;
		img = new GImage("robot head.jpg", 100, 100);
		img.setColor(Color.CYAN);
		para = new GParagraph("You win! Congratulations!", 150, 300);
		para.setFont("Arial-24");
		para.setColor(Color.blue);
		exit = new GButton("Exit Game", 200, 300, 400, 75);
		menu = new GButton("Return Menu", 200, 200, 400, 60);
		//savescore= new GButton("Save Score",200, 200, 400, 50);
		
	
	}	


	public void showContents() {
		program.add(img);
		program.add(para);
		program.add(exit);
		program.add(menu);
		program.add(savescore);
		
	}

	public void hideContents() {
		program.remove(img);
		program.remove(para);
		program.remove(exit);
		program.remove(menu);
		program.remove(savescore);
	}

	public void mousePressed(MouseEvent e) {
		para.setText("you need\nto click\non the eyes\nto go back");
	
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == menu) {
			program.switchToMenu();
		}
		else if(obj==exit) {
			program.switchToExit();
		}
		//else if (obj==savescore) {
			//program.switchToScoreboard();
		//}
		
		
		
	}
}
