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
	private static final int COOLTIME = 100;
	
	private final static double SPEED = 10;
	
	private int maxBall, nowBall;	
	private boolean finishShoot;
	
	public Shooter() {
		this.maxBall = 1;
		this.nowBall = maxBall;
		this.x = GameManager.START_X;
		this.y = GameManager.START_Y;
		canvas = new Canvas(GameStage.GAME_WIDTH, GameStage.GAME_HEIGHT);
		Holder.getInstance().getGameStage().getChildren().add(canvas);
		draw();
//		System.out.println(this.getClass().getName());
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, GameStage.GAME_WIDTH, GameStage.GAME_HEIGHT);
		gc.setFill(Color.RED);
		gc.fillRect(x-5, y-5, 10, 10);
		gc.fillText("x"+nowBall, x+10 , y);
//		System.out.println("Shooter Canvas Add!! " + x + " " + y);
	}
	public void shoot() {
		nowBall = maxBall;
		finishShoot = false;
		Vector2 direction = Holder.getInstance().getAimLine().getVector();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(nowBall > 0) {
					Platform.runLater(() -> Holder.getInstance().add(new Ball(x , y, direction)));
					nowBall--;
					draw();
					try {
						Thread.sleep(COOLTIME);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		finishShoot = true;
	}
	
	public void retrieve() {
		for(Ball e : Holder.getInstance().getBallContainer())
			e.down();
		System.out.println("Retrieve!!");
	}
	
	public void increaseMaxBall() {
		this.maxBall ++;
		System.out.println("Now maxBall is "+maxBall);
	}
	
	public boolean isFinishShoot() {
		return finishShoot;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void move() {
		// TODO Auto-generated method stub
		nowBall = maxBall; 
		draw();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
