package model.powerUp;

import javafx.scene.paint.Color;
import model.Ball;
import model.CollidableEntity;
import scene.ResLoader;

public class RandomReflector extends PowerUp{

	public RandomReflector(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub.
		this.color = Color.BROWN;
		this.img = ResLoader.RandomReflectorImg;
		this.sound = ResLoader.reflectorSound;
		draw();
	}

	@Override
	public void onCollision(CollidableEntity other) {
		// TODO Auto-generated method stub
		this.hitted = true;
		((Ball)other).randomDirection();
		sound.play();
	}

}
