package model;

import org.dyn4j.geometry.Vector2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import scene.GameStage;

public class Ball extends CollidableEntity{
	
	final static int INIT_SPEED = 10;
	final static Paint BALL_COLOR = Color.WHITE;
	final static double INIT_RADIUS = 10.0;
	
	private Vector2 direction;
	private int speed;
	
	public Ball() {
		this.speed = INIT_SPEED;
		this.radius = 10;
		this.x = GameStage.GAME_WIDTH /2;
		this.y = GameStage.GAME_HEIGHT - 100;
		this.direction = new Vector2(0,0);
	}
	
	public Ball(double x, double y , Vector2 direction) {
		this.speed = INIT_SPEED;
		this.radius = 10;
		this.x = x;
		this.y = y;
		this.direction = direction.getNormalized();
	}
	public void move() {
		this.x += direction.x*speed; 
		this.y += direction.y*speed;
		checkFrame();
	}
	
	public void destroy() {
		this.speed = 0;
		this.destroy = true;
		this.visible = false;
		
	}
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(BALL_COLOR);
		double xx = x-(radius/2); //set center;
		double yy = y-(radius/2);
		gc.fillOval(xx, yy, radius, radius);
	}

	@Override
	public void onCollision() {
		// TODO Auto-generated method stub
		
	}
	
	public void checkFrame() {
		if(y - radius > GameStage.GAME_HEIGHT) {
			System.out.println("STOP");
			this.destroy();
		}
		if(y - radius < 0) direction.y *= -1;
		if(x - radius <0 || x - radius > GameStage.GAME_WIDTH) direction.x *= -1;
	}
	
	public void print() {
		System.out.println(x + "," +y);
	}
	
	
	
}
