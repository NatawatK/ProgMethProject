package model;

import javafx.geometry.Rectangle2D;

public abstract class CollidableEntity extends Entity {
	
	public abstract void onCollision(CollidableEntity other);
	public abstract Rectangle2D getRect();
}
