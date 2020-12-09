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

	public LosePane(MainApplication app) {
		this.program = app;
		img = new GImage("alien.png", 50, 100);
		para = new GParagraph("GAMEOVER!", 250, 100);
		para.setFont("ShowcardGothic-50");
		para.setColor(Color.YELLOW);
	}

	@Override
	public void showContents() {
		program.add(img);
		program.add(para);
	}

	@Override
	public void hideContents() {
		program.remove(img);
		program.remove(para);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == img) {
			program.switchToMenu();
		}
	}
}
