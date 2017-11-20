package model;

import javafx.scene.canvas.GraphicsContext;
import model.weapon.*;
import model.item.*;

public class Player extends Entity{
	
	protected int speed;
	protected int life;
	protected double score;
	//protected double direction;
	
	
	
	protected boolean hasGlove;
	protected boolean isProtected;
	
	protected Weapon weapon;
	protected Bomb bomb;
	
	
	
	public Player(){
		this.speed = 10;
		this.life = 3;
		this.score = 0;
		this.hasGlove = false;
		this.isProtected = false;
		bomb = new Bomb();
		this.weapon = bomb;
	}
	
	public void pick(Entity object){
		if(object instanceof Weapon) equip((Weapon)object);
		if(object instanceof Item) ((Item)object).buff();
	
	}
	
	public void attack() {
		weapon.launch();
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
		this.weapon = weapon;
	}
	
	public void unequip(Weapon weapon) {
		this.weapon = bomb;
	}
	
	public void draw(GraphicsContext gc) {
	
	}
	
	public void move() {
	
	}
	
}
