package model.powerUp;

import javafx.scene.paint.Color;
import logic.Holder;
import model.CollidableEntity;

public class BallPlus extends PowerUp{
	
	public BallPlus(double x, double y) {
		super(x,y);
		color = Color.LIGHTSKYBLUE;
		draw();
	}

	@Override
	public void onCollision(CollidableEntity other) {
		// TODO Auto-generated method stub
		Holder.getInstance().getShooter().increaseMaxBall();
		this.destroy();
	}

}
