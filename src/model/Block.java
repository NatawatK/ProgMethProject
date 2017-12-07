package model;

import java.util.Random;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Block extends CollidableEntity{
	
	protected int life;
	
	protected double width;
	protected double height;
	
	protected Paint color;
	
	public Block(double x, double y, double width, double height) {
		this.life = new Random().nextInt(10);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = Color.GREENYELLOW;
		
		draw();
	}
	@Override
	public void onCollision(CollidableEntity other) {
		// TODO Auto-generated method stub
		if(other instanceof Ball) decreaseLife();
	}
	
	public void decreaseLife() {
		System.out.println("---------");
		this.life -= 1;
		if(this.life <= 0) this.destroy();
	}

	@Override
	protected void draw() {
		// TODO Auto-generated method stub
		canvas = new Canvas(width, height);
		canvas.setTranslateX(x);
		canvas.setTranslateY(y);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(color);
		gc.setStroke(color);
		gc.strokeRect(0, 0, width, height);
		gc.setFill(Color.WHITE);
		gc.fillText(""+life, 20, height/2);
	}
	@Override
	public Rectangle2D getRect() {
		// TODO Auto-generated method stub
		return new Rectangle2D(x, y, width, height);
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		this.destroy = true;
	}

}
