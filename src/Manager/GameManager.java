package Manager;

import java.util.List;

import Model.Entity;

public class GameManager {
	private List<Entity> gameObjectsContainer;
	
	private int timeLimit;
	private int timeSpawnObject;
	
	private double currentTime;
	
	public GameManager() {
		/*
		 * initialize 
		 */
	}
	
	
	public void addObject(Entity entity) {
		/*
		 * you already know this
		 */
	}
	
	public void update() {
		/*
		 * update entity if they were destroy (also visibility)
		 */
	}
	
	public void pause() { //optional
	}
}
