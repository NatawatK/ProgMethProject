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
import scene.ResLoader;

public class Ball extends CollidableEntity implements Movable{
	
	private final static double INIT_SPEED = 10;
	private final static Paint BALL_COLOR = Color.WHITE;
	private final static double INIT_RADIUS = 5;
	
	protected double radius;
	private Vector2 direction;
	private double speed;
	private boolean retrieved; 
	
	public Ball(double x, double y , Vector2 direction) {
		this.speed = INIT_SPEED;
		this.radius = INIT_RADIUS;
		this.x = x;
		this.y = y;
		canvas = new Canvas(radius*2, radius*2);
		this.direction = direction.getNormalized();
		this.draw();
	}
	
	public void move() {
		this.x += direction.x*speed; 
		this.y += direction.y*speed;
		if(!retrieved) checkCollision();
		checkFrame();
		canvas.setTranslateX(x - radius);
		canvas.setTranslateY(y - radius);
//		System.out.println("Moving");
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
	}
	
	public void collect() {
<<<<<<< HEAD
		if(GameManager.stopPoint == -1){ //is first ball landed	
=======
		if(GameManager.stopPoint == -1) //is first ball landed
>>>>>>> 159751500d0efa0a1717de865e78087068b3e5bb
			GameManager.stopPoint = this.x;
		}
		else {
			if(Math.abs(this.x - GameManager.stopPoint) <= speed ) { //if this ball reach first ball
				destroy();
			}
			else {
				this.direction.x = (x < GameManager.stopPoint)? 1 : -1;
				System.out.println(this + "    /   "  + this.x + "    /  "   + GameManager.stopPoint);
			}
		}
<<<<<<< HEAD
=======
		/*
		 * BUG : first landed ball canvas is deleted!!???
		*/	
>>>>>>> 159751500d0efa0a1717de865e78087068b3e5bb
	}
	@Override
	public void draw() {	
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
	                	direction.x = Math.abs(direction.x)*-1;
//	                System.out.println("Right");
	            } else if (other.getRect().contains(PointLeft)) {
	            		direction.x = Math.abs(direction.x);
//	            	System.out.println("Left");
	            }
	
	            if (other.getRect().contains(PointTop)) {
	            	direction.y = Math.abs(direction.y);
//	            	System.out.println("Top");
	            } else if (other.getRect().contains(PointBottom)) {
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
				onCollision(e);
				e.onCollision(this);
			}
		}
	}
	public void checkFrame() {
		if(y > GameManager.START_Y) {
			this.y = GameManager.START_Y;
			canvas.setTranslateY(y-radius);
			collect();
		}
<<<<<<< HEAD
		if(y - radius <= 50) {
			direction.y = Math.abs(direction.y);
			y = radius+50;
=======
		if(y - radius <= 0) {
			direction.y = Math.abs(direction.y);
			y = radius;
>>>>>>> 159751500d0efa0a1717de865e78087068b3e5bb
			ResLoader.bounceWallSound.play();
		}
		if(x - radius <=0) {
			direction.x = Math.abs(direction.x);
			x = radius;
			ResLoader.bounceWallSound.play();
		}
		if(x + radius >= GameStage.GAME_WIDTH) {
			direction.x = -1* Math.abs(direction.x);
			x = GameStage.GAME_WIDTH - radius;
			ResLoader.bounceWallSound.play();
		}

	}

	@Override
	public Rectangle2D getRect() {
		return new Rectangle2D(x-radius, y-radius, 2*radius, 2*radius);
	}
	
	public void randomDirection() {
		float x = new Random().nextFloat() - 0.5f;
		float y = new Random().nextFloat()/-2 ;
		direction = new Vector2(x,y);
		direction.normalize();
	}
	
	
}
