package model.weapon;

import javafx.scene.canvas.GraphicsContext;

public class Bomb extends Weapon {

	protected int bombLeft, bombLenght, maxBomb;
	
	public Bomb() {
		this.maxBomb = 3;
		this.bombLeft = this.maxBomb;
		this.bombLenght = 1;
	}
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void launch() {
		// TODO Auto-generated method stub

	}

	@Override
	public void boom() {
		// TODO Auto-generated method stub
		
		
	}
	
}
