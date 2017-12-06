package model;

import org.dyn4j.geometry.Ray;
import org.dyn4j.geometry.Vector2;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Pair;
import logic.GameManager;
import logic.Holder;
import scene.GameStage;

public class Shooter extends Entity implements Movable{
	
	static final long COOLDOWN = 100000000;
	protected int maxBall;
	protected double newX, newY;
	protected long cooldownTimer;
	
	
	protected Ray shootRay;
	
	final static double SPEED = 10;
	
	public Shooter() {
		this.maxBall = 10;
		this.x = GameStage.GAME_WIDTH / 2;
		this.y = GameStage.GAME_HEIGHT - 10;
		this.newX = -1;
		this.newY = -1;
		this.cooldownTimer = 0;
		canvas = new Canvas(100, 100);
		draw();
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.RED);
		gc.fillRect(x-10, y-10, 20, 20);
		Holder.getInstance().getGameStage().getChildren().add(canvas);
	}
	public void shoot(Vector2 direction) {
		newX = newY = -1;
		
		new Thread(() -> {
			int nowBall = 0;
			while(nowBall < maxBall) {
				Platform.runLater(() -> Holder.getInstance().add(new Ball(x , y, direction)));
				nowBall++;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
	}
	public void aim() {
		
	}
	public void move() {
		if(x != newX)
			x += (x < newX)? SPEED : -SPEED ;
		if(y != newY)
			y += (y< newY)? SPEED : -SPEED ;
	}
	
	
	
	
	
	
	
}
