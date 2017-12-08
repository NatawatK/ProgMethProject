package model;

import javafx.scene.canvas.Canvas;

public abstract class Entity{
	protected double x,y;
	protected boolean destroy;
	
	public Canvas canvas;
	
	public Entity() {
		destroy = false;
	}
	
	
	public boolean isDestroyed() {
		return destroy;
	}
	
	abstract public void destroy();
	
	abstract void draw();
	
	
	
}
