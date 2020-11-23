package starter;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import javafx.print.PrintColor;

import java.awt.*;
import java.awt.List;

import javax.swing.*;

import com.sun.org.apache.xml.internal.utils.CharKey;

import java.lang.reflect.Constructor;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class WinPane<Team> extends GraphicsPane {

	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GImage img;
	private GParagraph para;
	private Alien Alien;
	private GButton exit;
	private GImage alien;
	private GButton menu;
	
	//for scoreboard variable
	
	  private String title;
	  private Map<String, Integer> scores;
	  private Object obj;
	  private java.util.List<Object> teams;
	  private List removed;
	  private Set<String> updated;
	  

	    private Class<?> gameProfileClass;
	    private Constructor<?> gameProfileConstructor;
	    private Constructor<?> craftOfflinePlayerConstructor;
	
	  
    //starter of scoreboard code
	public void ScoreBoard() {
		 this.title = setColor();
		this.scores = new ConcurrentHashMap<>();
		this.teams = Collections.synchronizedList(null);
		//this removed have error
		
		 this.scores = new ConcurrentHashMap<>();
		  this.updated = Collections.synchronizedSet(new HashSet<>());
	}


	private String setColor() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean remove(Integer score, String text) {
		return remove(score,text);
	}
	public void setTitle(String title) {
        this.title = setColor();

        if(obj != null) {
        	//should change that
        	obj.toString();
        }
          
    }

    public void update() {
        if (updated.isEmpty()) {
            return;
        }

        if (obj == null) {
        	Object scoreboard;
			// should change
        	
          return;
        }
    }


	
	// winpane code
	public WinPane(MainApplication app) {
		this.program = app;
		img = new GImage("robot head.jpg", 100, 100);
		img.setColor(Color.CYAN);
		para = new GParagraph("Your win! Congratulation!", 150, 300);
		para.setFont("Arial-24");
		para.setColor(Color.blue);
		exit = new GButton("Exit Game", 200, 300, 400, 75);
		menu = new GButton("Return Menu", 200, 200, 400, 75);
		// wining score board
	    
	}


	@Override
	public void showContents() {
		program.add(img);
		program.add(para);
		program.add(exit);
		program.add(menu);
		
	}

	@Override
	public void hideContents() {
		program.remove(img);
		program.remove(para);
		program.remove(exit);
		program.remove(menu);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		para.setText("Exit");
		para.setText("you need\nto click\non the eyes\nto go back");
		para.setText("Play again");
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == menu) {
			program.switchToMenu();
		}
		else if(obj==exit) {
			program.switchToExit();
		}
		
		
	}
}
