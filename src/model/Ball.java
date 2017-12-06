package model;

import org.dyn4j.geometry.Vector2;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import logic.Holder;
import scene.GameStage;

public class Ball extends CollidableEntity implements Movable{
	
	final static double INIT_SPEED = 10;
	final static Paint BALL_COLOR = Color.WHITE;
	final static double INIT_RADIUS = 5.0;
	
	private Vector2 direction;
	private double speed;
	
	public Ball() {
		this.speed = INIT_SPEED;
		this.radius = INIT_RADIUS;
		this.x = GameStage.GAME_WIDTH /2;
		this.y = GameStage.GAME_HEIGHT - 100;
		this.direction = new Vector2(0,0);
		draw();
	}
	
	public Ball(double x, double y , Vector2 direction) {
		
		this.speed = INIT_SPEED;
		this.radius = INIT_RADIUS;
		this.x = x;
		this.y = y;
		this.direction = direction.getNormalized();
		canvas = new Canvas(radius+50, radius+50);
		this.draw();
	}
	public void move() {
		checkFrame();
		this.x += direction.x*speed; 
		this.y += direction.y*speed;
		
		canvas.setTranslateX(x);
		canvas.setTranslateY(y);
//		System.out.println("Moving");
//		print();
	
	}
	public void down() {
		this.speed *= 4;
		this.direction = new Vector2(0,1);
	}
	
	public void destroy() {
		this.speed = 0;
		this.destroy = true;
		this.visible = false;
		Holder.getInstance().getGameStage().getChildren().remove(canvas);
		
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		canvas.setTranslateX(x - radius);
		canvas.setTranslateY(y - radius);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(BALL_COLOR);
		

//		gc.fillOval(xx, yy, radius, radius);
		gc.fillOval(0, 0, 2*radius, 2*radius);
	}
	
	

	@Override
	public void onCollision() {
		// TODO Auto-generated method stub
		
	}
	
	public void checkFrame() {
		if(y + radius > GameStage.GAME_HEIGHT) {
			System.out.println("STOP");
			this.destroy();
			
		}

		if(y - radius <= 0) direction.y *= -1;
		if(x - radius <=0 || x + radius >= GameStage.GAME_WIDTH) direction.x *= -1;

	}
	
	public void print() {
		System.out.println(x + "," +y);
	}
	
	
	
}
