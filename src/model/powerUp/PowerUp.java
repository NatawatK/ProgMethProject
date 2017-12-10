package model.powerUp;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import logic.GameManager;
import logic.Holder;
import model.CollidableEntity;
import model.Movable;
import scene.GameStage;

public abstract class PowerUp extends CollidableEntity implements Movable{
	
	protected static final double DEFAULT_RADIUS = 15; 
	
	protected double radius;
	protected Paint color;
	protected Image img;
	protected boolean hitted;
	
	
	public PowerUp(double x, double y) {
		super();
		this.x = x;
		this.y = y;
		this.radius = DEFAULT_RADIUS;
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
		gc.drawImage(img, 0, 0, canvas.getWidth(), canvas.getHeight());
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if(this.hitted) {
			destroy();
//			System.out.println("Hit and destroy");
		}
		else {
			y += GameManager.GRID_SIZE;
			if(y+radius >= GameStage.LOSE_LINE) destroy(); 
			canvas.setTranslateY(y-radius);
//			System.out.println("pwr move");
		}
	}
	
	

}
