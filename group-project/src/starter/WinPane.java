package starter;
import java.awt.event.MouseEvent;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import java.awt.*;

public class WinPane extends GraphicsPane {

   private MainApplication program;
   private GLabel title;
   private GLabel title1;
   private GLabel title2;
   private GButton exit;
   private GButton menu;
   private int s;

	public WinPane(MainApplication app, int currScore) {
		super();
		this.program = app;
		s = currScore;
		title = new GLabel("You win!",200, 100);
		title.setFont("ShowcardGothic-80");
		title.setColor(Color.green);
		title1 = new GLabel("Your score: "+s,250,200);
		title1.setFont("Arial-40");
		title1.setColor(Color.white);
		title2=new GLabel("Thanks For Playing!",230,500);
		title2.setFont("Arial-40");
		title2.setColor(Color.white);
		exit = new GButton("Exit Game",  program.WINDOW_WIDTH/4, program.WINDOW_HEIGHT/4 + 200, program.BUTTON_WIDTH, program.BUTTON_HEIGHT);
		exit.setFillColor(Color.ORANGE);
		menu = new GButton("Return Menu",  program.WINDOW_WIDTH/4, program.WINDOW_HEIGHT/4+100, program.BUTTON_WIDTH, program.BUTTON_HEIGHT);
		menu.setFillColor(Color.DARK_GRAY);
	}
	
	public void showContents() {
		program.add(title1);
		program.add(title);
		program.add(exit);
		program.add(menu);
		program.add(title2);
	}

	public void hideContents() {
		program.remove(title2);
	    program.remove(title1);
		program.remove(title);
		program.remove(exit);
		program.remove(menu);
	}

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
