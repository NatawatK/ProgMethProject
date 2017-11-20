package model.weapon;

import model.Entity;

public abstract class Weapon extends Entity{
	
	protected double cooldown;
	protected double lifeTime;
	
	protected int quantity;
	protected int attackLenght;
	
	protected boolean isExpired;
	
	
	public abstract void launch();
	public abstract void boom();
	
	
}
