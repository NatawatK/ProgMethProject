package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Ball;
import model.Block;
import model.Entity;
import model.Shooter;
import scene.GameStage;


public class Holder {
	
	private static Holder instance = new Holder();
	
	
	protected GameStage gameStage;
	protected Shooter shooter;
	protected List<Ball> ballContainer;
	protected List<Block> blockContainer;
	
	public Holder() {
		this.gameStage = new GameStage();
		ballContainer = new ArrayList<Ball>();
		blockContainer = new ArrayList<Block>();
	}
	
	public void setShooter(Shooter shooter) {
		this.shooter = shooter;
	}

	public static Holder getInstance () {
		return instance;
	}
	
	public void spawnBlocks() {
		int N_BLOCKS = 7;
		double blockSize = GameStage.GAME_WIDTH/N_BLOCKS;
		double SPAWN_RATE = 70;
		
		for(int i = 0 ;i<= N_BLOCKS; i++) {
			if(new Random().nextDouble()*100 <= SPAWN_RATE)
				this.add(new Block(blockSize*i, 100 ,blockSize ,blockSize));
		}
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
	
	

	
	
	
	
	
}
