package starter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.Timer;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;

public class GamePane extends GraphicsPane implements ActionListener {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	
	private ArrayList<ArrayList<Alien>> aliens;
	private ArrayList<Laser> lasers = new ArrayList<Laser>();
	private Alien enemy;
	private int xCoordinate = 0; //move variables to mainapplication
	private int yCoordinate = 10;
	private int amount;
	private int xVelocity = 50;
	private int yVelocity = 0;
	private int counter;
	Random r = new Random();
 
	public GamePane(MainApplication app) {
		this.program = app;
		drawAliens();
		Timer someTimer = new Timer(1000, this);
		someTimer.start();
	}
	
	private boolean outOfBounds() {
		for (int i = 0; i < program.ROW_ALIENS; i++) {
			for (int j = 0; j < program.COLUMN_ALIENS; j++) {
				if (aliens.get(i).get(j).getX() < 0 || aliens.get(i).get(j).getX() > program.WINDOW_WIDTH - 100) {
					return true;		
				}
			}
		}
		return false;
	}
	
	public void actionPerformed(ActionEvent e) {
		counter++;
		if (outOfBounds()) {
			xVelocity *=-1;
			yVelocity += 1;
		}
		for (int i = 0; i < program.ROW_ALIENS; i++) {
			for (int j = 0; j < program.COLUMN_ALIENS; j++) {
				aliens.get(i).get(j).move(xVelocity, yVelocity); //moves all the aliens together
				
			}
		}
		
		int rowRand = r.nextInt(program.ROW_ALIENS);
		int colRand = r.nextInt(program.COLUMN_ALIENS);
		
		if (counter %  2 == 0) {
			Laser tempLaser = aliens.get(rowRand).get(colRand).addLaser();
			tempLaser.getImage().sendToBack();
			lasers.add(tempLaser);
			program.add(tempLaser.getImage());
		}
		
		for (Laser temp: lasers) {
			temp.tick();
		}

	}
	
	private void drawAliens() {
		aliens = new ArrayList<>();
		for (int i = 0; i < program.ROW_ALIENS; i++) {
			aliens.add(new ArrayList<Alien>());
		}
		for (int i = 0; i < program.ROW_ALIENS; i++) {
			for (int j = 0; j < program.COLUMN_ALIENS; j++) {
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
		for (int i = 0; i < program.ROW_ALIENS; i++ ) {
			for (int j = 0; j < program.COLUMN_ALIENS; j++) {
				program.add(aliens.get(i).get(j).getImage());
			}
		}
	}

	@Override
	public void hideContents() {
		//program.remove(img); //condition statement, if laser hits alien remove alien
		//program.remove(para);
	}

	@Override
	public void mousePressed(MouseEvent e) { //Commands for spaceship will go here
		
	}
}
