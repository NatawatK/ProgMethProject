package model;

import java.util.Random;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import logic.GameManager;
import logic.Holder;

public class Block extends CollidableEntity implements Movable{
	
	private static final Font font = new Font("res/font/spacebar.ttf",20);
	private static final double LINE_WIDTH = 3;
	protected int life;
	
	protected double width;
	protected double height;
	
	protected Paint color;
	
	public Block(double x, double y, double width, double height, int life) {
		this.life = life;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = Color.GREENYELLOW;
		canvas = new Canvas(width, height);
		
		draw();
	}
	@Override
	public void onCollision(CollidableEntity other) {
		// TODO Auto-generated method stub
		if(other instanceof Ball) decreaseLife();
	}
	
	public void decreaseLife() {
		this.life -= 1;
		if(this.life <= 0) this.destroy();
		draw();
	}
	
	public void move() {
		this.y += GameManager.BLOCK_SIZE;
		canvas.setTranslateY(y);
	}

	@Override
	protected void draw() {
		// TODO Auto-generated method stub
		canvas.setTranslateX(x);
		canvas.setTranslateY(y);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, width, height);
		
		gc.setStroke(color);
		gc.setLineWidth(LINE_WIDTH);
		gc.strokeRect(0, 0, width, height);
		
		gc.setFill(Color.WHITE);
		gc.setFont(font);
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
		Holder.getInstance().getGameStage().getChildren().remove(canvas);
	}
	
	public double getBottom() {
		return this.y+this.height;
	}

}
