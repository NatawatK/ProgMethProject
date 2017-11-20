package model;

import java.util.Random;

import javafx.scene.image.Image;

public abstract class Obstacle extends Entity{
	public final static double dropProability = 30;
	protected boolean Destroyable;
	
	protected Image sprite;
	//proteced boolean hideable; //(optional)
	
	public void destroy() {
		/*
		 * destroy this obstacle and drop item
		 */
		this.destroy = false;
		drop();
	}
	
	public void drop() { //u can skip this
		/*
		 * check should u  drop an item by random and check with dropProbability
		 * 
		 * if SHOULD spawn item in this x,y;
		 */
		Random rd = new Random();
		double x = rd.nextDouble();
		if(x*100 <= dropProability) {
			System.out.println("Drop");
			
		}
		System.out.println(x);
		
	}
	
}