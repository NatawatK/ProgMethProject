package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import model.Ball;
import model.Block;
import model.Entity;
import model.Movable;
import model.powerUp.*;
import scene.GameStage;

public class GameManager {
	
	public enum GameState{
		aim, shoot, wait, endShot;
	}
	private final static int BLOCKS_PER_ROW = 7;
	private final static double BLOCK_SPAWN_RATE = 50;
	public final static double BLOCK_SIZE = GameStage.GAME_WIDTH/BLOCKS_PER_ROW;
	
	public final static double START_X = GameStage.GAME_WIDTH/2;
	public final static double START_Y = GameStage.GAME_HEIGHT - 20;
	
	
	private final static long FPS = 60;
	private final static long LOOP_TIME = 1000000000/FPS;
	
	private static long startTime;
	
	protected static GameState currentState ;
	protected static int Level;
	public static void startGame() {
		Holder.getInstance().setup();
		Level = 1;
		spawnBlocks();
		currentState = GameState.aim;
		
		
		startTime = System.nanoTime();
		AnimationTimer timer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				if(now - startTime > LOOP_TIME) {
					startTime += LOOP_TIME;
					update();
					//print();
				}
				
			}
		};
		timer.start();
	}
	
	public static void update() {
		switch(currentState) {
			case aim :
				
				break;
			case shoot :
				ballUpdate();
				break;
			case wait :
				break;
			case endShot :
				Level++;
				blocksDown();
				spawnBlocks();
				checkLose();
				currentState = GameState.aim;
				System.out.println("Ball plus is map : " + Holder.getInstance().getPowerUpContainer().size());
				break;
				
		}
	}
	
	public static void ballUpdate() {
		Holder.getInstance().ballContainer.removeIf(e -> {
			return e.isDestroyed();
		});
		for(Ball e : Holder.getInstance().ballContainer) {
			e.move();
		}
		if(Holder.getInstance().getBallContainer().size() <= 0) 
			currentState = GameState.endShot;
	}
	
	public static void shoot() {
		Holder.getInstance().getShooter().shoot();
		currentState = GameState.shoot;
	}
	
	public static void setCurrentState(GameState currentState) {
		GameManager.currentState = currentState;
	}

	public static void spawnBlocks() {
		for(int i = 0 ;i< BLOCKS_PER_ROW; i++) {
			double rate = new Random().nextDouble()*100;
			if(rate <= BLOCK_SPAWN_RATE)
				Holder.getInstance().add(new Block(BLOCK_SIZE*i, 100 ,BLOCK_SIZE ,BLOCK_SIZE, Level));
			else if(rate <= 60)
				Holder.getInstance().add(new BallPlus(BLOCK_SIZE*i + 20, 100+20));
			else if(rate <= 70)
				Holder.getInstance().add(new VLightning(BLOCK_SIZE*i + 20, 100+20));
			else if(rate <= 80)
				Holder.getInstance().add(new HLightning(BLOCK_SIZE*i + 20, 100+20));
			else if(rate <= 90)
				Holder.getInstance().add(new RandomReflector(BLOCK_SIZE*i + 20, 100+20));
		}
	}
	
	public static void blocksDown() {
		Holder.getInstance().clearObject();
		for(Block e : Holder.getInstance().getBlockContainer())
			e.move();
		for(PowerUp e : Holder.getInstance().getPowerUpContainer())
			e.move();
		
	}

	public static GameState getCurrentState() {
		return currentState;
	}
	
	public static void checkLose() {
		for( Block e : Holder.getInstance().getBlockContainer()) {
			if(e.getBottom() >= GameStage.LOSE_LINE)
				Platform.exit();
			
		}
	}
	
	
}
