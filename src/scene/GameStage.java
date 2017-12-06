package scene;


import org.dyn4j.geometry.Vector2;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import logic.Holder;
import model.Ball;


public class GameStage extends Pane{
	public final static double GAME_WIDTH = 375 ;
	public final static double GAME_HEIGHT = 600;
	protected static Canvas canvas ;
	public GameStage() {
		this.Initialize();
		
		this.setOnMouseMoved(E -> {
			//System.out.println(E.getSceneX() + " " + E.getSceneY());
			
		});
		this.setOnMouseClicked(E -> {
			if(E.getButton() == MouseButton.PRIMARY) {
				Vector2 direction = new Vector2(GAME_WIDTH/2,GAME_HEIGHT-10,E.getSceneX(), E.getSceneY());
				Holder.getInstance().getShooter().shoot(direction);
				System.out.println("Shoot to" + E.getSceneX() + " " + E.getSceneY());
				
			}
			if(E.getButton() == MouseButton.SECONDARY) {
				for(Ball e : Holder.getInstance().getBallHolder())
					e.down();
				System.out.println("Retrieve!");
			}
			
			//testBall(ball);
		});
		
		this.setOnKeyPressed(E -> {
			if(E.getCode() == KeyCode.BACK_SPACE) {
				for(Ball e : Holder.getInstance().getBallHolder())
					e.down();
				System.out.println("Retrieve!");
			}
		});
	}
	
	private void Initialize() {
		this.setWidth(GAME_WIDTH);
		this.setHeight(GAME_HEIGHT);
		canvas = new Canvas(GAME_WIDTH, GAME_HEIGHT);
		this.getChildren().add(canvas);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.setStroke(Color.RED);
		
		gc.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gc.strokeRect(0, 0, getWidth(), getHeight());
		
		gc.setFill(Color.WHEAT);
		gc.fillText("BBTAN", 290, 600);
	}
	
	public double getGAME_WIDTH() {
		return GAME_WIDTH;
	}

	public double getGAME_HEIGHT() {
		return GAME_HEIGHT;
	}
	
	
}
