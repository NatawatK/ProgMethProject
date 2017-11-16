package Model;

import SharedObject.Renderable;

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

	public int getZ() {
		return z;
	}
	
	
	
}
