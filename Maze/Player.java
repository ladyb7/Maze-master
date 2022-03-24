package Maze;

import static Maze.MazeMapMaker.map;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;


public class Player extends JPanel{
    
    int x, y;
    
    public Player() {
    	this.setBackground(Color.getHSBColor(0.3f, 0.6f, 1));
    	this.setSize(Maze.panelSize, Maze.panelSize);
    }

    public void moveLeft() {
    	if(x > 0 && Maze.map[x-1][y] == 1){
	    	this.setLocation(this.getX()-25, this.getY());
	    	x--;
    	}
    }

    public void moveRight() {
    	if(x < Maze.columns-1 && Maze.map[x+1][y] == 1){
	    	this.setLocation(this.getX()+25, this.getY());
	    	x++;
    	}
    }

    public void moveUp() {
    	if(y > 0 && Maze.map[x][y-1] == 1){
	    	this.setLocation(this.getX(), this.getY()-25);
	    	y--;
    	}
    }

    public void moveDown() {
    	if(y < Maze.rows-1 && Maze.map[x][y+1] == 1){
	    	this.setLocation(this.getX(), this.getY()+25);
	    	y++;
    	}
    }
    
    
    public boolean taken;
    public  boolean takeItem(boolean b) {
        // take the item and make it unvisible
        // score++
        // create a method to display score even after finish all levels
        
            b =true;
            this.setVisible(false);
        return true;
    }
}


