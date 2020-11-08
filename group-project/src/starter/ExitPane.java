package starter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import acm.graphics.GImage;
import acm.graphics.GObject;

public class ExitPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GImage img;
	private GParagraph para;

	public ExitPane(MainApplication app) {	
		this.program = app;
		img = new GImage("alien.png", 100, 100);
		img.setColor(Color.GREEN);  //  change the alien image color
		
		para = new GParagraph("Thanks for playing!", 150, 300);
		para.setFont("Arial-24");
		para.setColor(Color.YELLOW); // change the letter color
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
		para.setText("you need\nto click\non the eyes\nto go back");
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == img) {
			program.switchToMenu();
		}
	}
}