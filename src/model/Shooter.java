package model;

import org.dyn4j.geometry.Vector2;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.GameManager;
import logic.Holder;
import scene.GameStage;

public class Shooter extends Entity implements Movable{
	
	
	protected int maxBall;	
	
	final static double SPEED = 10;
	
	public Shooter() {
		this.maxBall = 10;
		this.x = GameManager.START_X;
		this.y = GameManager.START_Y;
		canvas = new Canvas(GameStage.GAME_WIDTH, GameStage.GAME_HEIGHT);
		Holder.getInstance().getGameStage().getChildren().add(canvas);
		draw();
		System.out.println(this.getClass().getName());
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.RED);
		gc.fillRect(x-5, y-5, 10, 10);
		
		System.out.println("Shooter Canvas Add!! " + x + " " + y);
	}
	public void shoot() {
		
		Vector2 direction = Holder.getInstance().getAimLine().getVector();
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
	
	
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
