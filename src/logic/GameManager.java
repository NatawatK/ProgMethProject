package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.AnimationTimer;
import model.Ball;
import model.Block;
import model.Entity;
import scene.GameStage;

public class GameManager {
	
	public enum GameState{
		Aim, Shoot, Move, LvlUp;
	}
	private final static int BLOCKS_PER_ROW = 7;
	private final static double BLOCK_SPAWN_RATE = 65;
	public final static double BLOCK_SIZE = GameStage.GAME_WIDTH/BLOCKS_PER_ROW;
	
	public final static double START_X = GameStage.GAME_WIDTH/2;
	public final static double START_Y = GameStage.GAME_HEIGHT - 20;
	
	private final static long FPS = 60;
	private final static long LOOP_TIME = 1000000000/FPS;
	
	private static long startTime;
	
	protected static GameState nowState ;
	
	public static void startGame() {
		spawnBlocks();
		Holder.getInstance().setup();
		nowState = GameState.Shoot;
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
		
		if(nowState == GameState.Aim) {
			
		}
		if(nowState == GameState.Shoot) {
			ballUpdate();
//			if(Holder.getInstance().getBallHolder().size() <= 0)
//				nowState = GameState.Move;
		}
		if(nowState == GameState.Move) {
			Holder.getInstance().getShooter().move();
		}
		if(nowState == GameState.LvlUp) {
			blocksDown();
			spawnBlocks();
			setState(GameState.Shoot);
		}
	}
	
	public static void ballUpdate() {
		Holder.getInstance().ballContainer.removeIf(e -> {
			return e.isDestroyed();
		});

		for(Ball e : Holder.getInstance().ballContainer) {
			e.move();
		}
	}
	
	public static void setState(GameState state) {
		GameManager.nowState = state;
	}
	
	public static void spawnBlocks() {
		for(int i = 0 ;i< BLOCKS_PER_ROW; i++) {
			if(new Random().nextDouble()*100 <= BLOCK_SPAWN_RATE)
				Holder.getInstance().add(new Block(BLOCK_SIZE*i, 100 ,BLOCK_SIZE ,BLOCK_SIZE));
		}
	}
	
	public static void blocksDown() {
		for(Block e : Holder.getInstance().getBlockContainer())
			e.down();
	}
}
