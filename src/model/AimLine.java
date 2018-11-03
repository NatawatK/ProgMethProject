package model;

import org.dyn4j.geometry.Vector2;

import exception.MinDegreeExceedException;
import javafx.scene.shape.Line;
import logic.GameManager;
import logic.GameManager.GameState;
import logic.Holder;

public class AimLine extends Line{
	private static final double LIMITE_DEGREE = 15;
	private static final double MIN_RADIAN = Math.toRadians(LIMITE_DEGREE);
	
	public AimLine() {
		super();
		// TODO Auto-generated constructor stub
		this.setStyle("-fx-stroke: aqua; -fx-stroke-width: 3;" );
//		move();
		setStartX(Holder.getInstance().getShooter().x);
		setStartY(Holder.getInstance().getShooter().y);
		setEndX(Holder.getInstance().getShooter().x);
		setEndY(Holder.getInstance().getShooter().y-1);
		Holder.getInstance().getGameStage().getChildren().add(this);
//		System.out.println("Aim-line Created!!");
	}
	
	
	public void aimTo(double xx,double yy) throws MinDegreeExceedException{
<<<<<<< HEAD
		if(yy<50) return;
=======
>>>>>>> 159751500d0efa0a1717de865e78087068b3e5bb
		double dx = xx - getStartX();
		double dy = (yy - getStartY())*-1;
		//		double rad = Math.atan2(dy , dx);
		if( dy < Math.abs(dx) * Math.tan(MIN_RADIAN))
			throw new MinDegreeExceedException();
		else {
			this.setEndX(getStartX()+dx);
		this.setEndY(getStartY()+dy*-1);
		if(GameManager.getCurrentState() == GameState.aim) 
			Holder.getInstance().getShooter().drawSpaceCraft();;
		}
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
