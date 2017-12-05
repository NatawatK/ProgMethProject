package model;

public abstract class CollidableEntity extends Entity {
	protected double radius;
	public abstract void onCollision();
}
