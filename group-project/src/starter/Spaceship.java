package starter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import acm.graphics.*;
import javax.swing.ImageIcon;


public class Spaceship extends JPanel implements ActionListener, KeyListener{
	double x = 0, y = 0, dx = 0;
	
	Timer timer;
	int width, playerX, playerY, bx, by;
	boolean readyToFire, shot = false;
	
	Rectangle bullet;
		
	public static void main(String args[]) {
		JFrame f = new JFrame();
		Spaceship ship = new Spaceship();
		f.add(ship);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,500);
	}
	
	public Spaceship() {
		//initPlayer();
		playerX = 250;
		playerY = 400;
		Timer t = new Timer(5, this);
		setFocusTraversalKeysEnabled(false);
		t.start();
		addKeyListener(this);
	}
		
	private void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		g.setColor(Color.green);
		g.fillRect(playerX, playerY, 50, 50);
		
		if(shot) {
			g.setColor(Color.RED);
			g.fillRect(bullet.x,  bullet.y,  bullet.width, bullet.height);
		}
	}

	public void keyTyped(KeyEvent e) {}
	
	public void move() {
		x += dx;
		if (x <= 2)
			x = 2;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			playerX=playerX-6;
			if(playerX<-10) {
				playerX=590;
			}
		}
		if (key == KeyEvent.VK_RIGHT) {
			playerX=playerX+6;
			if(playerX>590) {
				playerX=-10;
			}
		}
		if (key == KeyEvent.VK_SPACE) {
			if(bullet == null)
				readyToFire = true;
			if (readyToFire) {
				by = playerY;
				bx = playerX;
				bullet = new Rectangle(bx, by, 3, 10);
				shot = true;
			}
		}
		repaint();
	}
	
	public void shoot() {
		if(shot)
			bullet.y--;
	}
		
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		if (key == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
		if (key == KeyEvent.VK_SPACE) {
			readyToFire = false;
			if(bullet.y <= -5) {
				bullet = new Rectangle(0, 0, 0, 0);
				shot = false;
				readyToFire = true;
			}
		}
	}
	
	public boolean isFocusTraversable() {
		return true;
	}	
}
