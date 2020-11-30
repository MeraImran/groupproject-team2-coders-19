package starter;

import acm.graphics.*;

public class Spaceship {
	private GImage ship;
	int xPosition, yPosition;
	
	public Spaceship (int xPos, int yPos) {
		ship = new GImage("Spaceship.png", xPos, yPos);
		ship.setSize(75, 75);
		this.xPosition = xPos;
		this.yPosition = yPos;
	}
	
	public Spaceship() {
		ship = new GImage("Spaceship.png", 100, 100);
		ship.setSize(75, 75);
	}
	
	public GImage getShipImg() {
		return ship;
	}
	
	public void moveLeft() {
		ship.move(-10, 0);
	}
	
	public void moveRight() {
		ship.move(10, 0);
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

