package model.powerUp;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import logic.GameManager;
import logic.Holder;
import model.CollidableEntity;
import model.Movable;

public abstract class PowerUp extends CollidableEntity implements Movable{
	
	protected static final double radius = 10; 
	
	protected Paint color;
	protected boolean hitted;
	
	
	public PowerUp(double x, double y) {
		super();
		this.x = x;
		this.y = y;
		canvas = new Canvas(radius*2, radius*2);
		canvas.setTranslateX(x-radius);
		canvas.setTranslateY(y-radius);
	}

	@Override
	public Rectangle2D getRect() {
		// TODO Auto-generated method stub
		return new Rectangle2D(x-radius, y-radius, 2*radius, 2*radius);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		this.destroy = true;
		Holder.getInstance().getGameStage().getChildren().remove(canvas);
	}

	@Override
	protected void draw() {
		// TODO Auto-generated method stub
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(color);
		gc.fillOval(0, 0, 2*radius, 2*radius);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if(this.hitted) {
			destroy();
//			System.out.println("Hit and destroy");
		}
		else {
			y += GameManager.BLOCK_SIZE;
			canvas.setTranslateY(y-radius);
//			System.out.println("pwr move");
		}
	}
	
	

}
