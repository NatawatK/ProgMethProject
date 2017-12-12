package model;

import org.dyn4j.geometry.Vector2;

import javafx.scene.shape.Line;
import logic.GameManager;
import logic.GameManager.GameState;
import logic.Holder;

public class AimLine extends Line implements Movable{
	private static final double LIMITE_DEGREE = 15;
	private static final double MIN_RADIAN = Math.toRadians(LIMITE_DEGREE);
	@Override
	
	
	public void move() {
		// TODO Auto-generated method stub
		setStartX(Holder.getInstance().getShooter().x);
		setStartY(Holder.getInstance().getShooter().y);
		setEndX(Holder.getInstance().getShooter().x);
		setEndY(Holder.getInstance().getShooter().y);
	}
	
	public AimLine() {
		super();
		// TODO Auto-generated constructor stub
		this.setStyle("-fx-stroke: aqua; -fx-stroke-width: 3;" );
		move();
		Holder.getInstance().getGameStage().getChildren().add(this);
//		System.out.println("Aim line Created1!!");
	}


	public void aimTo(double xx,double yy) {
		double dx = xx - getStartX();
		double dy = (yy - getStartY())*-1;
		dy = Math.max(dy, Math.abs(dx) * Math.tan(MIN_RADIAN));
//		double rad = Math.atan2(dy , dx);
		this.setEndX(getStartX()+dx);
		this.setEndY(getStartY()+dy*-1);
		if(GameManager.getCurrentState() == GameState.aim) Holder.getInstance().getShooter().drawSpaceCraft();;
//		System.out.println("[" +  dx + "," + dy+ "]" + rad + "   " + Math.toDegrees(rad));
	}
	
	public double getDegree() {
		
		return Math.toDegrees(Math.atan2(getEndY() - getStartY(), getEndX() - getStartX()));
	}
	/*private double[] rotateLine(double radAngle) {
	    double x, y;
	    x = Math.cos(radAngle) * (this.getEndX() - this.getStartX()) - Math.sin(radAngle) * (this.getEndY() - this.getStartY()) + this.getStartX();
	    y = Math.sin(radAngle) * (getEndX() - getStartX()) + Math.cos(radAngle) * (getEndY() - getStartY()) + getStartY();
	    return new double[]{x, y};
	}*/
	
	public Vector2 getVector() {
		return new Vector2(getStartX(), getStartY(), getEndX(), getEndY());
	}
	
	public void reCenter() {
		this.setStartX(Holder.getInstance().getShooter().x);
		this.setStartY(Holder.getInstance().getShooter().y);
	}
	
	
	

	
	
	
	

	
	
	

}
