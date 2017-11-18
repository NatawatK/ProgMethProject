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
	Bomb bomb = new Bomb();
	
	
	
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
		this.speed = 10;
		this.life = 3;
		this.score = 0;
		this.maxBomb = 1;
		this.bombLeft = maxBomb;
		this.isGrabable = false;
		this.isProtected = false;
		this.weapon = bomb;
	}
	
	public void pick(Entity object){
		/*
		 * check if obj is weapon or item
		 * weapon -> equip()
		 * item -> call buff() in item
		 */
		if(object instanceof Weapon) equip(Weapon object);
		if(object instanceof Item) (Item object).buff();
		
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
		if(life==0) return true;
		return false;
	}
	
	public void equip(Weapon weapon) {
		/*
		 * change current weapon to weapon u picked
		 */
		this.weapon = weapon;
	}
	
	public void unequip(Weapon weapon) {
		/*
		 * set weapon back to bomb
		 */
		this.weapon = bomb;
	}
	
	public void draw(GraphicsContext gc) {
	
	}
	
	public void move() {
	
	}
	
}
