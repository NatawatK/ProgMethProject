package model.powerUp;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import logic.Holder;
import model.CollidableEntity;
import scene.ResLoader;

public class BallPlus extends PowerUp{
	
	public BallPlus(double x, double y) {
		super(x,y);
		this.radius = 0.7 * radius;
		canvas = new Canvas(radius*2, radius*2);
		canvas.setTranslateX(x-radius);
		canvas.setTranslateY(y-radius);
		color = Color.LIGHTSKYBLUE;
		this.img = ResLoader.BallPlusImg;
		this.sound = ResLoader.collectSound;
		draw();
	}

	@Override
	public void onCollision(CollidableEntity other) {
		// TODO Auto-generated method stub
		Holder.getInstance().getShooter().increaseMaxBall();
		sound.play();
		this.destroy();
	}

}
