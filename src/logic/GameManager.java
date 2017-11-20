package logic;

import java.util.ArrayList;
import java.util.List;

import model.Entity;

public class GameManager {
	private List<Entity> gameObjectsContainer;
	
	private int timeLimit;
	private int timeSpawnObject;
	
	private long currentTime;
	
	public GameManager() {
		gameObjectsContainer = new ArrayList<Entity>();
	}
	
	
	
	public void pause() { //optional
	}
}
