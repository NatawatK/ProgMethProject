package scene;


import org.dyn4j.geometry.Vector2;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Screen;
import logic.GameManager;
import logic.GameManager.GameState;
import logic.Holder;
import model.AimLine;
import model.Ball;
import model.Shooter;



public class GameStage extends Pane{
	public final static double GAME_WIDTH = 375 ;
	public final static double GAME_HEIGHT = 600;
	public final static double LOSE_LINE = GAME_HEIGHT - 50;
	protected static Canvas canvas ;
	
	public GameStage() {
		this.Initialize();
		this.setEvent();
		
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
	
	private void setEvent() {
		this.setOnMouseMoved(E -> {
			if(GameManager.getCurrentState() == GameState.aim) {
				Holder.getInstance().getAimLine().aimTo(E.getSceneX(), E.getSceneY());
				Holder.getInstance().getAimLine().setVisible(true);
			}
			else 
				Holder.getInstance().getAimLine().setVisible(false);
		});
		this.setOnMouseClicked(E -> {
			if(E.getButton() == MouseButton.SECONDARY) { Holder.getInstance().getShooter().retrieve();}
			if(GameManager.getCurrentState() != GameState.aim ) return ;
			if(E.getButton() == MouseButton.PRIMARY) {
				GameManager.shoot();
				System.out.println("Shoot to : " + E.getSceneX() + " " + E.getSceneY());
			}
			
			
		});
		
		this.setOnKeyPressed(E -> System.out.println(E.toString()));
		this.requestFocus();
	}
	public double getGAME_WIDTH() {
		return GAME_WIDTH;
	}

	public double getGAME_HEIGHT() {
		return GAME_HEIGHT;
	}
	
	
}
