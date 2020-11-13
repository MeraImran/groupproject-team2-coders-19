package starter;


import java.awt.event.MouseEvent;
import java.math.*;     // could be changed
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.Timer;

import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.graphics.GOval;

public class Alien {	
	
	//private LinkedList<Laser> lasers = new LinkedList<Laser>();
	//private ArrayList<Laser> lasers = new ArrayList<Laser>();
	private GImage enemy;
	//Laser tempLaser;
	//Timer laserTimer = new Timer(1000, this);
	
	public Alien(int xCoordinate, int yCoordinate) {
		enemy = new GImage("alien.png", xCoordinate, yCoordinate);
		enemy.setSize(50,50);
		//addLaser(tempLaser);
	}
	
	public void move(int x, int y) {
		enemy.move(x, y);
	}
	
	/*
	 * public void shootLaser(MainApplication app) { for(Laser temp:lasers) {
	 * app.add(temp.getImage()); //temp.tick(); //temp.tick(); //temp.tick();
	 * //temp.tick(); } }
	 */
	
	public Laser addLaser() {
		Laser tempLaser = new Laser(enemy.getX() + 25, enemy.getY() + 25);
		//lasers.add(tempLaser);
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