package logic;

import java.util.ArrayList;
import java.util.List;

import model.Ball;
import model.Entity;
import model.ShootPath;
import model.Shooter;
import scene.GameStage;


public class Holder {
	
	private static final Holder instance = new Holder();
	
	protected Shooter shooter;
	protected GameStage gameStage;
	protected List<Ball> ballHolder;
	
	
	public Holder() {
		this.gameStage = new GameStage();
		this.shooter = new Shooter();
		ballHolder = new ArrayList<Ball>();
		
	}
	
	public static Holder getInstance () {
		return instance;
	}
	
	public void add(Entity entity) {
		if(entity instanceof Ball) {
			ballHolder.add((Ball)entity);
			gameStage.getChildren().add(entity.canvas);
			System.out.println("Ball added  " + System.nanoTime());
		}
	}
	
	public void remove(Entity entity) {
		if(entity instanceof Ball) {
			ballHolder.remove(entity);
		}
	}

	public Shooter getShooter() {
		return shooter;
	}

	public GameStage getGameStage() {
		return gameStage;
	}

	public List<Ball> getBallHolder() {
		return ballHolder;
	}
	
	

	
	
	
	
	
}
