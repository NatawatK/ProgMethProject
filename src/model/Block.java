package model;

import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import logic.GameManager;
import logic.Holder;
import scene.ResLoader;

public class Block extends CollidableEntity implements Movable{
	
	private static final Font font = new Font("res/font/spacebar.ttf",20);
	private int life;
	
	private double width;
	private double height;
	
	protected Image img;
	protected AudioClip bounceSound, destroySound;
	
	public Block(double x, double y, double width, double height, int life) {
		this.life = life;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.img = ResLoader.BlockImg;
		this.bounceSound = ResLoader.bounceBlockSound;
		this.destroySound = ResLoader.bangSound;
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
		// TODO Auto-generated method stub
		canvas.setTranslateX(x);
		canvas.setTranslateY(y);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		/***********************************/
		if(life<3) img = ResLoader.BlockRed;
		else if(life<6) img = ResLoader.BlockPurple;
		else img = ResLoader.BlockBlue;
		gc.drawImage(img, 0, 0, width, height);
		/***********************************/
//		gc.drawImage(ResLoader.BlockImg, 0, 0, width, height);//delete this line
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
		// TODO Auto-generated method stub
		/*******new animation**********
		if(!isDestroyed()) {
			Holder.getInstance().getAnimation().drawBomb((int)x, (int)y);
			System.out.println(this.toString() + "  " + "Play animation");
		}
		/******************************/
		
		/***********************************/
		if(!isDestroyed()) {
			ResLoader.bangSound.play();
			ImageView iv = new ImageView();
			Image i = new Image(ClassLoader.getSystemResource("img/newBomb.gif").toString());
			iv.setImage(i);
			iv.setFitHeight((double) GameManager.GRID_SIZE);
			iv.setFitWidth((double) GameManager.GRID_SIZE);
			iv.setTranslateX(x);
			iv.setTranslateY(y);
			Holder.getInstance().getGameStage().getChildren().add(iv);
		}
		/***********************************/
		this.destroy = true;
//		destroySound.play();
		Holder.getInstance().getGameStage().getChildren().remove(canvas);
		
	}
	
	@Override
	public void onCollision(CollidableEntity other) {
		// TODO Auto-generated method stub
		if(other instanceof Ball) decreaseLife();
//		bounceSound.play();
		ResLoader.bounceBlockSound.play();
	}
	public double getBottom() {
		return this.y+this.height;
	}

}
