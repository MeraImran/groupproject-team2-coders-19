package starter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.Timer;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;

public class GamePane extends GraphicsPane implements ActionListener {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	
	private ArrayList<ArrayList<Alien>> aliens;
	private Alien enemy;
	private int xCoordinate = 0;
	private int yCoordinate = 10;
	private int rowAliens = 4;
	private int colAliens = 8;
	private int amount;
	private int xVelocity = 50;
	private int yVelocity = 0;
	

	public GamePane(MainApplication app) {
		this.program = app;
		drawAliens();
		Timer someTimer = new Timer(1000, this);
		someTimer.start();
	}
	
	private boolean outOfBounds() {
		for (int i = 0; i < rowAliens; i++) {
			for (int j = 0; j < colAliens; j++) {
				if (aliens.get(i).get(j).getX() < 0 || aliens.get(i).get(j).getX() > program.WINDOW_WIDTH - 100) {
					return true;		
				}
			}
		}
		return false;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (outOfBounds()) {
			xVelocity *=-1;
			yVelocity += 1;
		}
		for (int i = 0; i < rowAliens; i++) {
			for (int j = 0; j < colAliens; j++) {
				aliens.get(i).get(j).move(xVelocity, yVelocity); //moves all the aliens together
			}
		}
		System.out.println("Amount of aliens: " + amount);
	}
	
	private void drawAliens() {
		aliens = new ArrayList<>();
		for (int i = 0; i < rowAliens; i++) {
			aliens.add(new ArrayList<Alien>());
		}
		for (int i = 0; i < rowAliens; i++) {
			for (int j = 0; j < colAliens; j++) {
				enemy = new Alien(xCoordinate, yCoordinate);
				aliens.get(i).add(enemy);
				xCoordinate+=50;
				amount++;
			}
			xCoordinate=0;
			yCoordinate+=50;
		}
	}

	@Override
	public void showContents() {
		for (int i = 0; i < rowAliens; i++ ) {
			for (int j = 0; j < colAliens; j++) {
				program.add(aliens.get(i).get(j).getImage());
			}
		}
	}

	@Override
	public void hideContents() {
		for(int j = 0; j < colAliens; j++) {
		//	if (laser[i].collides(colAliens)) {
		//		program.remove();
			//}
		}
		
		//program.remove(img); //condition statement, if laser hits alien remove alien
		
		
		//program.remove(para);
	}

	@Override
	public void mousePressed(MouseEvent e) { //Commands for spaceship will go here
		
	}
}
