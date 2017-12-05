package model;

import org.dyn4j.geometry.Vector2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Pair;
import logic.Holder;
import scene.GameStage;

public class Shooter extends Entity{
	
	protected int maxBall;
	protected double newX, newY;
	protected Vector2 shootDirection;
	
	public Shooter() {
		this.maxBall = 10;
		this.x = GameStage.GAME_WIDTH / 2;
		this.y = GameStage.GAME_HEIGHT - 10;
		this.shootDirection = new Vector2(2,3);
		this.newX = -1;
		this.newY = -1;
	}
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.RED);
		gc.fillRect(x-10, y-10, 20, 20);
	}
	public void shoot(Vector2 direction) {
		newX = newY = -1;
		for(int i = 0; i < maxBall ; i++) {
			Holder.getInstance().add(new Ball(x,y,direction));
		}
	}
	
	
	
	
	
}
