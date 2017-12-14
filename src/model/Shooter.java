package model;


import org.dyn4j.geometry.Vector2;

import exception.RetrieveException;
import exception.ShootException;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.GameManager;
import logic.GameManager.GameState;
import logic.Holder;
import scene.GameStage;
import scene.ResLoader;

public class Shooter extends Entity implements Movable{
	public enum ShooterState {
		shoot, finishShoot, move, wait; 
	}
	private ShooterState nowState;
	private static final int COOLTIME = 100;
	private static final double IMG_SIZE = 60;
	private final static double SPEED = 5;
	
	private int maxBall, nowBall;	

	private Canvas spaceCraftCanvas; 
	
	
	public Shooter() {
		this.maxBall = 1;
		this.nowBall = maxBall;
		this.x = GameManager.START_X;
		this.y = GameManager.START_Y;
		canvas = new Canvas(GameStage.GAME_WIDTH, GameStage.GAME_HEIGHT);
		canvas.setTranslateY(50);
		spaceCraftCanvas = new Canvas(IMG_SIZE, IMG_SIZE);
		Holder.getInstance().getGameStage().getChildren().add(canvas);
		Holder.getInstance().getGameStage().getChildren().add(spaceCraftCanvas);
		this.nowState = ShooterState.wait;
		draw();
	}
	@Override
	
	
	
	public void draw() {
		// TODO Auto-generated method stub
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.drawImage(ResLoader.GameBG, 0, 0, GameStage.GAME_WIDTH, GameStage.GAME_HEIGHT);
		gc.setFill(Color.RED);
//		gc.fillRect(x-5, y-55, 10, 10);
		
		gc.fillText("x"+nowBall, x+20 , y-50);
		drawSpaceCraft();
//		System.out.println("Shooter Canvas Add!! " + x + " " + y);
	}
	
	public void drawSpaceCraft() {
		GraphicsContext gc = spaceCraftCanvas.getGraphicsContext2D();
		spaceCraftCanvas.setTranslateX(x - IMG_SIZE/2);
		spaceCraftCanvas.setTranslateY(y - IMG_SIZE/2);
		gc.drawImage(ResLoader.SpaceCraftImg, 0, 0, spaceCraftCanvas.getWidth() , spaceCraftCanvas.getHeight());
		try{
			if(nowState != ShooterState.shoot)
				spaceCraftCanvas.setRotate(Holder.getInstance().getAimLine().getDegree()+90);
		}
		catch (NullPointerException e){
			spaceCraftCanvas.setRotate(0);
			System.out.println("Aim-line not created yet!");
		}
		
	}
	
	
	public void shoot() throws ShootException{
		if(GameManager.getCurrentState() != GameState.aim) 
			throw new ShootException();
		
		GameManager.stopPoint = -1;
		this.nowState = ShooterState.shoot;
		Vector2 direction = Holder.getInstance().getAimLine().getVector();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(nowBall > 0 && nowState == ShooterState.shoot) {
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
				nowState = ShooterState.finishShoot;
			}
		}).start();
		
		
	}
	
	public void retrieve() throws RetrieveException{
		if(nowState != ShooterState.shoot && nowState != ShooterState.finishShoot)
			throw new RetrieveException();
		this.nowState = ShooterState.finishShoot;
		for(Ball e : Holder.getInstance().getBallContainer()) 
			e.down();
	}
	
	public void increaseMaxBall() {
		this.maxBall++;
	}
	
	public ShooterState getState() {
		return nowState;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void move() {
		// TODO Auto-generated method stub
//		System.out.println("shooter : " +nowState);
		nowBall = maxBall;
		if(Math.abs(x - GameManager.stopPoint) <=  SPEED) {
			this.x = GameManager.stopPoint;
			Holder.getInstance().getAimLine().reCenter();
			nowState = ShooterState.wait;
		}
		else {
			nowState = ShooterState.move;
			this.x += SPEED * ((x < GameManager.stopPoint)? 1 : -1);
//			System.out.println(x + "   /  " + GameManager.stopPoint + "(" + Math.abs(x - GameManager.stopPoint) + ")");
			
		}
		draw();
	}
	
	public int getMaxBall() {
		return this.maxBall;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
