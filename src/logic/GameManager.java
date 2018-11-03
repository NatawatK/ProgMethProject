package logic;

import java.util.Random;

import exception.MinDegreeExceedException;
import exception.RetrieveException;
import exception.ShootException;
import javafx.animation.AnimationTimer;
<<<<<<< HEAD
import javafx.scene.layout.Pane;
=======
>>>>>>> 159751500d0efa0a1717de865e78087068b3e5bb
import model.Ball;
import model.Block;
import model.Shooter.ShooterState;
import model.powerUp.*;
import scene.GameOver;
import scene.GameStage;
import scene.SceneManager;

public class GameManager {
	
	public enum GameState{
		aim, shoot, endShot, retrieve, move;
	}
	
	
	private final static int BLOCKS_PER_ROW = 7;
	public final static double GRID_SIZE = GameStage.GAME_WIDTH/BLOCKS_PER_ROW;
	private final static double BLOCK_SPAWN_RATE = 50;
	private final static double BLOCK_SIZE = GRID_SIZE -5;
	
	public final static double SPAWN_Y = 100;
	
	public final static double START_X = GameStage.GAME_WIDTH/2;
	public final static double START_Y = GameStage.GAME_HEIGHT - 50;
	
	public static double stopPoint;
	
	private final static long FPS = 60;
	private final static long LOOP_TIME = 1000000000/FPS;
	
	private static long startTime;
	private static AnimationTimer timer;
	
	private static GameState currentState ;
	private static int level;
	
	public static void startGame() {
		Holder.getInstance().setup();
		level = 1;
		spawnObjects();
		currentState = GameState.aim;
		
		startTime = System.nanoTime();
		timer = new AnimationTimer() {	
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				if(now - startTime > LOOP_TIME) {
					startTime += LOOP_TIME;
					update();
				}
			}
		};
		timer.start();
	}
	
	private static void update() {
		switch(currentState) {
			case aim :
//				System.out.println("aim");
				Holder.getInstance().getAimLine().setVisible(true);
				break;
			case shoot :
				Holder.getInstance().getAimLine().setVisible(false);
				ballUpdate();
//				System.out.println(stopPoint);
				break;
			case move :
				Holder.getInstance().getShooter().move();
//				System.out.println("GameState : move");
				if(Holder.getInstance().getShooter().getState() == ShooterState.wait)
					currentState = GameState.aim;
				break;
			case endShot :
				System.out.println("endshot");
				level++;
				objectsDown();
				spawnObjects();
<<<<<<< HEAD
				Holder.getInstance().getGameStage().redrawLevel(getLevel());
=======
>>>>>>> 159751500d0efa0a1717de865e78087068b3e5bb
				checkLose();
				currentState = GameState.move;
				break;
		}
	}
	

	private static void ballUpdate() {
		Holder.getInstance().getBallContainer().removeIf(e -> {
			return e.isDestroyed();
		});
		for(Ball e : Holder.getInstance().getBallContainer()) {
			e.move();
		}
		if(Holder.getInstance().getShooter().getState() == ShooterState.finishShoot && Holder.getInstance().getBallContainer().size() <= 0) 
			currentState = GameState.endShot;
	}
	
	public static void shoot() {
		try {
			Holder.getInstance().getShooter().shoot();
			currentState = GameState.shoot;
		}
		catch (ShootException e) {
			// TODO: handle exception
			System.out.println(e.getErrorMessage());
		}
		
<<<<<<< HEAD
	}
	
	public static void retrieve() {
		try {
			Holder.getInstance().getShooter().retrieve();
		}
		catch (RetrieveException e) {
			// TODO: handle exception
			System.out.println(e.getErrorMessage());
		}
		
	}
	
=======
	}
	
	public static void retrieve() {
		try {
			Holder.getInstance().getShooter().retrieve();
		}
		catch (RetrieveException e) {
			// TODO: handle exception
			System.out.println(e.getErrorMessage());
		}
		
	}
	
>>>>>>> 159751500d0efa0a1717de865e78087068b3e5bb
	public static void aim(double x, double y) {
		try {
			Holder.getInstance().getAimLine().aimTo(x, y);
		}
		catch (MinDegreeExceedException e) {
			// TODO: handle exception
			System.out.println(e.getError());
		}
		
	}

	private static void spawnObjects() {
		for(int i = 0 ;i< BLOCKS_PER_ROW; i++) {
			double rate = new Random().nextDouble()*100;
			if(rate <= BLOCK_SPAWN_RATE)
				Holder.getInstance().add(new Block(GRID_SIZE*i + (GRID_SIZE-BLOCK_SIZE)/2, SPAWN_Y + (GRID_SIZE-BLOCK_SIZE)/2 ,BLOCK_SIZE ,BLOCK_SIZE, level));
			else if(rate <= 60)
				Holder.getInstance().add(new BallPlus(GRID_SIZE*i + GRID_SIZE/2, SPAWN_Y + GRID_SIZE/2));
			else if(rate <= 65)
				Holder.getInstance().add(new VLightning(GRID_SIZE*i + GRID_SIZE/2, SPAWN_Y + GRID_SIZE/2));
			else if(rate <= 70)
				Holder.getInstance().add(new HLightning(GRID_SIZE*i + GRID_SIZE/2, SPAWN_Y + GRID_SIZE/2));
			else if(rate <= 75)
				Holder.getInstance().add(new RandomReflector(GRID_SIZE*i + GRID_SIZE/2, SPAWN_Y + GRID_SIZE/2));
		}
	}
	
	private static void objectsDown() {
		Holder.getInstance().clearObject();
		for(Block e : Holder.getInstance().getBlockContainer())
			e.move();
		for(PowerUp e : Holder.getInstance().getPowerUpContainer())
			e.move();	
	}

	public static GameState getCurrentState() {
		return currentState;
	}
	
	private static void checkLose() {
		for( Block e : Holder.getInstance().getBlockContainer()) {
			if(e.getBottom() >= GameStage.LOSE_LINE) {
				gameOver();
				return;
			}
		}
	}
	
	private static void gameOver() {
		timer.stop();
<<<<<<< HEAD
		Pane gameOver = new GameOver(getLevel(),getMaxBall());
		Holder.getInstance().reset();
		SceneManager.gotoSceneOf(gameOver);
=======
		Holder.getInstance().reset();
		SceneManager.gotoSceneOf(new GameOver());
>>>>>>> 159751500d0efa0a1717de865e78087068b3e5bb
	}
	
	public static int getLevel() {
		return level;
	}
<<<<<<< HEAD
=======
	
	public static int getMaxBall() {
		return Holder.getInstance().getShooter().getMaxBall();
	}
>>>>>>> 159751500d0efa0a1717de865e78087068b3e5bb
	
	public static int getMaxBall() {
		return Holder.getInstance().getShooter().getMaxBall();
	}
}
