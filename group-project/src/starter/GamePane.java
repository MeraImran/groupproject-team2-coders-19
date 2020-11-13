package starter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.Timer;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;

public class GamePane extends GraphicsPane implements ActionListener, KeyListener {
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
	
	private Spaceship ship;
	double x = 0, y = 0, velx = 0, vely = 0;
	int xPos, yPos;
	
	public GamePane(MainApplication app) {
		this.program = app;
		drawAliens();
		drawSpaceship();
		Timer someTimer = new Timer(1000, this);
		someTimer.start();
		addKeyListener(this);
		setFocusTraversalKeysEnabled(false);
	}

	private void setFocusTraversalKeysEnabled(boolean b) {} // TODO Auto-generated method stub
	private void addKeyListener(GamePane gamePane) {} // TODO Auto-generated method stub

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
		//System.out.println("Amount of aliens: " + amount);
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
		//program.remove(img); //condition statement, if laser hits alien remove aline
		//program.remove(para);
	}

	
	//Where Spaceship and Bullet Start
	public void drawSpaceship() {
		ship = new Spaceship(xPos, yPos);
	}
	
	public void actionPerformed2(ActionEvent e) {
		x += velx;
		y += vely;
	}
	public void left() {
		velx = -1.5;
		vely = 0;
	}
	public void right() {
		velx = 0;
		vely = 1.5;
	}
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_LEFT) {
			left();
		}
		if (code == KeyEvent.VK_RIGHT) {
			right();
		}
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}
