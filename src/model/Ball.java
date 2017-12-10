package model;

import java.util.Random;

import org.dyn4j.geometry.Vector2;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import logic.GameManager;
import logic.Holder;
import model.powerUp.PowerUp;
import scene.GameStage;

public class Ball extends CollidableEntity implements Movable{
	
	final static double INIT_SPEED = 10;
	final static Paint BALL_COLOR = Color.WHITE;
	final static double INIT_RADIUS = 5;
	
	protected double radius;
	private Vector2 direction;
	private double speed;
	private boolean retrieved; 
	
	public Ball(double x, double y , Vector2 direction) {
		this.speed = INIT_SPEED;
		this.radius = INIT_RADIUS;
		this.x = x;
		this.y = y;
		this.direction = direction.getNormalized();
		this.draw();
//		System.out.println("Ball Added!");
	}
	public void move() {
		checkFrame();
		if(!retrieved) checkCollision();
		this.x += direction.x*speed; 
		this.y += direction.y*speed;
		
		canvas.setTranslateX(x);
		canvas.setTranslateY(y);
//		System.out.println("Moving");
//		print();
	
	}
	public void down() {
		this.retrieved = true;
		this.speed *= 4;
		this.direction = new Vector2(0,1);
	}
	
	public void destroy() {
		this.speed = 0;
		this.destroy = true;
		Holder.getInstance().getGameStage().getChildren().remove(canvas);
//		System.out.print("*");
	}
	
	public void collect() {
		
		destroy();
			
	}
	@Override
	public void draw() {
		canvas = new Canvas(radius*2, radius*2);
		canvas.setTranslateX(x - radius);
		canvas.setTranslateY(y - radius);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(BALL_COLOR);

		gc.fillOval(0, 0, 2*radius, 2*radius);
	}
	
	

	@Override
	public void onCollision(CollidableEntity other) {
		// TODO Auto-generated method stub
		if(other instanceof Block) {
			int ballLeft = (int) this.getRect().getMinX();
	        int ballHeight = (int) this.getRect().getHeight();
	        int ballWidth = (int) this.getRect().getWidth();
	        int ballTop = (int) this.getRect().getMinY();

	        Point2D PointRight = new Point2D(ballLeft + ballWidth + 1, ballTop);
	        Point2D PointLeft = new Point2D(ballLeft - 1, ballTop);
	        Point2D PointTop = new Point2D(ballLeft, ballTop - 1);
	        Point2D PointBottom = new Point2D(ballLeft, ballTop + ballHeight + 1);

	        if (!other.isDestroyed()) {
	            if (other.getRect().contains(PointRight)) {
	//                ball.setXDir(-1);
	                	direction.x = Math.abs(direction.x)*-1;
	//                direction.x *= -1;
//	                System.out.println("Right");
	            } else if (other.getRect().contains(PointLeft)) {
	//                ball.setXDir(1);
	            		direction.x = Math.abs(direction.x);
	//            	direction.x *= -1;
//	            	System.out.println("Left");
	            }
	
	            if (other.getRect().contains(PointTop)) {
	//                ball.setYDir(1);
	            	direction.y = Math.abs(direction.y);
//	            	System.out.println("Top");
	            } else if (other.getRect().contains(PointBottom)) {
	//                ball.setYDir(-1);
	                direction.y = Math.abs(direction.y)*-1;
//	                System.out.println("Bottom");
	            }     
	        }
		}
		
		
		
	}
	public void checkCollision() {
		for(Block e : Holder.getInstance().getBlockContainer()) {
			if(e.isDestroyed()) continue;
			if(e.getRect().intersects(this.getRect())) {
				onCollision(e);
				e.onCollision(this);
			}		
		}
		for(PowerUp e: Holder.getInstance().getPowerUpContainer()) {
			if(e.isDestroyed()) continue;
			if(e.getRect().intersects(this.getRect())) {
//				System.out.println("Hit " + e.getClass());
				onCollision(e);
				e.onCollision(this);
			}
		}
	}
	public void checkFrame() {
		if(y > GameManager.START_Y) {
			destroy();
		}
		if(y - radius <= 0) {
			direction.y *= -1;
			y = radius;
		}
		if(x - radius <=0) {
			direction.x *= -1;
			x = radius;
		}
		if(x + radius >= GameStage.GAME_WIDTH) {
			direction.x *= -1;
			x = GameStage.GAME_WIDTH - radius;
		}

	}
	
	
	public void print() {
		System.out.println(x + "," +y);
	}

	@Override
	public Rectangle2D getRect() {
		// TODO Auto-generated method stub
		return new Rectangle2D(x-radius, y-radius, 2*radius, 2*radius);
	}
	
	public void randomDirection() {
		float x = new Random().nextFloat() - 0.5f;
		float y = new Random().nextFloat() - 0.1f ;
		direction = new Vector2(x,y);
		direction.normalize();
	}
	
	
}
