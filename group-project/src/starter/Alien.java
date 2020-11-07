package starter;


import java.awt.event.MouseEvent;
import java.math.*;     // could be changed

import acm.graphics.GImage;

public class Alien {	
	

	private GImage enemy;
	
	public Alien(int xCoordinate, int yCoordinate) {
		enemy = new GImage("alien.png", xCoordinate, yCoordinate);
		enemy.setSize(50,50);
	}
	private static int length;
	Alien[] alien = new Alien[10];
	boolean mLeft = false;
	boolean mRight= false;
		
	
	public Alien() {
		enemy = new GImage("alien.png", 100, 100);
		enemy.setSize(50, 50); //maybe set size on game screen
	}
	
	public void move(int x, int y) {
		enemy.move(x, y);
	}
	
	public double getX() {
		return enemy.getX();
	}
	
	public GImage getImage() {
		return enemy;
	}
	
	public void moveAlien() {
		
		for(int i =0; i < alien.length; i++) {
			if(alien[i].mLeft == true) {
			   //alien[i].xVelocity -= 2;
			}
            if(alien[i].mRight == true) {
               //alien[i].xVelocity += 2;
			}
		}
	}
	
	
	
	
}