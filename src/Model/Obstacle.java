package Model;

import javafx.scene.image.Image;

public abstract class Obstacle extends Entity{
	public final static double dropProability = 0.3;
	protected boolean Destroyable;
	
	protected Image sprite;
	//proteced boolean hideable; //(optional)
	
	public void destroy() {
		/*
		 * destroy this obstacle and drop item
		 */
	}
	
	public void drop() { //u can skip this
		/*
		 * check should u  drop an item by random and check with dropProbability
		 * 
		 * if SHOULD spawn item in this x,y;
		 */
	}
	
}
