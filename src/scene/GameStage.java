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
	protected static Canvas canvas ;
	
	public GameStage() {
		this.Initialize();
		
		
		this.setOnMouseMoved(E -> {
			Holder.getInstance().getAimLine().aimTo(E.getSceneX(), E.getSceneY());
		});
		this.setOnMouseClicked(E -> {
			if(E.getButton() == MouseButton.PRIMARY) {
				Holder.getInstance().getShooter().shoot();
				System.out.println("Shoot to" + E.getSceneX() + " " + E.getSceneY());
//				GameManager.setState(GameManager.GameState.Shoot);
			}
			if(E.getButton() == MouseButton.SECONDARY) {
				for(Ball e : Holder.getInstance().getBallContainer())
					e.down();
				System.out.println("Retrieve!");
			}
			if(E.getButton() == MouseButton.MIDDLE) {
				GameManager.setState(GameState.LvlUp);
				System.out.println("Lvl Up!!");
			}
			
			//testBall(ball);
		});
		
		this.setOnKeyPressed(E -> {
			if(E.getCode() == KeyCode.SPACE) {
				for(Ball e : Holder.getInstance().getBallContainer())
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
