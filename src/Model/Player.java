package Model;

import javafx.scene.canvas.GraphicsContext;

public class Player extends Entity{
	
	protected int speed;
	protected int life;
	protected double score;
	//protected double direction;
	
	protected int bombLeft, bombLenght, maxBomb;
	
	protected boolean isGrabable;
	protected boolean isProtected;
	
	protected Weapon weapon;
	
	
	public Player(){
		/*
		 * set speed to 10
		 * set life to 3
		 * set score to 0
		 * set maxbomb to 1 
		 * set bomblelf = maxbomb
		 * set isgrab false
		 * set isprotect false
		 * set weapon = bomb
		 */
	}
	
	public void pick(Entity object){
		/*
		 * check if obj is weapon or item
		 * weapon -> equip()
		 * item -> call buff() in item
		 */
	}
	
	public void attack() {
		/*
		 * use current weapon
		 */
	}	
	
	public boolean isDestroyed() {
		//TODO Override this method
		/*
		 * don't forget that this class extend entity naja
		 */
		return false;
	}
	
	public void equip(Weapon weapon) {
		/*
		 * change current weapon to weapon u picked
		 */
	}
	
	public void unequip(Weapon weapon) {
		/*
		 * set weapon back to bomb
		 */
	}
	
	public void draw(GraphicsContext gc) {
	
	}
	
	public void move() {
	
	}
	
}
