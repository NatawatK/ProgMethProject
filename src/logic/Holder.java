package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.AimLine;
import model.Ball;
import model.Block;
import model.Entity;
import model.Movable;
import model.Shooter;
import model.powerUp.PowerUp;
import scene.Animation;
import scene.GameStage;


public class Holder {
	
	private static Holder instance = new Holder();
	
	
	protected GameStage gameStage;
	protected Animation animation;
	
	protected List<Ball> ballContainer;
	protected List<Block> blockContainer;
	protected List<PowerUp> powerUpContainer;
	
	private Shooter shooter;
	private AimLine aimLine;
	
	
	public Holder() {
		this.gameStage = new GameStage();
		ballContainer = new ArrayList<>();
		blockContainer = new ArrayList<>();
		powerUpContainer = new ArrayList<>();
		animation = new Animation();
	}
	
	public static Holder getInstance () {
		return instance;
	}
	
	public void setup() {
		shooter = new Shooter();
		aimLine = new AimLine();
		gameStage.getChildren().add(animation);
	}

	
	

	public void add(Entity entity) {
		if(entity instanceof Ball) {
			Holder.getInstance().ballContainer.add((Ball)entity);
			Holder.getInstance().gameStage.getChildren().add(entity.canvas);
//			System.out.println("Ball added  " + System.nanoTime());
		}
		if(entity instanceof Block) {
			blockContainer.add((Block)entity);
			gameStage.getChildren().add(entity.canvas);
//			System.out.println("Block added  " + System.nanoTime());
		}
		
		if(entity instanceof PowerUp) {
			powerUpContainer.add((PowerUp)entity);
			gameStage.getChildren().add(entity.canvas);
//			System.out.println("PowerUp added  " + System.nanoTime());
		}
	}
	
	public void clearObject() {
		ballContainer.removeIf(e -> { return e.isDestroyed(); });
		blockContainer.removeIf(e -> { return e.isDestroyed(); });
		powerUpContainer.removeIf(e ->{ return e.isDestroyed(); } );
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

	public List<PowerUp> getPowerUpContainer() {
		return powerUpContainer;
	}

	public Animation getAnimation() {
		return animation;
	}
	
	
	
	
	
	
}
