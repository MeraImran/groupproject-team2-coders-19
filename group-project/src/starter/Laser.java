package starter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import acm.graphics.GRect;

public class Laser {
	
	private GRect laser;
	private double x;
	private double y;
	private Timer shoot;
	
	public Laser(double x, double y) {
		laser = new GRect(x, y, 10, 50);
		laser.setFillColor(Color.YELLOW);
		laser.setFilled(true);
		this.x = x;
		this.y = y;
	}
	
	public void run() {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public double getY() {
		return y; 
	}
	
	public void tick() { //move the laser down
		laser.move(0, 100);
	}
	
	public GRect getImage() {
		return laser;
	}
}
