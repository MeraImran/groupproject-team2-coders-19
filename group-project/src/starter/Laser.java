package starter;

import java.awt.Color;
import java.awt.Graphics;

import acm.graphics.GOval;
import acm.graphics.GRect;

public class Laser {
	
	private GRect laser;
	private double x;
	private double y;
	
	public Laser(double x, double y) {
		laser = new GRect(x, y, 10, 30);
		laser.setFillColor(Color.YELLOW);
		laser.setFilled(true);
		this.x = x;
		this.y = y;
	}
	
	public double getY() {
		return y; 
	}
	
	public void tick() { //move the laser down
		//y += 10;
		laser.move(0, 40);
	}
	
	public GRect getImage() {
		return laser;
	}
}
