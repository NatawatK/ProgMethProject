package model;

import javafx.scene.canvas.Canvas;

public abstract class Entity{
	protected double x,y;
	protected int z;
	protected boolean visible, destroy;
	
	public Canvas canvas;
	
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
	
	abstract void draw();
	
	
	
}
