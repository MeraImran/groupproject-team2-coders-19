package starter;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class LosePane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GImage img;
	private GParagraph para;
	private GButton exit;
	private GButton menu;

	public LosePane(MainApplication app) {
		this.program = app;
		img = new GImage("alien.png", 350, 125);
		img.setSize(100, 100);
		para = new GParagraph("GAMEOVER!", 250, 100);
		para.setFont("ShowcardGothic-50");
		para.setColor(Color.YELLOW);
		exit = new GButton("Exit Game",  program.WINDOW_WIDTH/4, program.WINDOW_HEIGHT/4 + 200, program.BUTTON_WIDTH, program.BUTTON_HEIGHT);
		exit.setFillColor(Color.ORANGE);
		menu = new GButton("Return Menu",  program.WINDOW_WIDTH/4, program.WINDOW_HEIGHT/4+100, program.BUTTON_WIDTH, program.BUTTON_HEIGHT);
		menu.setFillColor(Color.DARK_GRAY);
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
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == menu) {
			program.switchToMenu();
		}
		else if(obj==exit) {
			program.switchToExit();
		}
	}
}
