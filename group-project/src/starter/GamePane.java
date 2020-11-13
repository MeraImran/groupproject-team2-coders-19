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
import java.util.LinkedList;
import java.util.Random;

import javax.swing.Timer;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;

public class GamePane extends GraphicsPane implements ActionListener, KeyListener {
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
 
	
	private Spaceship ship;
	Rectangle bullet;
	double dx = 0, x = 0, y = 0, velx = 0, vely = 0;
	int playerX, playerY, bx, by;
	boolean readyToFire, shot = false;
	int xPos, yPos;
	
	public GamePane(MainApplication app) {
		this.program = app;
		drawAliens();
		//drawSpaceship();
		Timer someTimer = new Timer(1000, this);
		someTimer.start();
		addKeyListener(this);
		setFocusTraversalKeysEnabled(false);
	}
	
	private void setFocusTraversalKeysEnabled(boolean b) {} // TODO Auto-generated method stub
	private void addKeyListener(GamePane gamePane) {} // TODO Auto-generated method stub
	
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
	
	//Where Spaceship and Bullet Start
	public void drawSpaceship(Graphics g) {
		playerX = 250;
		playerY = 400;
		//ship = new Spaceship(playerX, playerY);
		setFocusTraversalKeysEnabled(false);
		addKeyListener(this);
		//super.paintComponent(g);

		g.setColor(Color.green);
		g.fillRect(playerX, playerY, 50, 50);
		
		if(shot) {
			g.setColor(Color.RED);
			g.fillRect(bullet.x,  bullet.y,  bullet.width, bullet.height);
		}
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
		if (code == KeyEvent.VK_SPACE) {
			if(bullet == null)
				readyToFire = true;
			if (readyToFire) {
				by = playerY;
				bx = playerX;
				bullet = new Rectangle(bx, by, 3, 10);
				shot = true;
			}
		}
		//repaint();
	}

	public void shoot() {
		if(shot)
			bullet.y--;
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_LEFT) {
				dx = 0;
			}
			if (key == KeyEvent.VK_RIGHT) {
				dx = 0;
			}
			if (key == KeyEvent.VK_SPACE) {
				readyToFire = false;
				if(bullet.y <= -5) {
					bullet = new Rectangle(0, 0, 0, 0);
					shot = false;
					readyToFire = true;
				}
			}
	}
	public boolean isFocusTraversable() {
		return true;
	}	
}
