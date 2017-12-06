package logic;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import model.Ball;
import model.Entity;

public class GameManager {
	
	public enum GameState{
		Aim, Shoot, Move, LvlUp;
	}
	
	public final static long FPS = 120;
	final static long LOOP_TIME = 1000000000/FPS;
	
	private static long startTime;
	
	protected static GameState nowState ;
	
	public static void startGame() {
		nowState = GameState.Aim;
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
		}
		if(nowState == GameState.Move) {
		
		}
		if(nowState == GameState.LvlUp) {
			
		}
	}
	
	public static void ballUpdate() {
		Holder.getInstance().ballHolder.removeIf(e -> {
				return e.isDestroyed();
		});

		for(Ball e : Holder.getInstance().ballHolder) {
			e.move();
		}
	}
	public static void print() {
		System.out.println("Time  = " + System.nanoTime());
	}
}
