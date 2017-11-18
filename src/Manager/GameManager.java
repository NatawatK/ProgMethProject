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
		gameObjectsContainer = new ArrayList<Entity>();
	}
	
	
	public void addObject(Entity entity) {
		/*
		 * you already know this
		 */
		gameObjectsContainer.add(entity);
	}
	
	public void update() {
		/*
		 * update entity if they were destroy (also visibility)
		 */
		for(Entity entity : gameObjectsContainer) {
			if(entity.isDestroyed()) {
				
			}
		}
	}
	
	public void pause() { //optional
	}
}
