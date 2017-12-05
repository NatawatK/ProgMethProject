package scene;


import org.dyn4j.geometry.Vector2;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import model.Ball;


public class GameStage extends GridPane{
	public final static int GAME_WIDTH = 800;
	public final static int GAME_HEIGHT = 600;
	
	protected Canvas canvas ;
	public GameStage() {
		this.Initialize();
		
		this.setOnMouseMoved(E -> {
			System.out.println(E.getSceneX() + " " + E.getSceneY());
			
		});
		this.setOnMouseClicked(E -> {
			Vector2 direction = new Vector2(GAME_WIDTH/2,GAME_HEIGHT-10,E.getSceneX(), E.getSceneY());
			Ball ball = new Ball(GAME_WIDTH/2,GAME_HEIGHT-10, direction);
			System.out.println("Shoot to" + E.getSceneX() + " " + E.getSceneY());
			testBall(ball);
		});
	}
	
	private void Initialize() {
		this.setGridLinesVisible(true);
		this.setWidth(GAME_WIDTH);
		this.setHeight(GAME_HEIGHT);
		canvas = new Canvas(GAME_WIDTH, GAME_HEIGHT);
		this.getChildren().add(canvas);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, getWidth(), getHeight());
		gc.setFill(Color.WHITE);
		gc.fillText("BBTAN", 100, 200);
	}
	
	private void testBall(Ball ball) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		while(! ball.isDestroyed()) {
			ball.move();
			ball.draw(gc);
			ball.print();
		}
		
	}

}
