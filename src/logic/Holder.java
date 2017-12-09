package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.AimLine;
import model.Ball;
import model.Block;
import model.Entity;
import model.Shooter;
import scene.GameStage;


public class Holder {
	
	private static Holder instance = new Holder();
	
	
	protected GameStage gameStage;
	
	protected List<Ball> ballContainer;
	protected List<Block> blockContainer;
	
	
	private Shooter shooter;
	private AimLine aimLine;
	
	
	public Holder() {
		this.gameStage = new GameStage();
		ballContainer = new ArrayList<Ball>();
		blockContainer = new ArrayList<Block>();
	}
	
	public static Holder getInstance () {
		return instance;
	}
	
	public void setup() {
		shooter = new Shooter();
		aimLine = new AimLine();
		
	}

	
	public void add(Entity entity) {
		if(entity instanceof Ball) {
			Holder.getInstance().ballContainer.add((Ball)entity);
			Holder.getInstance().gameStage.getChildren().add(entity.canvas);
			System.out.println("Ball added  " + System.nanoTime());
		}
		if(entity instanceof Block) {
			blockContainer.add((Block)entity);
			gameStage.getChildren().add(entity.canvas);
			System.out.println("Block added  " + System.nanoTime());
		}
	}
	
	
	
	public void remove(Entity entity) {
		if(entity instanceof Ball) {
			ballContainer.remove(entity);
		}
	}

	public Shooter getShooter() {
		return shooter;
	}

	public GameStage getGameStage() {
		return gameStage;
	}

	public List<Ball> getBallContainer() {
		return ballContainer;
	}

	public List<Block> getBlockContainer() {
		return blockContainer;
	}

	public AimLine getAimLine() {
		return aimLine;
	}

	
	

	
	
	

	
	
	
	
	
}
