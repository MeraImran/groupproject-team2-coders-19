package starter;

import acm.graphics.GImage;

public class Alien {	
	
	private GImage enemy;
	private boolean isDead= false;
	public Alien(int xCoordinate, int yCoordinate) {
		enemy = new GImage("alien.png", xCoordinate, yCoordinate);
		enemy.setSize(50,50);
	}
	
	public void move(int x, int y) {
		enemy.move(x, y);
	}
	
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
	public boolean isDead(){
		return isDead;
	}
	public void setDead() {
		isDead = true;
	}
}