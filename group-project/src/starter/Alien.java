package starter;


import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import acm.graphics.GImage;

public class Alien {	
	
	private GImage enemy;
	private Timer shooting;
	private ArrayList<Laser> lasers = new ArrayList<Laser>();
	private int counter;
	
	public Alien(int xCoordinate, int yCoordinate) {
		enemy = new GImage("alien.png", xCoordinate, yCoordinate);
		enemy.setSize(50,50);
		
	}
	
	public void move(int x, int y) {
		enemy.move(x, y);
	}
	
	
	/*
	 * public void run() { shooting = new Timer(2, this); shooting.start(); }
	 * 
	 * public void actionPerformed(ActionEvent e) { counter++; if (counter % 2 == 0)
	 * { Laser tempLaser = aliens.get(rowRand).get(colRand).addLaser();
	 * tempLaser.getImage().sendToBack(); lasers.add(tempLaser);
	 * program.add(tempLaser.getImage()); }
	 * 
	 * for (Laser temp: lasers) { temp.tick(); } }
	 */
	 
	
	public Laser addLaser() {
		Laser tempLaser = new Laser(enemy.getX() + 20, enemy.getY());
		return tempLaser;
	}
	
	public double getX() {
		return enemy.getX();
	}
	
	public double getY() {
		return enemy.getY();
	}
	
	public GImage getImage() {
		return enemy;
	}
}