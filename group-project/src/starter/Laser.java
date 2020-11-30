package starter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import acm.graphics.GRect;

public class Laser {
	
	private MainApplication program;
	private GRect laser;
	private double x;
	private double y;
	
	public Laser(double x, double y) {
		laser = new GRect(x, y, 5, 50);
		laser.setFillColor(Color.YELLOW);
		laser.setFilled(true);
		this.x = x;
		this.y = y;
	}
	
	public double getY() {
		return y; 
	}
	
	public void tickUp() {
		laser.move(0, -program.LASER_SPEED);
	}
	
	public void tickDown() { //move the laser down
		laser.move(0, program.LASER_SPEED);
	}
	
	public GRect getImage() {
		return laser;
	}
}
