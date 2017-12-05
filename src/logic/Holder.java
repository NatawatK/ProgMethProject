package logic;

import java.util.ArrayList;
import java.util.List;

import model.Ball;
import model.Entity;
import model.Shooter;


public class Holder {
	
	private static final Holder instance = new Holder();
	
	private Shooter shooter;
	
	private List ballHolder;
	
	
	public Holder() {
		this.shooter = new Shooter();
		ballHolder = new ArrayList<Ball>();
		
	}
	
	public static Holder getInstance () {
		return instance;
	}
	
	public void add(Entity entity) {
		if(entity instanceof Ball) {
			ballHolder.add(entity);
		}
	}
}
