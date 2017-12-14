package model;

import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import logic.GameManager;
import logic.Holder;
import scene.ResLoader;

public class Block extends CollidableEntity implements Movable{
	
	private static final Font font = Font.font("Monospace", FontWeight.BOLD,20);
	private int life;
	private int startLife;
	
	private double width;
	private double height;
	
	protected Image img;
	
	public Block(double x, double y, double width, double height, int life) {
		this.life = life;
		this.startLife = life;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.img = ResLoader.BlockImg;
		canvas = new Canvas(width, height);
		draw();
	}
	
	public void decreaseLife() {
		this.life -= 1;
		if(this.life <= 0) this.destroy();
		draw();
	}
	
	public void move() {
		this.y += GameManager.GRID_SIZE;
		canvas.setTranslateY(y);
	}

	@Override
	protected void draw() {
		canvas.setTranslateX(x);
		canvas.setTranslateY(y);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		if(life<0.3*startLife) img = ResLoader.BlockRed;
		else if(life<0.6*startLife) img = ResLoader.BlockPurple;
		else img = ResLoader.BlockBlue;
		gc.drawImage(img, 0, 0, width, height);
		gc.setFill(Color.BLACK);
		gc.setFont(font);
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.CENTER);
		gc.fillText(""+life, width/2 , height/2);
	}
	
	@Override
	public Rectangle2D getRect() {
		return new Rectangle2D(x, y, width, height);
	}
	
	@Override
	public void destroy() {
		if(!isDestroyed()) {
			Holder.getInstance().getAnimation().drawBomb(x, y);
		}
		this.destroy = true;
		Holder.getInstance().getGameStage().getChildren().remove(canvas);
		
	}
	
	@Override
	public void onCollision(CollidableEntity other) {
		if(other instanceof Ball) decreaseLife();
		ResLoader.bounceBlockSound.play();
	}
	public double getBottom() {
		return this.y+this.height;
	}

}
