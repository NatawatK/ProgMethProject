package model.powerUp;

import javafx.scene.paint.Color;
import model.Ball;
import model.CollidableEntity;

public class RandomReflector extends PowerUp{

	public RandomReflector(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub.
		this.color = Color.BROWN;
		draw();
	}

	@Override
	public void onCollision(CollidableEntity other) {
		// TODO Auto-generated method stub
		this.hitted = true;
		((Ball)other).randomDirection();
	}

}
