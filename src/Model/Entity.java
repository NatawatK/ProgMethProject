package model;

import sharedObject.Renderable;

public abstract class Entity implements Renderable{
	protected double x,y;
	protected int z;
	protected boolean visible, destroy;
	
	public Entity() {
		visible = true;
		destroy = false;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public boolean isDestroyed() {
		return destroy;
	}
	
	public void destroy() {
		this.destroy = true;
		this.visible = false;
	}

	public int getZ() {
		return z;
	}
	
	
	
}
