package model;

import org.dyn4j.geometry.Vector2;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
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
	
	protected double radius;
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
		
		this.draw();
	}
	public void move() {
		checkFrame();
		checkCollision();
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
		Holder.getInstance().getGameStage().getChildren().remove(canvas);
		
	}
	
	public void collect() {
		if(Holder.getInstance().getShooter().newX == -1 && Holder.getInstance().getShooter().newY == -1) {
			Holder.getInstance().getShooter().newX = x;
			Holder.getInstance().getShooter().newY = y;
		}
		else {
			this.direction = (x < Holder.getInstance().getShooter().newX)? new Vector2().right(): new Vector2().left();
		}
		destroy();
			
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		canvas = new Canvas(radius*2, radius*2);
		canvas.setTranslateX(x - radius);
		canvas.setTranslateY(y - radius);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(BALL_COLOR);
		

//		gc.fillOval(xx, yy, radius, radius);
		gc.fillOval(0, 0, 2*radius, 2*radius);
	}
	
	

	@Override
	public void onCollision(CollidableEntity other) {
		// TODO Auto-generated method stub
		if(other instanceof Block == false) return;
		
		int ballLeft = (int) this.getRect().getMinX();
        int ballHeight = (int) this.getRect().getHeight();
        int ballWidth = (int) this.getRect().getWidth();
        int ballTop = (int) this.getRect().getMinY();
//        System.out.println(ballLeft + " " + ballHeight + " " + ballWidth + " " + ballTop);
        Point2D PointRight = new Point2D(ballLeft + ballWidth + 1, ballTop);
        Point2D PointLeft = new Point2D(ballLeft - 1, ballTop);
        Point2D PointTop = new Point2D(ballLeft, ballTop - 1);
        Point2D PointBottom = new Point2D(ballLeft, ballTop + ballHeight + 1);
        System.out.print("Bounce!! ");
        if (!other.isDestroyed()) {
        	System.out.println("Checking");
            if (other.getRect().contains(PointRight)) {
//                ball.setXDir(-1);
                direction.x = -1;

                System.out.println("Right");
            } else if (other.getRect().contains(PointLeft)) {
//                ball.setXDir(1);
            	direction.x = 1;

            	System.out.println("Left");
            }

            if (other.getRect().contains(PointTop)) {
//                ball.setYDir(1);
            	direction.y = 1;
            	System.out.println("Top");
            } else if (other.getRect().contains(PointBottom)) {
//                ball.setYDir(-1);
                direction.y = -1;
                System.out.println("Bottom");
            }

        
        }
		
	}
	public void checkCollision() {
		for(Block e : Holder.getInstance().getBlockContainer()) {
			if(e.getRect().intersects(this.getRect())) {
				System.out.println("hit!!");
				onCollision(e);
				e.onCollision(this);
			}
				
		}
	}
	public void checkFrame() {
		if(y + radius >= GameStage.GAME_HEIGHT) {
			collect();
		}
		if(y - radius <= 0) direction.y *= -1;
		if(x - radius <=0 || x + radius >= GameStage.GAME_WIDTH) direction.x *= -1;

	}
	
	
	public void print() {
		System.out.println(x + "," +y);
	}

	@Override
	public Rectangle2D getRect() {
		// TODO Auto-generated method stub
		return new Rectangle2D(x-radius, y-radius, 2*radius, 2*radius);
	}
	
	
	
}
