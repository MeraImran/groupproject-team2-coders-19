package starter;

import acm.graphics.*;

public class Spaceship {
	private GImage ship;
	int xPosition, yPosition;
	
	public Spaceship (int xPos, int yPos) {
		ship = new GImage("Spaceship.png", xPos, yPos);
		ship.setSize(75, 75);
		ship.setBounds(xPos, yPos, 75, 75);
		this.xPosition = xPos;
		this.yPosition = yPos;
	}
	
	public Spaceship() {
		ship = new GImage("Spaceship.png", 100, 100);
		ship.setSize(75, 75);
	}
	
	public double getXLocation() {
		return ship.getX();
	}

	public double getYLocation() {
		return ship.getY();
	}
	
	public GImage getShipImg() {
		return ship;
	}
	
	public Laser addLaser() {
		Laser tempLaser = new Laser(ship.getX() + 35, ship.getY());
		return tempLaser;
	}
	
	public void moveLeft() {
		ship.move(-10, 0);
		ship.setBounds(ship.getX(), ship.getY(), 75, 75);
	}
	
	public void moveRight() {
		ship.move(10, 0);
		ship.setBounds(ship.getX(), ship.getY(), 75, 75);
	}
	
    public int getxPos() {
        return xPosition;
    }
    
    public int getyPos() {
        return yPosition;
    }
    
    public void setXPosition(int xPos) {
        this.xPosition = xPos;
    }

    public void setYPosition(int yPos) {
        this.yPosition = yPos;
    }
}

