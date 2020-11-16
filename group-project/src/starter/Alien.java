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
	
	private GImage enemy;
	
	public Alien(int xCoordinate, int yCoordinate) {
		enemy = new GImage("alien.png", xCoordinate, yCoordinate);
		enemy.setSize(50,50);
	}
	
	public void move(int x, int y) {
		enemy.move(x, y);
	}
	
	public Laser addLaser() {
		Laser tempLaser = new Laser(enemy.getX() + 25, enemy.getY() + 30);
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